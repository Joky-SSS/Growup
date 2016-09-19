package com.joky.growup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


public class CanvasView extends View {

    private Paint mPaint;

    //在代码中定义和使用时用到的
    public CanvasView(Context context) {
        super(context);
        init();
    }

    //在xml中定义我们的自定义属性时用到
    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(20F);
    }

    //在View中画出我们需要的内容
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(230, 255, 255, 255);
        canvas.drawPoint(100,100,mPaint);
        canvas.drawPoints(new float[]{
                150,100,
                250,250,
                300,350,
                455,555
        },mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawLine(105,105,155,105,mPaint);
        canvas.drawLines(new float[]{
                166,110,260,260,
                280,280,310,360,
                320,380,460,460
        },mPaint);

        mPaint.setColor(Color.RED);
        int width = (int)(canvas.getWidth()*0.8);
        canvas.drawRect(20,20,20+width,20+width,mPaint);

        mPaint.setColor(Color.YELLOW);
        mPaint.setAntiAlias(true);
        RectF rectf = new RectF(50,50,300,300);
        canvas.drawRoundRect(rectf,125,125,mPaint);

        mPaint.setColor(Color.LTGRAY);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500,500,300,mPaint);

        mPaint.setColor(Color.MAGENTA);
        rectf = new RectF(100,100,450,300);
        canvas.drawOval(rectf,mPaint);

        rectf = new RectF(200,200,550,550);
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rectf,mPaint);
//        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectf,-90F,-90F,false,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        rectf = new RectF(200,650,550,1000);
        mPaint.setColor(Color.rgb(150,193,32));
        canvas.drawArc(rectf,-35F,96F,true,mPaint);
        mPaint.setColor(Color.rgb(218,221,216));
        canvas.drawArc(rectf,61F,78F,true,mPaint);
        mPaint.setColor(Color.rgb(199,213,159));
        canvas.drawArc(rectf,139F,123F,true,mPaint);
        mPaint.setColor(Color.rgb(183,206,99));
        canvas.drawArc(rectf,262F,63F,true,mPaint);
    }
}