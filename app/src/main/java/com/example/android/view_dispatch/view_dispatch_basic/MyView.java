package com.example.android.view_dispatch.view_dispatch_basic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

public class MyView extends ViewGroup {
    private String TAG = MyView.class.getSimpleName();

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

    //onInterceptTouchEvent 只在ViewGroup中
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG,"拦截事件");
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG,"处理事件");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    //现在的触控有了更多的手势，比如轻点，快速滑动等等，所以在支持特殊用户交互的时候你需要用到android提供的GestureDetector
    //你只需要实现GestureDetector中相对应的接口，并且处理相应的回调方法。

    public  boolean dispatchTouchEvent(MotionEvent event){
        boolean consume = false;//是否消耗事件
        if(onInterceptTouchEvent(event)){
            //onInterceptTouchEvent返回true，则代表当前view拦截了点击事件
            //则该点击事件会交给当前View进行处理
            //则会调用onTouchEvent()方法去处理点击事件
            consume = onTouchEvent(event);
        }else {
            //onInterceptTouchEvent返回false，则代表当前View不拦截点击事件
            //则该点击事件会继续传递给它的子元素
            //子元素的dispatchTouchEvent()就会被调用，重复上述过程
            //直到点击事件被最终处理为止
            //consume = child.dispatchTouchEvent (event) ;
        }
        return consume;

    }

    //只有ViewGroup才有onInterceptTouchEvent事件
}
