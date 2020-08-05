package com.example.android.view.view_custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private Paint mPaint;
    private Float size;
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView,defStyleAttr,0);
        int progress_max = typedArray.getInt(R.styleable.MyView_progress_max,10);
        size = typedArray.getDimension(R.styleable.MyView_progress_size,20);
        typedArray.recycle();
        //由于TypedArray对象是共享的资源，所以在获取完值之后必须要调用recycle()方法来回收。
        setProgressSize(size);
    }

    public void setProgressSize(Float size){
        mPaint.setTextSize(size);
        invalidate();
/*        重点看setProgressTextSize方法，在为mTextSize赋值之后，调用了invalidate()或者requestLayout()方法，
        我们自定义控件的属性发生改变之后，控件的样子也可能发生改变，在这种情况下就需要调用invalidate()方法让
    系统去调用view的onDraw()重新绘制。
        同样的，控件属性的改变可能导致控件所占的大小和形状发生改变，所以我们需要调用requestLayout()
    来请求测量获取一个新的布局位置。*/
    }

    //测量view
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = measure(widthMeasureSpec, true);
        int measureHeight = measure(heightMeasureSpec, false);
        setMeasuredDimension(measureWidth, measureHeight);
    }
    private int measure(int measureSpec, boolean isWidth) {
        int result;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int padding = isWidth ? getPaddingLeft() + getPaddingRight() : getPaddingTop() + getPaddingBottom();
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = isWidth ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight();
            result += padding;
            if (mode == MeasureSpec.AT_MOST) {
                if (isWidth) {
                    result = Math.max(result, size);
                } else {
                    result = Math.min(result, size);
                }
            }
        }
        return result;
    }

    //绘制view
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    //与用户进行交互

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
    //现在的触控有了更多的手势，比如轻点，快速滑动等等，所以在支持特殊用户交互的时候你需要用到android提供的GestureDetector
    // 你只需要实现GestureDetector中相对应的接口，并且处理相应的回调方法。
}
