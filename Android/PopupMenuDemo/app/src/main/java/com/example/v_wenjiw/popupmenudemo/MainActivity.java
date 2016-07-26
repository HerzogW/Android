package com.example.v_wenjiw.popupmenudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by v-wenjiw on 05/11/2016.
 */
public class MainActivity extends Activity {

    PopupMenu popup=null;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPopupButtonClick(v);
            }
        });
    }
    public void onPopupButtonClick(View button)
    {
        popup=new PopupMenu(this,button);
        getMenuInflater().inflate(R.menu.popup_menu,popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                switch(item.getItemId()) {
                    case R.id.exit:
                        popup.dismiss();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "您单击了【" + item.getTitle() + "】菜单项", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        popup.show();
    }
}
