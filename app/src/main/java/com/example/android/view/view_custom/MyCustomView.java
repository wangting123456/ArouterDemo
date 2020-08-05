package com.example.android.view.view_custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

public class MyCustomView extends View {
    private int default_size;
    private Paint paint = new Paint();

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.MyCustomView);
        default_size = typedArray.getDimensionPixelSize(R.styleable.MyCustomView_default_size, 100);
        typedArray.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMySize(100, widthMeasureSpec);
        int height = getMySize(100, heightMeasureSpec);

        if (width < height) {
            height = width;
        } else {
            width = height;
        }

        setMeasuredDimension(width, height);
    }

    private int getMySize(int default_size, int measureSpec) {
        int mysize = default_size;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            //如果是固定的大小，那就不要去改变它
            case MeasureSpec.EXACTLY:
                mysize = size;
                break;
                //如果测量模式是最大取值为size
            case MeasureSpec.AT_MOST:
                mysize = size;
                break;
            case MeasureSpec.UNSPECIFIED:
                mysize = default_size;
                break;
        }
        return mysize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int radius = getMeasuredWidth()/2;
        //圆心的横坐标为当前的View的左边起始位置+半径
        int centerX = getLeft()+radius;
        //圆心的纵坐标为当前的View的顶部起始位置+半径
        int centerY = getTop()+radius;
        canvas.drawCircle(centerX,centerY,radius,paint);
    }
}
