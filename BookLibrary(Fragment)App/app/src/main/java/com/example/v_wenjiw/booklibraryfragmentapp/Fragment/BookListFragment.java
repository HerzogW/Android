package com.example.v_wenjiw.booklibraryfragmentapp.Fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.pm.LauncherApps;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.v_wenjiw.booklibraryfragmentapp.Entity.BookContent;

/**
 * Created by v-wenjiw on 7/26/2016.
 */
public class BookListFragment extends ListFragment {

    private Callbacks mCallback;

    public interface Callbacks {
        public void onItemSelected(Integer id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(), android.R.layout.simple_list_item_activated_1, android.R.id.text1, BookContent.ITEMS));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("BookListFragment 所在的Activity必须实现 Callbacks 接口！");
        }

        mCallback = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    @Override
    public void onListItemClick(ListView listview, View view, int position, long id) {
        super.onListItemClick(listview, view, position, id);
        mCallback.onItemSelected(BookContent.ITEMS.get(position).id);
    }

    public void setActivateItemClick(boolean activateOnItemClick) {
        getListView().setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
    }
}
