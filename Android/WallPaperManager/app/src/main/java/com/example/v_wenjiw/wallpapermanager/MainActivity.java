package com.example.v_wenjiw.wallpapermanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);

        final Button btnStart = (Button) findViewById(R.id.btnStart);
        final Button btnStop = (Button) findViewById(R.id.btnStop);

       final Intent intent = new Intent(MainActivity.this, ChangeService.class);
//        final PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, 500, pi);
                startService(intent);
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
                Toast.makeText(MainActivity.this, "启动成功！", Toast.LENGTH_SHORT).show();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
                btnStart.setEnabled(true);
                btnStop.setEnabled(false);
//                alarmManager.cancel(pi);
                Toast.makeText(MainActivity.this, "关闭成功！", Toast.LENGTH_SHORT).show();
            }
        });

        ((Button) findViewById(R.id.btnSet)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperManager manager = WallpaperManager.getInstance(MainActivity.this);
                try {
//                    manager.clear();
                    manager.setResource(R.drawable.a1);
                    Toast.makeText(MainActivity.this, "设置成功！", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}
