package com.example.v_wenjiw.message;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by v-wenjiw on 7/20/2016.
 */
public class SendSmsListener implements View.OnLongClickListener {

    private Activity act;
    private EditText address;
    private EditText content;

    public SendSmsListener(Activity act,EditText address,EditText content)
    {
        this.act=act;
        this.address=address;
        this.content=content;
    }

    @Override
    public boolean onLongClick(View source)
    {
        String addressStr=address.getText().toString();
        String contentStr=content.getText().toString();
        SmsManager manager=SmsManager.getDefault();
        PendingIntent intent=PendingIntent.getBroadcast(act,0,new Intent(),0);
        manager.sendTextMessage(addressStr,null,contentStr,intent,null);
        Toast.makeText(this.act,"短信发送成功！",Toast.LENGTH_SHORT).show();
        return true;
    }
}
