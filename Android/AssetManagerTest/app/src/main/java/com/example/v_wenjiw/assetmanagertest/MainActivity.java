package com.example.v_wenjiw.assetmanagertest;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mediaPlayer1 = MediaPlayer.create(MainActivity.this, R.raw.ThisisWhatItFeelsLike);

        AssetManager am = getAssets();
        try {
            AssetFileDescriptor afd = am.openFd("ThisisWhatItFeelsLike.mp3");
            mediaPlayer2 = new MediaPlayer();
            mediaPlayer2.setDataSource(afd.getFileDescriptor());
            mediaPlayer2.prepare();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (mediaPlayer1.isPlaying()) {
//                    mediaPlayer1.stop();
//                } else {
//                    mediaPlayer1.start();
//                }
            }
        });

        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer2.isPlaying()) {
                    mediaPlayer2.pause();
                } else {
                    mediaPlayer2.start();
                }
            }
        });
    }
}
