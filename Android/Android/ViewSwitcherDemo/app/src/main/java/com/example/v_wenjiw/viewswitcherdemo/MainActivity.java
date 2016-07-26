package com.example.v_wenjiw.viewswitcherdemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int NUMBER_PER_SCREEN=12;

    public static class DataItem
    {
        public String dataName;
        public Drawable drawable;
    }
    private ArrayList<DataItem> items=new ArrayList<DataItem>();

    private int screenNo=-1;
    private int screenCount;
    ViewSwitcher viewSwitcher;

    LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater=LayoutInflater.from(MainActivity.this);
        for(int i=0;i<40;i++) {
            String label=" "+i;
            Drawable drawable=getResources().getDrawable(R.drawable.a1_24);
            DataItem item=new DataItem();
            item.dataName=label;
            item.drawable=drawable;
            items.add(item);

        }

        screenCount=items.size()%NUMBER_PER_SCREEN ==0 ? items.size()/NUMBER_PER_SCREEN:items.size()/NUMBER_PER_SCREEN+1;

        viewSwitcher=(ViewSwitcher)findViewById(R.id.viewSwitcher);
        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.slidelistview,null);
            }
        });
        next(null);
    }

    public void next(View v)
    {
        if(screenNo<screenCount-1)
        {
            screenNo++;
            viewSwitcher.setInAnimation(this,R.anim.slide_in_right);
            viewSwitcher.setOutAnimation(this,R.anim.slide_out_left);
            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showNext();
        }
    }

    public void prev(View v)
    {
        if(screenNo>0)
        {
            screenNo--;
            viewSwitcher.setInAnimation(this,R.anim.slide_in_left);
            viewSwitcher.setOutAnimation(this,R.anim.slide_out_right);
            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showPrevious();
        }
    }

    private BaseAdapter adapter=new BaseAdapter()
    {
        @Override
        public int getCount()
        {
            if(screenNo==screenCount-1&&items.size()%NUMBER_PER_SCREEN!=0)
            {
                return items.size()%NUMBER_PER_SCREEN;
            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int position)
        {
            return items.get(screenNo*NUMBER_PER_SCREEN+position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        public View getView(int position,View convertView,ViewGroup parent)
        {
            View view=convertView;
            if(convertView==null)
            {
                view=inflater.inflate(R.layout.labelicon,null);
            }
            ImageView image=(ImageView)view.findViewById(R.id.image);
            image.setImageDrawable(getItem(position).drawable);
            TextView text=(TextView)view.findViewById(R.id.text1);
            text.setText(getItem(position).dataName);
            return view;
        }
    };
}
