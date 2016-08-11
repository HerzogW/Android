package com.example.v_wenjiw.musicplayer;

import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;

import java.io.IOException;

/**
 * Created by v-wenjiw on 8/9/2016.
 */
public class MusicPlayerService extends Service {

    MediaPlayer player;
    AssetManager assetManager;
    ServiceReceiver serviceReceiver;
    private long currentId = 0;
    private final int prev = 0, play = 1, pause = 2, next = 3, itemPlay = 4;
    public static final String CTL_ACTION = "CTL_ACTION";
    public static final String UPDATE_ACTION = "UPDATE_ACTION";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        player = new MediaPlayer();
        assetManager = getAssets();
        serviceReceiver = new ServiceReceiver();
        IntentFilter filter = new IntentFilter(CTL_ACTION);
        registerReceiver(serviceReceiver, filter);
    }

    @Override
    public void onDestroy() {
        player.reset();
        assetManager.close();
    }

    public class ServiceReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            long selectedId = intent.getLongExtra("id", -1);
            String path = intent.getStringExtra("path");
            int control = intent.getIntExtra("control", 2);
            int status = -1;
            try {
                switch (control) {
                    case prev:
                        status = 0;
                        break;
                    case next:
                        status = 3;
                        break;
                    case play:
                        player.start();
                        status = 1;
                        break;
                    case pause:
                        player.pause();
                        status = 2;
                        break;
                    case itemPlay:
                        player.reset();
                        player.setDataSource(path);
                        player.prepare();
                        player.start();
                        status = 1;
                        break;
                }

                Intent backIntent = new Intent(UPDATE_ACTION);
                backIntent.putExtra("status", status);
                sendBroadcast(backIntent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
