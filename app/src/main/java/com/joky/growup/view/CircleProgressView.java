package com.joky.growup.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Joky on 2016/12/8 0008.
 */

public class CircleProgressView extends View {

    private int mCircleXY;
    private float mRedius;
    private RectF mArcRectf;
    private int length = 200;
    private Paint mCirclePaint;
    private String mContent = "Android Skill";
    private Paint mTextPaint;
    private Paint mArcPaint;

    public CircleProgressView(Context context) {
        this(context,null);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        init();
    }

    private void init() {
        mCircleXY = length/2;
        mRedius = (float) (length*0.5/2);
        mArcRectf = new RectF(
                ((float) (length * 0.1)),
                ((float) (length * 0.1)),
                ((float) (length * 0.9)),
                ((float) (length * 0.9))
        );
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.BLUE);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setAntiAlias(true);

        mArcPaint = new Paint();
        mArcPaint.setColor(Color.BLUE);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth(((int) (length * 0.1)));
        mArcPaint.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.WHITE);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mCircleXY,mCircleXY,mRedius,mCirclePaint);
        canvas.drawText(mContent,mCircleXY,mCircleXY+(16/4),mTextPaint);
        canvas.drawArc(mArcRectf,270,270,false,mArcPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        length = w;
        init();
    }
}
