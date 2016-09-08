package com.joky.growup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 */
public class RadarView extends View {

    private Paint mCirclePaint;
    private Paint mShaderPaint;
    private int w;
    private int h;
    private SweepGradient mShader;
    private Matrix mMatrix;
    private int degrees;

    public RadarView(Context context) {
        this(context,null);
    }

    public RadarView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RadarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.GRAY);
        mCirclePaint.setStrokeWidth(3);
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStyle(Paint.Style.STROKE);

        mShaderPaint = new Paint();
        mShaderPaint.setColor(Color.rgb(0,166,237));
        mShaderPaint.setAntiAlias(true);
        mShaderPaint.setStyle(Paint.Style.FILL);
        mMatrix = new Matrix();
        handler.sendEmptyMessage(0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w = getMeasuredWidth();
        h = getMeasuredHeight();

        canvas.drawCircle(w/2,h/2,w/3,mCirclePaint);
        canvas.drawCircle(w/2,h/2,w/4,mCirclePaint);
        canvas.drawCircle(w/2,h/2,w/6,mCirclePaint);
        canvas.drawCircle(w/2,h/2,w/12,mCirclePaint);
        canvas.drawLine(w/2,h/2-w/3,w/2,h/2+w/3,mCirclePaint);
        canvas.drawLine(w/6,h/2,w/6*5,h/2,mCirclePaint);

        if(mShader == null){
            mShader = new SweepGradient(w/2,h/2,Color.TRANSPARENT,Color.rgb(0,166,237));
            mShaderPaint.setShader(mShader);
        }
        canvas.concat(mMatrix);
        canvas.drawCircle(w/2,h/2,w/3,mShaderPaint);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            degrees+=2;
            mMatrix.setRotate(degrees,w/2,h/2);
            if(degrees>=360){
                degrees = 0;
            }
            postInvalidate();
            sendEmptyMessageDelayed(0,16);
        }
    };
}
