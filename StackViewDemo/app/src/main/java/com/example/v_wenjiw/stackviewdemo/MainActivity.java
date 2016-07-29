package com.example.v_wenjiw.stackviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    StackView stackView;
    int[] imageIds=new int[]{R.drawable.a1_128,R.drawable.a2_128,R.drawable.a3_128,R.drawable.a4_128,R.drawable.a5_128,R.drawable.a6_128,R.drawable.a7_128};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stackView=(StackView)findViewById(R.id.stackView);

        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<imageIds.length;i++)
        {
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }

        SimpleAdapter adapter=new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.image1});
        stackView.setAdapter(adapter);
    }

    public void prev(View source)
    {
        stackView.showPrevious();
    }

    public void next(View source)
    {
        stackView.showNext();
    }
}
