package com.example.v_wenjiw.plane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by v-wenjiw on 7/19/2016.
 */
public class PlaneView extends View {

    public float CurrentX;
    public float CurrentY;
    Bitmap plane;

    public PlaneView(Context context)
    {
        super(context);
        plane= BitmapFactory.decodeResource(context.getResources(), R.drawable.plane4);
        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint p=new Paint();
        canvas.drawBitmap(plane,CurrentX,CurrentY,p);
    }
}
