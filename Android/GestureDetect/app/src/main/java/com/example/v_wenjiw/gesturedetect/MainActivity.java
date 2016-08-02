package com.example.v_wenjiw.gesturedetect;

import android.app.Activity;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends Activity implements GestureDetector.OnGestureListener {

    GestureDetector detector;
    TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log = (TextView) findViewById(R.id.log);
        detector = new GestureDetector(MainActivity.this, MainActivity.this);

        ((Button) findViewById(R.id.clear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                log.setText("");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return detector.onTouchEvent(me);
    }

    @Override
    public boolean onDown(MotionEvent e) {
//        Toast.makeText(MainActivity.this, "onDown", Toast.LENGTH_SHORT).show();
        writeLog("onDown");
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        Toast.makeText(MainActivity.this, "onFling", Toast.LENGTH_SHORT).show();
        writeLog("onFling");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
//        Toast.makeText(MainActivity.this, "onLongPress", Toast.LENGTH_SHORT).show();
        writeLog("onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        Toast.makeText(MainActivity.this, "onScroll", Toast.LENGTH_SHORT).show();
        writeLog("onScroll");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
//        Toast.makeText(MainActivity.this, "onShowPress", Toast.LENGTH_SHORT).show();
        writeLog("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
//        Toast.makeText(MainActivity.this, "onSingleTapUp", Toast.LENGTH_SHORT).show();
        writeLog("onSingleTapUp");
        return false;
    }


    private void writeLog(String message) {
        Date now = new Date();
        String currentLog = now.toString() + "   " + message + "\n";
        String originalLog = log.getText().toString();
        log.setText(currentLog + originalLog);
    }
}
