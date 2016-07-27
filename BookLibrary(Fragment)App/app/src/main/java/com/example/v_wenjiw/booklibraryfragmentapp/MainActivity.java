package com.example.v_wenjiw.booklibraryfragmentapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.v_wenjiw.booklibraryfragmentapp.Fragment.BookDetailFragment;
import com.example.v_wenjiw.booklibraryfragmentapp.Fragment.BookListFragment;

public class MainActivity extends Activity implements BookListFragment.Callbacks {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_twopane);
    }

    @Override
    public void onItemSelected(Integer id) {
        Bundle arguments = new Bundle();
        arguments.putInt(BookDetailFragment.ITEM_ID, id);
        BookDetailFragment fragment = new BookDetailFragment();
        fragment.setArguments(arguments);
        getFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
    }
}
