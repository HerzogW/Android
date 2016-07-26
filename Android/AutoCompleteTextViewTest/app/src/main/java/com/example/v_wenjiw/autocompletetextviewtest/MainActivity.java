package com.example.v_wenjiw.autocompletetextviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {


    AutoCompleteTextView autoText;
    MultiAutoCompleteTextView multiAutoText;

    String[] books=new String[]{"疯狂Java讲义","疯狂xml讲义","疯狂Ajax讲义","疯狂WorkFlow讲义"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,books);

        autoText=(AutoCompleteTextView)findViewById(R.id.autoText);

        autoText.setAdapter(aa);

        multiAutoText=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoText);
        multiAutoText.setAdapter(aa);

        multiAutoText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
