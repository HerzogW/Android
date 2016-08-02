package com.example.v_wenjiw.newwordlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ListView listView = (ListView) findViewById(R.id.listView);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //@SuppressWarnings("unchecked");
        List<Map<String, String>> list = (List<Map<String, String>>) bundle.getSerializable("data");
        SimpleAdapter adapter = new SimpleAdapter(ResultActivity.this, list, R.layout.line, new String[]{"word", "detail"}, new int[]{R.id.Item_word, R.id.Item_detail});
        listView.setAdapter(adapter);

        ((Button)findViewById(R.id.btnClose)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
