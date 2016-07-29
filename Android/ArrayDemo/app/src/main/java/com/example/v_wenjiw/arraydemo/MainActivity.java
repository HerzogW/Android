package com.example.v_wenjiw.arraydemo;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texts = MainActivity.this.getResources().getStringArray(R.array.string_arr);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return texts.length;
            }

            @Override
            public Object getItem(int i) {
                return texts[i];
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                TextView textView = new TextView(MainActivity.this);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                Resources res = MainActivity.this.getResources();
                textView.setWidth(150);
                textView.setHeight(50);
                textView.setText(texts[i]);

                TypedArray icons = res.obtainTypedArray(R.array.plain_arr);
//                textView.setBackground(icons.getDrawable(i));
                textView.setBackgroundColor(icons.getColor(i, 0));
                textView.setTextSize(16);
                return textView;
            }
        };


        GridView grid = (GridView) findViewById(R.id.gridView);
        grid.setAdapter(adapter);
    }
}
