package com.example.v_wenjiw.progressdialogdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

/**
 * Created by v-wenjiw on 05/10/2016.
 */
public class MainActivity extends Activity {

    final static int MAX_PROGRESS=100;
    private int[] data=new int[50];
    int progressStatus=0;
    int hasData=0;
    ProgressDialog pd1,pd2;

    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what==0x123)
            {
                pd2.setProgress(progressStatus);
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn=(Button)findViewById(R.id.button);
        Button btn2=(Button)findViewById(R.id.button2);
        Button btn3=(Button)findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpinner(v);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIndeterminate(v);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress(v);
            }
        });
    }

    public void showSpinner(View source)
    {
        ProgressDialog.show(this,"任务执行中","任务执行中，请等待",false,true);
    }

    public void showIndeterminate(View source)
    {
        pd1=new ProgressDialog(MainActivity.this);
        pd1.setTitle("任务正在执行中");
        pd1.setMessage("任务正在执行中，敬请等待...");
        pd1.setCancelable(true);
        pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd1.setIndeterminate(false);
        pd1.show();
    }

    public void showProgress(View source)
    {
        progressStatus=0;
        hasData=0;
        pd2=new ProgressDialog(MainActivity.this);
        pd2.setTitle("任务完成百分比");
        pd2.setMessage("耗时任务的百分比");
        pd2.setCancelable(false);
        pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd2.setIndeterminate(false);
        pd2.show();
        new Thread()
        {
            public void run() {
                while (progressStatus < MAX_PROGRESS) {
                    progressStatus = MAX_PROGRESS * doWork() / data.length;
                    handler.sendEmptyMessage(0x123);
                }
                if (progressStatus >= MAX_PROGRESS)
                {
                    pd2.dismiss();
                }
            }
        }.start();
    }

    public int doWork()
    {
        data[hasData++]=(int)(Math.random()*100);
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return hasData;
    }
}
