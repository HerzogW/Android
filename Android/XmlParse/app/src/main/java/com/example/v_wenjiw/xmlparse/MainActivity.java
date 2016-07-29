package com.example.v_wenjiw.xmlparse;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XmlResourceParser xrp = getResources().getXml(R.xml.books);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
                        if (xrp.getEventType() == XmlResourceParser.START_TAG) {
                            String tagName = xrp.getName();
                            if (tagName.equals("book")) {
                                String price = xrp.getAttributeValue(null, "price");
                                sb.append("价格：");
                                sb.append(price);
                                String date = xrp.getAttributeName(1);
                                sb.append("   出版日期：");
                                sb.append(date);
                                sb.append("   书名：");
                                sb.append(xrp.nextText());
                            }
                            sb.append("\n");
                        }
                        xrp.next();
                    }

                    TextView result = (TextView) findViewById(R.id.result);
                    result.setText(sb.toString());

                } catch (XmlPullParserException ex) {
                    ex.printStackTrace();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }
}
