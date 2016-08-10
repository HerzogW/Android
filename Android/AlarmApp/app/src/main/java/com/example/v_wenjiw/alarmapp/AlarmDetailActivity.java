package com.example.v_wenjiw.alarmapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.v_wenjiw.alarmapp.DataBaseHelper.AlarmDBHelper;

import java.util.Date;

public class AlarmDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_detail);

        Intent intent = getIntent();

        long newId = intent.getLongExtra("ItemId", 0);//无法获取传过来的Id
        AlarmDBHelper dbHelper = new AlarmDBHelper(AlarmDetailActivity.this, "AlarmDB", 1);

        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from Alarm where _id = ?", new String[]{String.valueOf(newId)});
        if (cursor != null && cursor.moveToFirst()) {
            cursor.getCount();
            String title = cursor.getString(cursor.getColumnIndex("title"));
            long triggerTime = cursor.getLong(cursor.getColumnIndex("triggerTime"));
            Date date = new Date(triggerTime);
            ((TextView) findViewById(R.id.textTitle)).setText(title);
            ((TextView) findViewById(R.id.textTriggerTime)).setText(date.toString());
        }
        ((Button) findViewById(R.id.btnClose)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
