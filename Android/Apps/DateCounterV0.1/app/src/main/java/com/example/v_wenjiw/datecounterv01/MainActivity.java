package com.example.v_wenjiw.datecounterv01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Date originDate=new Date(116,3,21,0,0,0);

    public ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList=(ListView)findViewById(R.id.mylist);

        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                LinearLayout line=new LinearLayout(MainActivity.this);
                line.setOrientation(LinearLayout.VERTICAL);

                TextView text1=new TextView(MainActivity.this);
                text1.setText(format.format(originDate));


                TextView text2=new TextView(MainActivity.this);

                Date now=new Date();
                long diff=now.getTime()-originDate.getTime();
                long days=diff/(1000*60*60*24);
                long hours=(diff-days*(1000*60*60*24))/(1000*60*60);
                long minutes=(diff-days*1000*60*60*24 - hours*1000*60*60)/(1000*60);
                text2.setText(days+"天"+hours+"小时"+minutes+"分钟");

                line.addView(text1);
                line.addView(text2);
                return line;
            }
        };

        myList.setAdapter(adapter);
    }
}
