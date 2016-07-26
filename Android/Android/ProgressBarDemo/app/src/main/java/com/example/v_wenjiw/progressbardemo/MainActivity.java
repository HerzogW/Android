package com.example.v_wenjiw.progressbardemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private int[] data=new int[100];
    int hasData=0;
    int status=0;
    ProgressBar p1,p2;

    Handler mHandler=new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what==0x111)
            {
                p1.setProgress(status);
                p2.setProgress(status);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1=(ProgressBar) findViewById(R.id.p1);
        p2=(ProgressBar)findViewById(R.id.p2);

        new Thread()
        {
            public void run()
            {
                while(status<100)
                {
                    status=doWork();
                    mHandler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }

    public int doWork()
    {
        data[hasData++] = (int) (Math.random() + 100);
        try
        {
            Thread.sleep(100);

        } catch (InterruptedException e)
        {
            e.printStackTrace();;
        }
        return hasData;
    }
}
