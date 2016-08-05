package com.example.v_wenjiw.messagesformultiple;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Vibrator;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends Activity {

    EditText textReceivers, textMessage;
    Button btnSend;

    SmsManager smsManager;
    ArrayList<String> SendList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vibrator vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);

        textReceivers = (EditText) findViewById(R.id.textReceivers);
        textMessage = (EditText) findViewById(R.id.textMessage);
        btnSend = (Button) findViewById(R.id.btnSendMessage);
        smsManager = SmsManager.getDefault();


        textReceivers.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                BaseAdapter adapter = new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return cursor.getCount();
                    }

                    @Override
                    public Object getItem(int i) {
                        return i;
                    }

                    @Override
                    public long getItemId(int i) {
                        return i;
                    }

                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        cursor.moveToPosition(i);
                        View item = MainActivity.this.getLayoutInflater().inflate(R.layout.listphoneitem, null);

                        CheckBox cb = (CheckBox) item.findViewById(R.id.itemCB);
                        TextView textName = (TextView) item.findViewById(R.id.name);
                        TextView textNumber = (TextView) item.findViewById(R.id.number);
                        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        cb.setChecked(isChecked(number));
                        textName.setText(name);
                        textNumber.setText(number);

                        return item;
                    }
                };

                View listPhoneView = MainActivity.this.getLayoutInflater().inflate(R.layout.listnumbers, null);
                final ListView listPhones = (ListView) listPhoneView.findViewById(R.id.listPhones);
                listPhones.setAdapter(adapter);
                listPhones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        CheckBox cb = (CheckBox) listPhones.getChildAt(i).findViewById(R.id.itemCB);
                        cb.setChecked(!cb.isChecked());
                        Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
                    }
                });


                new AlertDialog.Builder(MainActivity.this).setView(listPhoneView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SendList.clear();
                                for (int k = 0; k < listPhones.getCount(); k++) {
                                    CheckBox cb = (CheckBox) listPhones.getChildAt(k).findViewById(R.id.itemCB);
                                    TextView itemNumber = (TextView) listPhones.getChildAt(k).findViewById(R.id.number);
                                    if (cb.isChecked()) {
                                        SendList.add(itemNumber.getText().toString());
                                    }
                                }

                                textReceivers.setText(SendList.toString().replace("[", "").replace("]", ""));
                            }
                        })
                        .show();

                return true;
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (String number : SendList) {
                    PendingIntent intent = PendingIntent.getActivity(MainActivity.this, 0, new Intent(), 0);

                    smsManager.sendTextMessage(number, null, textMessage.getText().toString(), intent, null);
                }

                Toast.makeText(MainActivity.this, "短信发送成功！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isChecked(String number) {
        for (String itemNumber : SendList) {
            if (itemNumber.equals(number)) {
                return true;
            }
        }

        return false;
    }
}
