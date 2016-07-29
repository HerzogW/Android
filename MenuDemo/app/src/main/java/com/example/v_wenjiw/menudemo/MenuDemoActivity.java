package com.example.v_wenjiw.menudemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by v-wenjiw on 05/11/2016.
 */
public class MenuDemoActivity extends AppCompatActivity {

    final int FONT_10=0x111;
    final int FONT_12=0x112;
    final int FONT_14=0x113;
    final int FONT_16=0x114;
    final int FONT_18=0x115;

    final int PLAIN_ITEM=0x11b;

    final int FONT_RED=0x116;
    final int FONT_BLUE=0x117;
    final int FONT_GREEN=0x118;

    private EditText edit;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        edit=(EditText)findViewById(R.id.edit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        SubMenu fontMenu=menu.addSubMenu("字体大小");

        fontMenu.setIcon(R.drawable.a1_24);
        fontMenu.setHeaderIcon(R.drawable.a1_24);

        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0,FONT_10,4,"10号字体");
        fontMenu.add(0,FONT_12,3,"12号字体");
        fontMenu.add(0,FONT_14,2,"14号字体");
        fontMenu.add(0,FONT_16,1,"16号字体");
        fontMenu.add(0,FONT_18,0,"18号字体");

        fontMenu.setGroupCheckable(0,true,false);

        menu.add(0,PLAIN_ITEM,0,"普通菜单项");

        SubMenu colorMenu=menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.drawable.color_24);
        colorMenu.setHeaderIcon(R.drawable.color_24);
        colorMenu.setHeaderTitle("选择文字颜色");

        colorMenu.add(0,FONT_RED,0,"红色");
        colorMenu.add(0,FONT_GREEN,0,"绿色");
        colorMenu.add(0,FONT_BLUE,0,"蓝色");
        Intent intent=new Intent(MenuDemoActivity.this,OtherActivity.class);
        MenuItem mi= menu.add("OtherActivity").setIntent(intent);//若是重写了onOptionsItemSelected(MenuItem mi)方法，则此处设置的Intent是无效的
//        menu.add(0,0,0,"OtherActivity").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Intent intent=new Intent(MenuDemoActivity.this,OtherActivity.class);
//                startActivity(intent);
//                return false;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }

//    @Override     //若重写了该方法，则setIntent设置失效
//    public boolean onOptionsItemSelected(MenuItem mi)
//    {
//        switch (mi.getItemId())
//        {
//            case FONT_10:
//                edit.setTextSize(10*2);
//                break;
//            case FONT_12:
//                edit.setTextSize(12*2);
//                break;
//            case FONT_14:
//                edit.setTextSize(14*2);
//                break;
//            case FONT_16:
//                edit.setTextSize(16*2);
//                break;
//            case FONT_18:
//                edit.setTextSize(18*2);
//                break;
//
//            case FONT_RED:
//                edit.setTextColor(Color.RED);
//                break;
//            case FONT_GREEN:
//                edit.setTextColor(Color.GREEN);
//                break;
//            case FONT_BLUE:
//                edit.setTextColor(Color.BLUE);
//                break;
//            case PLAIN_ITEM:
//                Toast.makeText(this,"您点击了普通菜单",Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return true;
//    }
}
