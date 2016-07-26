package com.example.v_wenjiw.gallerydemo;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] imageIds=new int[]{R.drawable.a1_128,R.drawable.a2_128,R.drawable.a3_128,R.drawable.a4_128,R.drawable.a5_128,R.drawable.a6_128,R.drawable.a7_128};

    Gallery gallery;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery=(Gallery)findViewById(R.id.gallery);
        imageView=(ImageView)findViewById(R.id.imageView);

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
                imageView.setLayoutParams(new Gallery.LayoutParams(75,100));
//                TypedArray typedArray=obtainStyledAttributes(R.styleable.Gallery);

//                imageView.setBackgroundResource(typedArray.getResourceId(R.styleable.Gallery_android_galleryItemBackground,0));
                return imageView;
            }
        };

        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
