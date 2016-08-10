package com.example.v_wenjiw.musicplayer;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btnProv, btnPlay, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver = getContentResolver();
        btnProv = (Button) findViewById(R.id.btnProv);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnNext = (Button) findViewById(R.id.btnNext);

        final ListView musicList = (ListView) findViewById(R.id.musicList);
        final Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            BaseAdapter adapter = new BaseAdapter() {
                @Override
                public int getCount() {
                    return cursor.getCount();
                }

                @Override
                public Object getItem(int i) {
                    cursor.moveToPosition(i);
                    String musicName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                    String musicSinger = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));

                    LinearLayout item = new LinearLayout(MainActivity.this);
                    ViewGroup.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    item.setLayoutParams(params);
                    item.setOrientation(LinearLayout.VERTICAL);

                    TextView itemName = new TextView(MainActivity.this);
                    itemName.setLayoutParams(params);
                    itemName.setText(musicName);
                    itemName.setTextSize(20);
                    item.addView(itemName);

                    TextView itemSinger = new TextView(MainActivity.this);
                    itemSinger.setLayoutParams(params);
                    itemSinger.setText(musicSinger);
                    itemSinger.setTextSize(12);
                    item.addView(itemSinger);

                    return item;
                }

                @Override
                public long getItemId(int i) {
                    cursor.moveToPosition(i);
                    return cursor.getLong(cursor.getColumnIndex("_id"));
                }

                @Override
                public View getView(int i, View view, ViewGroup viewGroup) {
                    cursor.moveToPosition(i);
                    String musicName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                    String musicSinger = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));

                    LinearLayout item = new LinearLayout(MainActivity.this);
                    ViewGroup.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    item.setLayoutParams(params);
                    item.setOrientation(LinearLayout.VERTICAL);

                    TextView itemName = new TextView(MainActivity.this);
                    itemName.setLayoutParams(params);
                    itemName.setText(musicName);
                    itemName.setTextSize(20);
                    item.addView(itemName);

                    TextView itemSinger = new TextView(MainActivity.this);
                    itemSinger.setLayoutParams(params);
                    itemSinger.setText(musicSinger);
                    itemSinger.setTextSize(12);
                    item.addView(itemSinger);

                    return item;
                }
            };

            musicList.setAdapter(adapter);

            musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    cursor.moveToPosition(i);
                    long selectedId = cursor.getLong(cursor.getColumnIndex("_id"));

                    String musicName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                    String musicSinger = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                    String musicData = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));//获取到媒体文件在本地的存储路径
                }
            });

        } else {
            Toast.makeText(MainActivity.this, "获取数据失败！", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent e)
    {

        return true;
    }
}
