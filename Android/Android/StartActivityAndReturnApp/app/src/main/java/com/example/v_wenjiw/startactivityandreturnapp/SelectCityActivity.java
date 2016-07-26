package com.example.v_wenjiw.startactivityandreturnapp;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
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

public class SelectCityActivity extends ExpandableListActivity {

    private String[] province = {"广东", "广西", "湖南"};

    private String[][] cities = {
            {"广州", "深圳", "珠海", "中山"},
            {"桂林", "柳州", "南宁", "北海"},
            {"长沙", "岳阳", "衡阳", "株洲"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return cities[groupPosition][childPosition];
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return cities[groupPosition].length;
            }

            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(SelectCityActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView text = getTextView();
                text.setText(getChild(groupPosition, childPosition).toString());
                return text;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return province[groupPosition];
            }

            @Override
            public int getGroupCount() {
                return province.length;
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout li = new LinearLayout(SelectCityActivity.this);
                li.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo = new ImageView(SelectCityActivity.this);
                li.addView(logo);
                TextView text = getTextView();
                text.setText(getGroup(groupPosition).toString());
                li.addView(text);
                return li;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }
        };

        setListAdapter(adapter);
        getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Intent intent = getIntent();
                intent.putExtra("city", cities[i][i1]);
                SelectCityActivity.this.setResult(1, intent);
                SelectCityActivity.this.finish();
                return false;
            }
        });
    }
}
