package com.example.v_wenjiw.message;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend=(Button)findViewById(R.id.BtnSend);
        EditText address=(EditText)findViewById(R.id.Address);
        EditText content=(EditText)findViewById(R.id.Content);

        btnSend.setOnLongClickListener(new SendSmsListener(this,address,content));
    }
}
