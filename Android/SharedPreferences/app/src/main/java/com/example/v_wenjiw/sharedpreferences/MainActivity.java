package com.example.v_wenjiw.sharedpreferences;

import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = MainActivity.this.getSharedPreferences("pref", MODE_PRIVATE);
        editor = preferences.edit();

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = preferences.getString("time", null);
                int randNum = preferences.getInt("random", 0);

                String result = time == null ? "目前没有写入数据！" : "写入时间为：" + time + "\n上次生成的随机数为：" + randNum;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });

        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 " + "hh:mm:ss");

                editor.putString("time",(new Date()).toString());
                editor.putInt("random",(int)(Math.random()*100));
                editor.commit();
            }
        });
    }
}
