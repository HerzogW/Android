package com.example.v_wenjiw.textswitcherdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    TextSwitcher textSwitcher;
    String[] Strs=new String[]{"疯狂Java讲义","疯狂XML讲义","疯狂Ajax讲义","疯狂Android讲义"};
    int curStr=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSwitcher=(TextSwitcher)findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView=new TextView(MainActivity.this);
                textView.setTextSize(40);
                textView.setTextColor(Color.MAGENTA);

                return textView;
            }
        });
        next(null);

    }

    public void next(View v)
    {
        textSwitcher.setText(Strs[curStr++ % Strs.length]);
    }
}
