package com.example.v_wenjiw.contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        registerForContextMenu(text);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View source, ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.add(0,1,0,"红色");
        menu.add(0,2,0,"绿色");
        menu.add(0,3,0,"蓝色");

        menu.setGroupCheckable(0,true,true);
        menu.setHeaderTitle("选择背景色");
    }

    @Override
    public boolean onContextItemSelected(MenuItem mi)
    {
        switch (mi.getItemId())
        {
            case 1:
                text.setBackgroundColor(Color.RED);
                break;
            case 2:
                text.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                text.setBackgroundColor(Color.BLUE);
                break;
        }

        return true;
    }
}
