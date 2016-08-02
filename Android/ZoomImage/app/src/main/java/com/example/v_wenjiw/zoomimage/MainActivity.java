package com.example.v_wenjiw.zoomimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends Activity implements GestureDetector.OnGestureListener {

    GestureDetector detector;
    ImageView image;
    Bitmap bitmap;
    int width, height;
    float currentScale = -1;
    Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        detector = new GestureDetector(MainActivity.this, MainActivity.this);
        image = (ImageView) findViewById(R.id.image);
        matrix = new Matrix();
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.weixin);

        width = bitmap.getWidth();
        height = bitmap.getHeight();
        image.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.weixin));
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return detector.onTouchEvent(me);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        velocityX = velocityX > 4000 ? 4000 : velocityX;
        velocityY = velocityY < -4000 ? -4000 : velocityY;

        currentScale += currentScale * velocityX / 4000.0f;
        currentScale = currentScale > 0.01 ? currentScale : 0.01f;
        matrix.reset();

        matrix.setScale(currentScale, currentScale, 160, 200);
        BitmapDrawable tmp = (BitmapDrawable) image.getDrawable();
        if (!tmp.getBitmap().isRecycled()) {
            tmp.getBitmap().recycle();
        }

        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        image.setImageBitmap(bitmap2);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
}
