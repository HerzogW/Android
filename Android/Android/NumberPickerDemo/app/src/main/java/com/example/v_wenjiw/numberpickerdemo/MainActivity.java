package com.example.v_wenjiw.numberpickerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.internal.app.ToolbarActionBar;
import android.widget.AbsListView;
import android.widget.NumberPicker;
import android.widget.Toast;

/**
 * Created by v-wenjiw on 05/04/2016.
 */
public class MainActivity extends Activity {

    String[] arr=new String[]{"天安门","故宫","中南海","天坛","长城","雍和宫"};
    NumberPicker np1,np2,np3;
    int minPrice=25,maxPrice=75;
    @Override
    public void onCreate(Bundle savedInstancedState)
    {
        super.onCreate(savedInstancedState);
        setContentView(R.layout.main_layout);

        np1=(NumberPicker)findViewById(R.id.np1);
                np1.setMinValue(minPrice);
        np1.setMaxValue(maxPrice);
        np1.setValue(minPrice);
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minPrice=newVal;
                showSelectedPrice();
            }
        });

        np2=(NumberPicker)findViewById(R.id.np2);
        np2.setMinValue(60);
        np2.setMaxValue(100);
        np2.setValue(maxPrice);

        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                maxPrice=newVal;
                showSelectedPrice();
            }
        });

        np3=(NumberPicker)findViewById(R.id.np3);
        np3.setMinValue(0);
        np3.setMaxValue(arr.length-1);
        np3.setDisplayedValues(arr);
        np3.setValue(0);

        np3.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                switch(scrollState)
                {
                    case NumberPicker.OnScrollListener.SCROLL_STATE_FLING:
                    Toast.makeText(MainActivity.this,"后续滑动（飞啊飞，根本停不下来）",Toast.LENGTH_LONG).show();
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        Toast.makeText(MainActivity.this,"不滑动", Toast.LENGTH_LONG).show();
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        Toast.makeText(MainActivity.this,"滑动中",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    private void showSelectedPrice()
    {
        Toast.makeText(MainActivity.this,"您选择的最低价格为："+minPrice+",最高价格为："+maxPrice,Toast.LENGTH_SHORT).show();
    }
}
