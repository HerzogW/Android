package com.example.v_wenjiw.drawballfollowfinger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by v-wenjiw on 7/20/2016.
 */
public class DrawBall extends View {

    public float currentX=40;
    public float currentY=40;

    Paint p=new Paint();

    public DrawBall(Context context, AttributeSet set)
    {
        super(context,set);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        p.setColor(Color.BLUE);
        canvas.drawCircle(currentX,currentY,30,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        this.currentX=event.getX();
        this.currentY=event.getY();
        this.invalidate();
        return true;
    }
}
