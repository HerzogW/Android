package com.example.v_wenjiw.contextmenudemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    final int MENU1=0x111;
    final int MENU2=0x112;
    final int MENU3=0x113;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        registerForContextMenu(text);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View source,ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.add(0,MENU1,0,"红色");
        menu.add(0,MENU2,0,"绿色");
        menu.add(0,MENU3,0,"蓝色");

        menu.setGroupCheckable(0,true,true);
        menu.setHeaderTitle("选择背景色");
        menu.setHeaderIcon(R.drawable.color_24);
    }

    @Override
    public boolean onContextItemSelected(MenuItem mi)
    {
        mi.setCheckable(true);
        switch(mi.getItemId())
        {
            case MENU1:
                text.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                text.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                text.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}
