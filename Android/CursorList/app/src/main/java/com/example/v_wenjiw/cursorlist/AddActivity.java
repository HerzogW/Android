package com.example.v_wenjiw.cursorlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        Button btnBack=(Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnInsert=(Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText title=(EditText)findViewById(R.id.title);
                EditText content=(EditText)findViewById(R.id.content);

                if(title.getText().toString().equals(""))
                {
                    Toast.makeText(AddActivity.this,"请填写title",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(content.getText().toString().equals(""))
                {
                    Toast.makeText(AddActivity.this,"请填写content",Toast.LENGTH_SHORT).show();
                    return;
                }


            }
        });
    }
}
