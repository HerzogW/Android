package com.example.v_wenjiw.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnBind, btnUnBind,btnGetServiceStatus;
    MyService.MyBinder binder;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("--Service Connected--");
            binder=(MyService.MyBinder)service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("--Service Disconnected--");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBind=(Button)findViewById(R.id.btnBind);
        btnUnBind=(Button)findViewById(R.id.btnUbBind);
        btnGetServiceStatus=(Button)findViewById(R.id.btnGetServiceStatus);
        btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                bindService(intent,conn, Service.BIND_AUTO_CREATE);
            }
        });

        btnUnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(conn);
            }
        });

        btnGetServiceStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Service的count值为："+binder.getCount(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
