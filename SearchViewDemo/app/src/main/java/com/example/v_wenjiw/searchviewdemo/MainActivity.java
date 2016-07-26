package com.example.v_wenjiw.searchviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * Created by v-wenjiw on 05/09/2016.
 */
public class MainActivity extends Activity {

    private SearchView sv;
    private ListView lv;
    private String[] mStrings={"aaaaa","bbbbb","ccccc"};
    @Override
    public void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.main_layout);

        lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mStrings));

        lv.setTextFilterEnabled(false);

        sv=(SearchView)findViewById(R.id.sv);
        sv.setIconifiedByDefault(false);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,"您的选择是："+query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //通过获取adapter来设置文本过滤，可去掉悬浮框效果，该方法可以不用启用ListView的过滤功能
                ListAdapter adapter=lv.getAdapter();
                if(adapter instanceof Filterable)
                {
                    Filter filter=((Filterable)adapter).getFilter();
                    if(TextUtils.isEmpty(newText))
                    {
                        filter.filter(null);
                    }
                    else
                    {
                        filter.filter(newText);
                    }
                }

                //直接设置ListView 文本过滤，将显示悬浮框效果
//                if(TextUtils.isEmpty(newText))
//                {
//                    lv.clearTextFilter();
//                }
//                else
//                {
//                    lv.setFilterText(newText);
//                }
                return true;
            }
        });
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("查找");
    }
}
