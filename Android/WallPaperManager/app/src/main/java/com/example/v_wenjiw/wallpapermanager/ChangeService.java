package com.example.v_wenjiw.wallpapermanager;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class ChangeService extends Service {
    int[] wallpapers = {R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a9};

    WallpaperManager wallPaperManager;
    int current = 0;

    public ChangeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        wallPaperManager = WallpaperManager.getInstance(ChangeService.this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                if (current > 8) {
                    current = 0;
                }
                try {
                    wallPaperManager.setResource(wallpapers[current++]);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, 0, 5000);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        wallPaperManager = null;
    }
}
