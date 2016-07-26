package com.example.v_wenjiw.datepickerandtimerpickerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by v-wenjiw on 05/04/2016.
 */
public class MainActivity extends Activity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    public void onCreate(Bundle savedInstancedState)
    {
        super.onCreate(savedInstancedState);
        setContentView(R.layout.main_layout);

        DatePicker datePicker=(DatePicker) findViewById(R.id.datePicker);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);

        Calendar c= Calendar.getInstance();
        year= c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        hour=c.get(Calendar.HOUR);
        minute=c.get(Calendar.MINUTE);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year=year;
                MainActivity.this.month=month;
                MainActivity.this.day=day;
                showDate(year,month,day,hour,minute);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour=hour;
                MainActivity.this.minute=minute;
                showDate(year,month,day,hour,minute);
            }
        });
    }

    private void showDate(int year,int month,int day,int hour,int minute)
    {
        EditText showText=(EditText)findViewById(R.id.show);
        showText.setText("您的购买日期为："+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分");
    }
}
