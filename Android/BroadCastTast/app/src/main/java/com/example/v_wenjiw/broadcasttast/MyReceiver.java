package com.example.v_wenjiw.broadcasttast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by v-wenjiw on 8/8/2016.
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "接收到Intent的内容是：" + intent.getAction() + "\n 消息的内容是：" + intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
    }
}
