package com.example.v_wenjiw.gridviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    GridView mygrid;
    ImageView image;
    int[] imageIds=new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String ,Object>>  listItems=new ArrayList<Map<String,Object>>();

        for(int i=0;i<imageIds.length;i++)
        {
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }

        image=(ImageView)findViewById(R.id.image);
        SimpleAdapter adapter=new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.image1});

        mygrid=(GridView)findViewById(R.id.mygrid);
        mygrid.setAdapter(adapter);

        mygrid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                image.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mygrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                image.setImageResource(imageIds[position]);
            }
        });
    }
}
