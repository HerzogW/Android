package com.example.v_wenjiw.musicplayer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Color;
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

    Button btnPrev, btnPlay, btnNext;
    ActivityReceiver activityReceiver;

    public static final String CTL_ACTION = "CTL_ACTION";
    public static final String UPDATE_ACTION = "UPDATE_ACTION";
    private final int prev = 0, play = 1, pause = 2, next = 3, itemPlay = 4;
    private int status = 2;
    private long currentItemId;
    private int currentIndex = 0, maxIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver = getContentResolver();
        btnPrev = (Button) findViewById(R.id.btnProv);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnNext = (Button) findViewById(R.id.btnNext);

        activityReceiver = new ActivityReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPDATE_ACTION);
        this.registerReceiver(activityReceiver, filter);

        Intent serviceIntent = new Intent(MainActivity.this, MusicPlayerService.class);
        startService(serviceIntent);

        final ListView musicList = (ListView) findViewById(R.id.musicList);
        final Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            maxIndex = cursor.getCount();
            cursor.moveToFirst();
            currentItemId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));

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
                    itemName.setTextColor(Color.WHITE);
                    item.addView(itemName);

                    TextView itemSinger = new TextView(MainActivity.this);
                    itemSinger.setLayoutParams(params);
                    itemSinger.setText(musicSinger);
                    itemSinger.setTextSize(12);
                    itemSinger.setTextColor(Color.WHITE);
                    item.addView(itemSinger);

                    return item;
                }
            };

            musicList.setAdapter(adapter);

            musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    currentIndex = i;
                    cursor.moveToPosition(i);
                    currentItemId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));

                    View selectItem = musicList.getChildAt(i);
                    if (selectItem != null) {
                        selectItem.setBackgroundColor(Color.GREEN);
                    } else {
                        System.out.println("can not get childview at " + i);
                        System.out.println("path:" + path);
                    }

                    Intent intent = new Intent(CTL_ACTION);
                    intent.putExtra("id", currentItemId);
                    intent.putExtra("path", path);
                    intent.putExtra("control", itemPlay);
                    sendBroadcast(intent);
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "获取数据失败！", Toast.LENGTH_LONG).show();
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CTL_ACTION);
                cursor.moveToPosition(currentIndex);
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                intent.putExtra("id", currentItemId);
                intent.putExtra("path", path);
                intent.putExtra("control", status != play ? play : pause);
                sendBroadcast(intent);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex <= 0) {
                    currentIndex = 0;
                } else {
                    currentIndex--;
                    cursor.moveToPosition(currentIndex);
                    currentItemId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                    Intent intent = new Intent(CTL_ACTION);
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    intent.putExtra("id", currentItemId);
                    intent.putExtra("path", path);
                    intent.putExtra("control", play);
                    sendBroadcast(intent);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex < maxIndex - 1) {
                    currentIndex++;
                    cursor.moveToPosition(currentIndex);
                    currentItemId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                    Intent intent = new Intent(CTL_ACTION);
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    intent.putExtra("id", currentItemId);
                    intent.putExtra("path", path);
                    intent.putExtra("control", play);
                    sendBroadcast(intent);
                }
            }
        });
    }

    public class ActivityReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int newStatus = intent.getIntExtra("status", -1);
            switch (newStatus) {
                case play:
                    btnPlay.setText("暂停");
                    status = 1;
                    break;
                case pause:
                    btnPlay.setText("播放");
                    status = 2;
                    break;
            }
        }
    }
}
