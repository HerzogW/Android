package com.example.v_wenjiw.xmlresourcemenudemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by v-wenjiw on 05/11/2016.
 */
public class MainActivity extends Activity {

    TextView text;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text=(TextView)findViewById(R.id.text);
        registerForContextMenu(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflator=new MenuInflater(this);
        inflator.inflate(R.menu.items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        if(mi.isCheckable())
        {
            mi.setChecked(true);

            switch (mi.getItemId())
            {
                case R.id.font_10:
                    text.setTextSize(10*2);
                    break;
                case R.id.font_12:
                    text.setTextSize(12*2);
                    break;
                case R.id.font_14:
                    text.setTextSize(14*2);
                    break;
                case R.id.font_16:
                    text.setTextSize(16*2);
                    break;
                case R.id.font_18:
                    text.setTextSize(18*2);
                    break;
                case R.id.font_red:
                    text.setBackgroundColor(Color.RED);
                    break;
                case R.id.font_green:
                    text.setBackgroundColor(Color.GREEN);
                    break;
                case R.id.font_blue:
                    text.setBackgroundColor(Color.BLUE);
                    break;
                case R.id.plain_item:
                    Toast.makeText(MainActivity.this,"您点击了普通菜单选项",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,View source,ContextMenu.ContextMenuInfo menuInfo)
    {

        MenuInflater inflator=new MenuInflater(this);
        inflator.inflate(R.menu.context,menu);
        menu.setHeaderTitle("选择背景颜色");
        menu.setHeaderIcon(R.drawable.color_24);
    }

    @Override
    public boolean onContextItemSelected(MenuItem mi)
    {
        mi.setCheckable(true);
        switch(mi.getItemId())
        {
            case R.id.red:
                mi.setCheckable(true);
                text.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                mi.setCheckable(true);
                text.setBackgroundColor(Color.GREEN);
                break;

            case R.id.blue:
                mi.setCheckable(true);
                text.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}
