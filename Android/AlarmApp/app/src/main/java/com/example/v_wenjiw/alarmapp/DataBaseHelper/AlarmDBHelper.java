package com.example.v_wenjiw.alarmapp.DataBaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by v-wenjiw on 8/5/2016.
 */
public class AlarmDBHelper extends SQLiteOpenHelper {

    final String CREATE_TABLE_SQL = "Create table Alarm(_id integer primary key autoincrement," +
            "title varchar(50)," +
            "triggertime integer)";

    public AlarmDBHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.setVersion(newVersion);
    }
}
