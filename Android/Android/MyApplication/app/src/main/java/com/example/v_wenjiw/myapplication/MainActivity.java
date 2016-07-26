package com.example.v_wenjiw.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list1=(ListView)findViewById(R.id.list1);

        String[] arr1={"微软","谷歌","亚马逊"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.array_item,arr1);

        list1.setAdapter(adapter1);

        ListView list2=(ListView)findViewById(R.id.list2);
        String[] arr2={"Net","Java","PHP"};
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout.checked_item,arr2);
        list2.setAdapter(adapter2);
    }
}
