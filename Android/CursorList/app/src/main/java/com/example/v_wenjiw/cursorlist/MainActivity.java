package com.example.v_wenjiw.cursorlist;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

    SQLiteDatabase db;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir() + "/mydb.db3", null);


        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        list = (ListView) findViewById(R.id.list);
        inflateListView();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText title = (EditText) findViewById(R.id.title);
                EditText content = (EditText) findViewById(R.id.content);

                if (title.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "请填写title", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (content.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "请填写content", Toast.LENGTH_SHORT).show();
                    return;
                }

                insertData(db, title.getText().toString(), content.getText().toString());
                inflateListView();
            }
        });
    }

    private void insertData(SQLiteDatabase db, String title, String content) {
        try {
            db.execSQL("insert into news_info values(null,?,?)", new String[]{title, content});
        } catch (SQLiteException e) {
            db.execSQL("Create table news_info(_id integer primary key autoincrement," +
                    "news_title varchar(50)," +
                    "news_content varchar(255))");
            db.execSQL("insert into news_info values(null,?,?)", new String[]{title, content});
            e.printStackTrace();
        }
    }

    private void deleteData(SQLiteDatabase db, int id) {
        try {
            db.execSQL("Delete from news_info where _id=?", new String[]{String.valueOf(id)});
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    private void inflateListView() {
        Cursor cursor;
        try {
            cursor = db.rawQuery("select * from news_info", null);
        } catch (SQLiteException e) {
            db.execSQL("Create table news_info(_id integer primary key autoincrement," +
                    "news_title varchar(50)," +
                    "news_content varchar(255))");
            cursor = db.rawQuery("select * from news_info", null);
        }
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this, R.layout.lineitem, cursor, new String[]{"news_title", "news_content", "_id"}, new int[]{R.id.ItemTitle, R.id.ItemContent, R.id.ItemId}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        list.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (db != null || db.isOpen()) {
            db.close();
        }
    }
}
