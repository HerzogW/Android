package com.example.v_wenjiw.bundleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView name = (TextView) findViewById(R.id.name);
        TextView pwd = (TextView) findViewById(R.id.pwd);
        TextView gender = (TextView) findViewById(R.id.gender);

        Intent intent = getIntent();
        Person p = (Person) intent.getSerializableExtra("person");
        name.setText("您的用户名为：" + p.name);
        pwd.setText("您的密码为：" + p.psw);
        gender.setText("您的性别为：" + p.gender);
    }
}
