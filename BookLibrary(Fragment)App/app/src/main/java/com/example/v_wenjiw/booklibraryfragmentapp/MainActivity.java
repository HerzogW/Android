package com.example.v_wenjiw.booklibraryfragmentapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.v_wenjiw.booklibraryfragmentapp.Fragment.BookDetailFragment;
import com.example.v_wenjiw.booklibraryfragmentapp.Fragment.BookListFragment;

public class MainActivity extends Activity implements BookListFragment.Callbacks {


    private boolean mTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        if (findViewById(R.id.book_detail_container) != null) {
            mTwoPane = true;
            ((BookListFragment) getFragmentManager().findFragmentById(R.id.book_list)).setActivateItemClick(true);
        }
    }

    @Override
    public void onItemSelected(Integer id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putInt(BookDetailFragment.ITEM_ID, id);
            BookDetailFragment fragment = new BookDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
        }
        else
        {
            Intent intent=new Intent(MainActivity.this,BookDetailActivity.class);
            intent.putExtra(BookDetailFragment.ITEM_ID,id);
            startActivity(intent);
        }
    }
}
