package com.example.v_wenjiw.observersms;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getContentResolver().registerContentObserver(Uri.parse("content://sms"),true,new SMSObserver());

    }

    public final class SMSObserver extends ContentObserver {

        public SMSObserver() {
            super(new Handler());
        }

        @Override
        public void onChange(boolean SelfChange) {
//            Cursor cursor = MainActivity.this.getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
            Cursor cursor = MainActivity.this.getContentResolver().query(Uri.parse("content://sms/sent"), null, null, null, null);
            while (cursor.moveToNext()) {
                StringBuilder sb = new StringBuilder();
                sb.append("address=").append(cursor.getString(cursor.getColumnIndex("address")));
                sb.append(";subject=").append(cursor.getString(cursor.getColumnIndex("subject")));
                sb.append(";body=").append(cursor.getString(cursor.getColumnIndex("body")));
                sb.append(";time=").append(cursor.getString(cursor.getColumnIndex("date")));
                System.out.println("收到短信：" + sb.toString());

            }
        }
    }

}
