package com.example.v_wenjiw.musicplayer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    Button btnPrev, btnPlay, btnNext;
    ActivityReceiver activityReceiver;
    SeekBar seekBar;
    Switch btnLoop;

    Timer timer;
    public static final String CTL_ACTION = "CTL_ACTION";
    public static final String UPDATE_ACTION = "UPDATE_ACTION";
    private final int prev = 0, play = 1, pause = 2, next = 3, itemPlay = 4, loop = 5, position = 6;
    private int status = -1;
    private int currentIndex = 0, maxIndex = 0;


    private int titleId, singerId;
    MusicPlayerService.MusicBinder binder;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MusicPlayerService.MusicBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver = getContentResolver();
        btnPrev = (Button) findViewById(R.id.btnProv);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnNext = (Button) findViewById(R.id.btnNext);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        btnLoop = (Switch) findViewById(R.id.btnLoop);

        titleId = TextView.generateViewId();
        singerId = TextView.generateViewId();

        activityReceiver = new ActivityReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPDATE_ACTION);
        this.registerReceiver(activityReceiver, filter);

        Intent serviceIntent = new Intent(MainActivity.this, MusicPlayerService.class);
        startService(serviceIntent);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (binder != null) {
                    seekBar.setProgress(binder.getCurrentPosition());
                }
            }
        }, 0, 100);

        final ListView musicList = (ListView) findViewById(R.id.musicList);
        final Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            maxIndex = cursor.getCount();
            cursor.moveToFirst();
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
                    itemName.setId(titleId);
                    itemName.setLayoutParams(params);
                    itemName.setText(musicName);
                    itemName.setTextSize(20);
                    itemName.setTextColor(Color.WHITE);
                    item.addView(itemName);

                    TextView itemSinger = new TextView(MainActivity.this);
                    itemSinger.setId(singerId);
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
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    int duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                    seekBar.setMax(duration);

                    View selectItem = musicList.getChildAt(i - musicList.getFirstVisiblePosition());
                    if (selectItem != null) {
                        selectItem.setBackgroundColor(Color.GREEN);
                    }

                    Intent intent = new Intent(CTL_ACTION);
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
                intent.putExtra("path", path);
                intent.putExtra("control", status == -1 ? itemPlay : status != play ? play : pause);
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
                    Intent intent = new Intent(CTL_ACTION);
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
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
                    Intent intent = new Intent(CTL_ACTION);
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    intent.putExtra("path", path);
                    intent.putExtra("control", play);
                    sendBroadcast(intent);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Intent updatePositionIntent = new Intent(CTL_ACTION);
                updatePositionIntent.putExtra("control", position);
                updatePositionIntent.putExtra("updatePosition", i);
                sendBroadcast(updatePositionIntent);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, btnLoop.isChecked() ? "单曲循环" : "单曲播放", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CTL_ACTION);
                intent.putExtra("control", loop);
                intent.putExtra("loop", btnLoop.isChecked());
                sendBroadcast(intent);
            }
        });
    }

    public class ActivityReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int newStatus = intent.getIntExtra("status", -1);
            int currentPosition = intent.getIntExtra("currentPosition", 0);
            switch (newStatus) {
                case 1:
                    btnPlay.setText("暂停");
                    status = 1;
                    break;
                case 2:
                    btnPlay.setText("播放");
                    status = 2;
                    break;
                case 3:
                    seekBar.setProgress(currentPosition);
                    break;
            }
        }
    }
}
