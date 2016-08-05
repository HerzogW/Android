package com.example.v_wenjiw.imageviewlist;

import android.app.Activity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    List<String> names = new ArrayList<String>();
    List<String> descs = new ArrayList<String>();
    List<String> fileContents = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names.clear();
        descs.clear();
        fileContents.clear();

        Cursor cursor = this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
            String desc = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DESCRIPTION));
            byte[] data = cursor.getBlob(cursor.getColumnIndex(MediaStore.Images.Media.DATA));

            names.add(name);
            descs.add(desc);
            fileContents.add(new String(data, 0, data.length - 1));
        }

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", names.get(i));
            map.put("desc", descs.get(i));
//            map.put("data", BitmapFactory.decodeFile(fileContents.get(i)));
            listItems.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, listItems, R.layout.listitem, new String[]{"name", "desc"}, new int[]{R.id.title, R.id.desc});

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ViewGroup viewDialog = (ViewGroup) getLayoutInflater().inflate(R.layout.view_dialog, null);
                ImageView image = (ImageView) viewDialog.findViewById(R.id.imageView);
                image.setImageBitmap(BitmapFactory.decodeFile(fileContents.get(i)));

                new AlertDialog.Builder(MainActivity.this).setView(viewDialog).setNegativeButton("关闭", null).show();
            }
        });
    }
}
