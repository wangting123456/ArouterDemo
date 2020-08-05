package com.example.android.view.view_basic.view_extendsview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

public class HistogramView extends View {
    private Paint paint;
    private Path path;
    private int mTextColor, mHistogramColor;

    public HistogramView(Context context) {
        super(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        path = new Path();
        initAttrs(context,attrs);
    }

    private void initAttrs(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HistogramView);
        mTextColor = typedArray.getColor(R.styleable.HistogramView_textColor, Color.BLACK);
        mHistogramColor = typedArray.getColor(R.styleable.HistogramView_histogramColor, Color.GREEN);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制坐标轴
        paint.reset();
        path.reset();
        paint.setColor(Color.BLACK);
        paint.setColor(mTextColor);
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(100, 100);//不进行绘制，只用来移动画笔
        path.rLineTo(0, 402);
        path.rLineTo(800, 0);
        canvas.drawPath(path, paint);

        //绘制文本
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        canvas.drawText("Froyo", 160, 540, paint);
        canvas.drawText("CB", 280, 540, paint);
        canvas.drawText("ICS", 380, 540, paint);
        canvas.drawText("J", 480, 540, paint);
        canvas.drawText("KitKat", 560, 540, paint);
        canvas.drawText("L", 690, 540, paint);
        canvas.drawText("M", 790, 540, paint);
        //绘制直方图，柱形图是用较粗的直线来实现的
        paint.reset();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(80);
        paint.setColor(mHistogramColor);
        //float []pts={10,10,100,100,200,200,400,400};
        //上面有四个点：（10，10）、（100，100），（200，200），（400，400）
        //两两连成一条直线；
        float[] lines3 = {
                200, 500, 200, 495,
                300, 500, 300, 480,
                400, 500, 400, 480,
                500, 500, 500, 300,
                600, 500, 600, 200,
                700, 500, 700, 150,
                800, 500, 800, 350,
        };
        canvas.drawLines(lines3, paint);
    }
}
