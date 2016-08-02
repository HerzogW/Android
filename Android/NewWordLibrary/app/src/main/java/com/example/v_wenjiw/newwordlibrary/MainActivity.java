package com.example.v_wenjiw.newwordlibrary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.v_wenjiw.newwordlibrary.Helper.NewWordDatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    NewWordDatabaseHelper dbHelper;
    Button btnInsert;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new NewWordDatabaseHelper(MainActivity.this, "NewWordLibrary.db3", 1);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText word = (EditText) findViewById(R.id.title);
                EditText detail = (EditText) findViewById(R.id.detail);
                if (word.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "请填写\"Word\"", Toast.LENGTH_SHORT).show();
                    return;
                }

                insertData(dbHelper.getWritableDatabase(), word.getText().toString(), detail.getText().toString());
                word.setText("");
                detail.setText("");
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = ((EditText) findViewById(R.id.searchText)).getText().toString();
                Cursor cursor = dbHelper.getReadableDatabase().rawQuery("Select * from dict where word like ? or detail like ? ", new String[]{"%" + key + "%", "%" + key + "%"});

//                Cursor cursor = dbHelper.getReadableDatabase().rawQuery("Select * from dict", null);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", ConvertCursorToList(cursor));
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.btnClear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase().execSQL("delete from dict");
                Toast.makeText(MainActivity.this, "表单清空完成", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public ArrayList<Map<String, String>> ConvertCursorToList(Cursor cursor) {
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        while (cursor.moveToNext()) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("word", cursor.getString(1));
            map.put("detail", cursor.getString(2));
            result.add(map);
        }

        return result;
    }


    private void insertData(SQLiteDatabase db, String word, String detail) {
        try {
            db.execSQL("Insert into dict values(null,?,?)", new String[]{word, detail});
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}
