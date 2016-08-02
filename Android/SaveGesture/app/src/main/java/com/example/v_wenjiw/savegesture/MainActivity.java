package com.example.v_wenjiw.savegesture;

import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    GestureOverlayView gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gesture = (GestureOverlayView) findViewById(R.id.gesture);
        gesture.setGestureColor(Color.BLUE);
        gesture.setGestureStrokeWidth(3);
        gesture.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView gestureOverlayView, final Gesture gesture) {
                View saveDialog = getLayoutInflater().inflate(R.layout.save, null);
                ImageView imageView = (ImageView) saveDialog.findViewById(R.id.imageView);
                final EditText gestureName = (EditText) saveDialog.findViewById(R.id.gestureName);
                Bitmap bitmap = gesture.toBitmap(128, 128, 10, 0xffff0000);
                imageView.setImageBitmap(bitmap);

                new AlertDialog.Builder(MainActivity.this).setView(saveDialog).setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        GestureLibrary gesturelb= GestureLibraries.fromFile("/storage/sdcard/mygestures");
                        gesturelb.addGesture(gestureName.getText().toString(),gesture);
                        gesturelb.save();
                    }
                }).setNegativeButton("取消",null).show();
            }
        });
    }
}
