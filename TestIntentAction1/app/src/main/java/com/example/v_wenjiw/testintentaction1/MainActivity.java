package com.example.v_wenjiw.testintentaction1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction("TestAction");
                startActivity(intent);
            }
        });

        ((Button)findViewById(R.id.answer)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_ANSWER);
                startActivity(intent);// android.content.ActivityNotFoundException: No Activity found to handle Intent { act=android.intent.action.ANSWER }
            }
        });
    }
}
