package com.example.v_wenjiw.alarmapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.v_wenjiw.alarmapp.DataBaseHelper.AlarmDBHelper;

import java.util.Date;

public class AlarmActivity extends Activity {

    AlarmDBHelper dbHelper;
    ListView alarmListView;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        System.out.println("--onCreate");

        alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final View line = (View) AlarmActivity.this.getLayoutInflater().inflate(R.layout.additem, null);
                new AlertDialog.Builder(AlarmActivity.this).setView(line).setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText textTitle = (EditText) line.findViewById(R.id.title);
                        TimePicker triggerTimer = (TimePicker) line.findViewById(R.id.triggerTimer);

                        String title = textTitle.getText().toString();
                        long triggerTime = triggerTimer.getDrawingTime();

                        ContentValues values = new ContentValues();
                        values.put("title", title);
                        values.put("triggerTime", triggerTime);
                        long newId = dbHelper.getWritableDatabase().insert("Alarm", null, values);

                        Intent intent = new Intent(AlarmActivity.this, AlarmDetailActivity.class);
                        intent.putExtra("ItemID", newId);
                        PendingIntent pi = PendingIntent.getActivity(AlarmActivity.this, 0, intent, 0);

//                         Toast.makeText(AlarmActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();

                        BuildListView();
                        startActivity(intent);
                    }
                }).setNegativeButton("取消", null).show();
            }
        });


        dbHelper = new AlarmDBHelper(AlarmActivity.this, "AlarmDB", 1);

        alarmListView = (ListView) findViewById(R.id.list_item);
        BuildListView();
        alarmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final long id = alarmListView.getItemIdAtPosition(i);
                new AlertDialog.Builder(AlarmActivity.this).setTitle("删除该记录？")
                        .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dbHelper.getWritableDatabase().delete("Alarm", "_id=?", new String[]{String.valueOf(id)});
                                BuildListView();
                            }
                        })
                        .setNegativeButton("取消", null).show();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("--onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbHelper != null) {
            dbHelper.close();
        }
    }

    private void BuildListView() {
        final Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from Alarm", null);
        cursor.moveToFirst();

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return cursor.getCount();
            }

            @Override
            public Object getItem(int i) {
                return alarmListView.getChildAt(i);
            }

            @Override
            public long getItemId(int i) {
                cursor.moveToPosition(i);
                long id = cursor.getLong(cursor.getColumnIndex("_id"));
                return id;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                cursor.moveToPosition(i);

                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                int triggerTime = cursor.getInt(cursor.getColumnIndex("triggerTime"));
                Date date = new Date(triggerTime);

                LinearLayout item = new LinearLayout(AlarmActivity.this);
                ViewGroup.LayoutParams param = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                item.setLayoutParams(param);
                item.setOrientation(LinearLayout.VERTICAL);

                TextView textTitle = new TextView(AlarmActivity.this);
                textTitle.setText(title);
                item.addView(textTitle);

                TextView textTriggerTime = new TextView(AlarmActivity.this);
                textTriggerTime.setText(date.toString());
                item.addView(textTriggerTime);

                return item;
            }
        };
        alarmListView.setAdapter(adapter);
    }
}
