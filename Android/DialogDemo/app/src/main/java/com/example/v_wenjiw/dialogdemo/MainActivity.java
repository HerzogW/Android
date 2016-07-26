package com.example.v_wenjiw.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * Created by v-wenjiw on 05/09/2016.
 */
public class MainActivity extends Activity {

    Button btn,btn2,btn3,btn4,btn5,btn6,btn7;
    TableLayout loginForm;
    TextView text;
    String[] items=new String[]{"Java","C#","PHP","C++"};
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        text=(TextView)findViewById(R.id.textView);

        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simple(v);
            }
        });

        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleList(v);
            }
        });

        btn3=(Button)findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleChoice(v);
            }
        });

        btn4=(Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiChoice(v);
            }
        });

        btn5=(Button)findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customList(v);
            }
        });

        btn6=(Button)findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView(v);
            }
        });
    }

    public void simple(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("简单对话框")
                .setIcon(R.drawable.a1_24)
                .setMessage("对话框测试内容\n第二行内容");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btn.setText("确定");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btn.setText("取消");
            }
        });
        builder.create().show();
    }

    public void simpleList(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("简单列表对话框")
                .setIcon(R.drawable.a1_24)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        text.setText("您选中了《"+items[which]+"》");
                    }
                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();

    }

    public void simpleChoice(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("单选列表对话框")
                .setIcon(R.drawable.a1_24)
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        text.setText("您选中了《"+items[which]+"》");
                    }
                })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create().show();
    }

    public void multiChoice(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("多选列表对话框")
                .setIcon(R.drawable.a1_24)
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setMultiChoiceItems(items,new boolean[]{false,true,false,true},null);

        builder.create().show();
    }

    public void customList(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this)
                .setTitle("自定义列表项对话框")
                .setIcon(R.drawable.a1_24)
                .setAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.array_item,items),null)
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();
    }

    public void customView(View source)
    {
        LayoutInflater inflater= getLayoutInflater();
//        inflater=LayoutInflater.from(MainActivity.this);
//        inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

        loginForm=(TableLayout)inflater.inflate(R.layout.login,null);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("自定义View对话框")
                .setIcon(R.drawable.a1_24)
                .setView(loginForm)
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText userId=(EditText) loginForm.findViewById(R.id.userId);
                        EditText psw=(EditText)loginForm.findViewById(R.id.psw);
                        EditText phone=(EditText)loginForm.findViewById(R.id.phone);

                        if(TextUtils.isEmpty(userId.getText())||TextUtils.isEmpty(psw.getText()))
                        {
                            text.setText("用户名、密码为空");
                        }
                        else if(TextUtils.isEmpty(phone.getText()))
                        {
                            text.setText("手机号码为空");
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText userId=(EditText) loginForm.findViewById(R.id.userId);
                        EditText psw=(EditText)loginForm.findViewById(R.id.psw);
                        EditText phone=(EditText)loginForm.findViewById(R.id.phone);
                        userId.setText("");
                        psw.setText("");
                        phone.setText("");
                    }
                })
                .create()
                .show();
    }
}
