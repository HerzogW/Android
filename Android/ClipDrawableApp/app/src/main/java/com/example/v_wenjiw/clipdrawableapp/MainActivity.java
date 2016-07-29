package com.example.v_wenjiw.clipdrawableapp;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ImageView image = (ImageView) findViewById(R.id.image);
        final ClipDrawable drawable = (ClipDrawable) image.getDrawable();

        final Handler handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    drawable.setLevel(drawable.getLevel() + 200);
                }
            }
        };

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0x123;
                if (drawable.getLevel() >= 10000) {
                    this.cancel();
                } else {
                    handler.sendMessage(msg);
                }
            }
        }, 0, 100);


        final ImageView imageView=(ImageView)findViewById(R.id.imageView);
        final Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.my_anim);


        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(anim);
            }
        });
    }
}
