package com.example.v_wenjiw.notificationdemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by v-wenjiw on 05/09/2016.
 */
public class MainActivity extends Activity {

    static final int NOTIFICATION_ID=0x123;
    NotificationManager nm;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(v);
            }
        });

    }

    public void send(View source)
    {
        Intent intent=new Intent(MainActivity.this,OtherActivity.class);
        PendingIntent pIntent= PendingIntent.getActivity(MainActivity.this,0,intent,0);

        Notification notify=new Notification.Builder(MainActivity.this)
                .setAutoCancel(true)
                .setTicker("新消息")
                .setSmallIcon(R.drawable.a1_24)
                .setContentTitle("一条新通知")
                .setContentText("恭喜您，您加薪了，工资增加30%")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pIntent)
                .build();

        nm.notify(NOTIFICATION_ID,notify);
    }

    public void del(View v)
    {
        nm.cancel(NOTIFICATION_ID);
    }
}
