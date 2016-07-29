package com.example.v_wenjiw.showallapppackagename;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PackageManager packageManager;
    TextView packageNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packageManager = this.getPackageManager();
        packageNames = (TextView) findViewById(R.id.packageName);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);
                StringBuilder result = new StringBuilder();
                if (packageInfoList != null) {
                    for (int i = 0; i < packageInfoList.size(); i++) {
                        if (packageInfoList.get(i).packageName.equals("com.tencent.mobileqq")) {

                            result.append(packageInfoList.get(i).packageName + "\n");
                        }
                    }
                }

                packageNames.setText(result.toString());
            }
        });

    }
}
