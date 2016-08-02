package com.example.v_wenjiw.newwordlibrary.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by v-wenjiw on 8/1/2016.
 */
public class NewWordDatabaseHelper extends SQLiteOpenHelper {

    final String CREATE_TABLE_SQL = "Create table dict(_id integer primary key autoincrement," +
            "word," +
            "detail)";

    public NewWordDatabaseHelper(Context context, String name, int vision) {
        super(context, name, null, vision);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVision, int newVision) {
        System.out.println("--------onUpgrade Called---------\n" + oldVision + "---->" + newVision);
    }
}
