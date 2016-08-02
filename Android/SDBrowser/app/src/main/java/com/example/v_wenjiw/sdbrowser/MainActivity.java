package com.example.v_wenjiw.sdbrowser;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView text;
    ListView list;

    File currentParent;
    File[] currentFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        text = (TextView) findViewById(R.id.path);

        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(MainActivity.this, "未检测到SD卡！", Toast.LENGTH_LONG).show();
            return;
        }

        File root = Environment.getExternalStorageDirectory();
        if (root.exists()) {
            currentParent = root;
            currentFiles = currentParent.listFiles();
            inflateListView(currentFiles);
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (currentFiles[i].isFile()) {
                    return;
                }

                File[] temp = currentFiles[i].listFiles();
                if (temp == null || temp.length == 0) {
                    Toast.makeText(MainActivity.this, "该目录为空", Toast.LENGTH_SHORT).show();
                } else {
                    currentParent = currentFiles[i];
                    currentFiles = temp;
                    inflateListView(currentFiles);
                }
            }
        });

        Button parent = (Button) findViewById(R.id.parent);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!currentParent.getCanonicalPath().equals("/storage/sdcard")) {
                        currentParent = currentParent.getParentFile();
                        currentFiles = currentParent.listFiles();
                        inflateListView(currentFiles);
                    }
                } catch (IOException e) {
                    Log.i("Exception", e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    private void inflateListView(File[] files) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < files.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            if (files[i].isDirectory()) {
                listItem.put("icon", R.drawable.folder_128);
            } else {
                listItem.put("icon", R.drawable.file_128);
            }

            listItem.put("fileName", files[i].getName());
            listItems.add(listItem);
        }

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, listItems, R.layout.line, new String[]{"icon", "fileName"}, new int[]{R.id.imageView, R.id.textView});
        list.setAdapter(adapter);
        try {
            text.setText("当前路径为：" + currentParent.getCanonicalPath());
        } catch (IOException e) {
            Log.i("Exception", e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
