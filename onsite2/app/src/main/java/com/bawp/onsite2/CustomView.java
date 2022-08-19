package com.bawp.onsite2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private Paint mpaint;
    public Path path;
    //public static final int size = 200;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {

        mpaint = new Paint();
        path = new Path();
        mpaint.setColor(Color.RED);
        mpaint.setStrokeWidth(10);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setAntiAlias(true);
        mpaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path,mpaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos=event.getX();
        float yPos=event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos,yPos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos,yPos);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        postInvalidate();
        return true;
    }
}