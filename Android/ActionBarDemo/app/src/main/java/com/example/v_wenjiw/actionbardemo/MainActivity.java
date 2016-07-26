package com.example.v_wenjiw.actionbardemo;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by v-wenjiw on 05/16/2016.
 */
public class MainActivity extends Activity {

    ActionBar actionBar;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        actionBar=getActionBar();

        Button btn=(Button)findViewById(R.id.button);
        Button btn2=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showActionBar(view);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideActionBar(view);
            }
        });
    }

    public void showActionBar(View source)
    {
        actionBar.show();
    }

    public void hideActionBar(View source)
    {
        actionBar.hide();
    }
}
