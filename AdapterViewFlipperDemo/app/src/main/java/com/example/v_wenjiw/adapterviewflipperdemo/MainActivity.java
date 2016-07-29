package com.example.v_wenjiw.adapterviewflipperdemo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] imageIds=new int[]{R.drawable.a1_128,R.drawable.a2_128,R.drawable.a3_128,R.drawable.a4_128,R.drawable.a5_128,R.drawable.a6_128,R.drawable.a7_128};
    AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper=(AdapterViewFlipper)findViewById(R.id.flipper);

        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setImageResource(imageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };

        flipper.setAdapter(adapter);
    }

    public void prev(View source)
    {
        flipper.showPrevious();
        flipper.stopFlipping();
    }

    public void next(View source)
    {
        flipper.showNext();
        flipper.stopFlipping();
    }

    public void auto(View source)
    {
        flipper.startFlipping();
    }
}
