package com.example.v_wenjiw.changepicturebytime;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int[] pictures = {R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,
            R.drawable.p10};

    int currentImageId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView image = (ImageView) findViewById(R.id.imageView);
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    String currentId=currentImageId+"";
                    Toast.makeText(MainActivity.this, currentId, Toast.LENGTH_SHORT).show();
                    image.setImageResource(pictures[currentImageId++ % pictures.length]);
                }
            }
        };

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 5000);
    }
}
