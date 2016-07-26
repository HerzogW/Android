package com.example.v_wenjiw.chronometer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer ch;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch=(Chronometer)findViewById(R.id.chronometer);

        start=(Button)findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
                start.setEnabled(false);
            }
        });

        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                                            @Override
                                            public void onChronometerTick(Chronometer chronometer) {
                                                if(SystemClock.elapsedRealtime()-ch.getBase()>5*1000)
                                                {
                                                    ch.stop();
//                                                    ch.setBase(SystemClock.elapsedRealtime());
//                                                    ch.start();
//                                                    start.callOnClick();
                                                    start.setEnabled(true);
                                                }
                                            }
                                        }
        );
    }
}
