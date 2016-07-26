package com.example.v_wenjiw.popupwindowdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * Created by v-wenjiw on 05/10/2016.
 */
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LayoutInflater inflater= (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View root=inflater.inflate(R.layout.popup,null);

        final PopupWindow popup =new PopupWindow(root,280,460);
        Button btn=(Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                popup.showAsDropDown(v);
                popup.showAtLocation(findViewById(R.id.button), Gravity.CENTER,20,20);
            }
        });

        root.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });

    }
}
