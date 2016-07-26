package com.example.v_wenjiw.actionbartabnavigationdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by v-wenjiw on 05/16/2016.
 */
public class MainActivity extends Activity implements ActionBar.TabListener {

    private static final String SELECTED_ITEM="selected_item";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ActionBar actionBar=getActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("第一页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("第二页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("第三页").setTabListener(this));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        if(savedInstanceState.containsKey(SELECTED_ITEM))
        {
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(SELECTED_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        outState.putInt(SELECTED_ITEM,getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTranscation)
    {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab,FragmentTransaction fragmentTransaction)
    {
        Fragment fragment=new DummyFragment();
        Bundle args=new Bundle();
        args.putInt(Fragment.ARG_SECTION_NUMBER,tab.getPosition()+1);

        fragment.setArguments(args);
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.container,fragment);
        ft.commit();
    }

}
