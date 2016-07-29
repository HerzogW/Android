package com.example.v_wenjiw.dateandtimepickerdialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by v-wenjiw on 05/10/2016.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c= Calendar.getInstance();
                new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker dp, int year, int month, int dayofMonth)
                    {
                        EditText show=(EditText)findViewById(R.id.show);
                        show.setText("您选择了："+year+"年"+(month+1)+"月"+dayofMonth+"日");
                    }
                },
                        c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        Button btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c= Calendar.getInstance();
                new TimePickerDialog(MainActivity.this,new TimePickerDialog.OnTimeSetListener()
                {
                   @Override
                    public void onTimeSet(TimePicker tp, int hourOfDay,int minute)
                   {
                       EditText show=(EditText)findViewById(R.id.show);
                       show.setText("您选择了："+hourOfDay+"时"+minute+"分");
                   }
                },
                        c.get(Calendar.HOUR_OF_DAY),
                        c.get(Calendar.MINUTE),
                        true
                ).show();
            }
        });
    }
}
