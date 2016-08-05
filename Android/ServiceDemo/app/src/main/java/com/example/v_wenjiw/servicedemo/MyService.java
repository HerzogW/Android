package com.example.v_wenjiw.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private int count;
    private boolean quit;
    private MyBinder binder = new MyBinder();

    public class MyBinder extends Binder {
        public int getCount() {
            return count;
        }
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("Service is binded!");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service is created!");

        new Thread() {
            @Override
            public void run() {
                while (!quit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    count++;
                }
            }

        }.start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("Service is unbinded!");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit = true;
        System.out.println("Service is Destroyed!");
    }
}
