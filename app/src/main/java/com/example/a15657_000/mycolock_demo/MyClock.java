package com.example.a15657_000.mycolock_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 15657_000 on 2017/9/16 0016.
 */

public class MyClock extends View {

    private int mHight,mWidth;

    public MyClock(Context context) {
        super(context);
    }

    public MyClock(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mHight = getHeight();
        mWidth = getWidth();

        Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(3);
        canvas.drawCircle(mWidth/2,mHight/2,mWidth/2,paintCircle);

        Paint paintLine = new Paint();
        for(int i = 0;i < 24;i++)
        {
            String num  = ""+i;
            if(i == 0 || i == 6 || i == 12 || i == 18){
                paintLine.setStrokeWidth(5);
                paintLine.setTextSize(50);
                canvas.drawLine(mWidth/2,mHight/2-mWidth/2,
                                mWidth/2,mHight/2-mWidth/2+60,
                                paintLine);
                canvas.drawText(num,mWidth/2 - paintLine.measureText(num)/2,
                                mHight/2 - mWidth/2 +120,paintLine);
            }else{
                paintLine.setStrokeWidth(3);
                paintLine.setTextSize(35);
                canvas.drawLine(mWidth/2,mHight/2-mWidth/2,
                                mWidth/2,mHight/2-mWidth/2+30,paintLine);
                canvas.drawText(num,mWidth/2-paintLine.measureText(num)/2,
                                mHight/2 - mWidth/2 +60,paintLine);
            }
             canvas.rotate(15,mWidth/2,mHight/2);
        }

        Paint paintHour = new Paint();
        Paint paintMinute = new Paint();
        Paint paintPoint = new Paint();
        paintHour.setStrokeWidth(15);
        paintMinute.setStrokeWidth(10);
        paintPoint.setStrokeWidth(20);
        canvas.save();
        canvas.translate(mWidth/2,mHight/2);
        canvas.drawPoint(0,0,paintPoint);
        canvas.drawLine(0,0,100,100,paintHour);
        canvas.drawLine(0,0,100,200,paintMinute);
        canvas.restore();
        super.onDraw(canvas);
    }
}
