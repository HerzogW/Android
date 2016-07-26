package com.example.v_wenjiw.expandablelistviewdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListAdapter adapter=new BaseExpandableListAdapter()
        {
            int[] logos=new int[]
                    {
                        R.drawable.a2,
                        R.drawable.a1,
                        R.drawable.a3
                    };

            private String[] armTypes=new String[]{"神族兵种","虫族兵种","人族兵种"};

            private String[][] arms=new String[][]
                    {
                            {"狂战士","龙骑士","黑暗圣堂","电兵"},
                            {"小狗","刺蛇","飞龙","自爆飞机"},
                            {"机枪兵","护士MM","幽灵"}
                    };
            @Override
            public Object getChild(int groupPosition,int childPosition)
            {
                return arms[groupPosition][childPosition];
            }
            @Override
            public long getChildId(int groupPosition,int childPosition)
            {
                return childPosition;
            }
            @Override
            public int getChildrenCount(int groupPosition)
            {
                return arms[groupPosition].length;
            }

            private TextView getTextView()
            {
                AbsListView.LayoutParams lp=new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView=new TextView(MainActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL| Gravity.LEFT);
                textView.setPadding(36,0,0,0);
                textView.setTextSize(16);
                return textView;
            }
            @Override
            public View getChildView(int groupPosition, int childPosition,boolean isLastChild,View convertView,ViewGroup parent)
            {
                TextView textView=getTextView();
                textView.setText(getChild(groupPosition,childPosition).toString());
                return textView;
            }
            @Override
            public Object getGroup(int groupPosition)
            {
                return armTypes[groupPosition];
            }
            @Override
            public int getGroupCount()
            {
                return armTypes.length;
            }

            public long getGroupId(int groupPosition)
            {
                return groupPosition;
            }

            public View getGroupView(int groupPosition,boolean isExpanded,View convertView,ViewGroup parent)
            {
                LinearLayout l1=new LinearLayout(MainActivity.this);
                l1.setOrientation(LinearLayout.VERTICAL);

                ImageView logo=new ImageView(MainActivity.this);
                logo.setImageResource(logos[groupPosition]);
                l1.addView(logo);

                TextView textView=getTextView();
                textView.setText(getGroup(groupPosition).toString());
                textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER);
                l1.addView(textView);

                return l1;
            }
            @Override
            public boolean isChildSelectable(int groupPosition,int childPosition)
            {
                return true;
            }
            @Override
            public boolean hasStableIds()
            {
                return true;
            }
        };

        ExpandableListView expandableListView=(ExpandableListView)findViewById(R.id.list);
        expandableListView.setAdapter(adapter);
    }
}
