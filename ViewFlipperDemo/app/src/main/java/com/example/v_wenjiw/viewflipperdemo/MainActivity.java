package com.example.v_wenjiw.viewflipperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper=(ViewFlipper)findViewById(R.id.details);

        ImageView image1=new ImageView(MainActivity.this);
        image1.setImageResource(R.drawable.a1);

        viewFlipper.addView(image1);

        ImageView image2=new ImageView(MainActivity.this);
        image2.setImageResource(R.drawable.a2);
        viewFlipper.addView(image2);
    }

    public void prev(View source)
    {
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);

        viewFlipper.showPrevious();
        viewFlipper.stopFlipping();
    }

    public void next(View source)
    {
        viewFlipper.setInAnimation(this,R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_right);
        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }

    public void auto(View source)
    {
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
        viewFlipper.startFlipping();
    }
}
