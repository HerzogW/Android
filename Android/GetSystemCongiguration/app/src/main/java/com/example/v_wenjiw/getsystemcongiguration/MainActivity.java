package com.example.v_wenjiw.getsystemcongiguration;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private TextView ori;
    private TextView navigation;
    private TextView touch;
    private TextView mnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ori = (TextView) findViewById(R.id.ori);
        navigation = (TextView) findViewById(R.id.navigation);
        touch = (TextView) findViewById(R.id.touch);
        mnc = (TextView) findViewById(R.id.mnc);
        Button btn = (Button) findViewById(R.id.BtnGetDeviceInfo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Configuration config = getResources().getConfiguration();
                String screen = config.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕" : "竖向屏幕";
                String mncCode = config.mnc + "";
                String naviName = config.orientation == Configuration.NAVIGATION_NONAV
                        ? "没有方向控制" : config.orientation == Configuration.NAVIGATION_WHEEL
                        ? "滚轮控制" : config.orientation == Configuration.NAVIGATION_DPAD ? "方向键控制方向" : "轨迹球控制方向";
                navigation.setText(naviName);
                String touchName = config.touchscreen ==
                        Configuration.TOUCHSCREEN_NOTOUCH ? "不支持触摸控制" : "支持触摸控制";
                ori.setText(screen);
                mnc.setText(mncCode);
                touch.setText(touchName);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        String screen = newConfig.orientation ==
//                Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕" : "竖向屏幕";
//        Toast.makeText(this, "系统的屏幕方向发生变化" + "\n修改后的屏幕方向为" + screen, Toast.LENGTH_SHORT).show();

        String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕" : "竖向屏幕";
        String mncCode = newConfig.mnc + "";
        String naviName = newConfig.orientation == Configuration.NAVIGATION_NONAV
                ? "没有方向控制" : newConfig.orientation == Configuration.NAVIGATION_WHEEL
                ? "滚轮控制" : newConfig.orientation == Configuration.NAVIGATION_DPAD ? "方向键控制方向" : "轨迹球控制方向";
        navigation.setText(naviName);
        String touchName = newConfig.touchscreen ==
                Configuration.TOUCHSCREEN_NOTOUCH ? "不支持触摸控制" : "支持触摸控制";
        ori.setText(screen);
        mnc.setText(mncCode);
        touch.setText(touchName);
        Toast.makeText(this, "系统的屏幕方向发生变化" + "\n修改后的屏幕方向为" + screen, Toast.LENGTH_SHORT).show();
    }
}
