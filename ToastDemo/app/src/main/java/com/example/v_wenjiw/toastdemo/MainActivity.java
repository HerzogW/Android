package com.example.v_wenjiw.toastdemo;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1=(Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast= Toast.makeText(MainActivity.this,"简单提示信息",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Button btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER,0,0);
                ImageView image=new ImageView(MainActivity.this);
                image.setImageResource(R.drawable.a);

                LinearLayout l1=new LinearLayout(MainActivity.this);
                l1.setOrientation(LinearLayout.VERTICAL);
                l1.addView(image);

                TextView text=new TextView(MainActivity.this);
                text.setText("带图片的提示信息");
                text.setTextSize(30);
                text.setTextColor(Color.MAGENTA);
                l1.addView(text);

                toast.setView(l1);

                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
