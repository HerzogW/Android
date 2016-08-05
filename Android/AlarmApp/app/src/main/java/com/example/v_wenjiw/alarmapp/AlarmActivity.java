package com.example.v_wenjiw.alarmapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
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

public class AlarmActivity extends Activity {

    AlarmDBHelper dbHelper;
    ListView alarmListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        System.out.println("--onCreate");

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
                        dbHelper.getWritableDatabase().insert("Alarm", null, values);

                        Toast.makeText(AlarmActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", null).show();

            }
        });

        dbHelper = new AlarmDBHelper(AlarmActivity.this, "AlarmDB", 1);

        alarmListView = (ListView) findViewById(R.id.list_item);

        final Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from Alarm", null);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return cursor.getCount();
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                cursor.moveToPosition(i);
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                return id;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                cursor.moveToPosition(i);

                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                long triggerTime = cursor.getLong(cursor.getColumnIndex("triggerTime"));

                LinearLayout item = new LinearLayout(AlarmActivity.this);
                ViewGroup.LayoutParams param = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                item.setLayoutParams(param);
                item.setOrientation(LinearLayout.VERTICAL);

                TextView textTitle = new TextView(AlarmActivity.this);
                textTitle.setText(title);
                item.addView(textTitle);

                TextView textTriggerTime = new TextView(AlarmActivity.this);
                textTriggerTime.setText(triggerTime + "");
                item.addView(textTriggerTime);

                return item;
            }
        };

        alarmListView.setAdapter(adapter);

        alarmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = (int) alarmListView.getItemAtPosition(i);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("--onResume");
        final Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from Alarm", null);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return cursor.getCount();
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                cursor.moveToPosition(i);
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                return id;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                cursor.moveToPosition(i);

                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                long triggerTime = cursor.getLong(cursor.getColumnIndex("triggerTime"));

                LinearLayout item = new LinearLayout(AlarmActivity.this);
                ViewGroup.LayoutParams param = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                item.setLayoutParams(param);
                item.setOrientation(LinearLayout.VERTICAL);

                TextView textTitle = new TextView(AlarmActivity.this);
                textTitle.setText(title);
                item.addView(textTitle);

                TextView textTriggerTime = new TextView(AlarmActivity.this);
                textTriggerTime.setText(triggerTime + "");
                item.addView(textTriggerTime);

                return item;
            }
        };

        alarmListView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}
