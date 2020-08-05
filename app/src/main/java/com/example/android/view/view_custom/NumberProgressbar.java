package com.example.android.view.view_custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

public class NumberProgressbar extends View {
    private int unreach_color;
    private float unreach_dimension;
    private Paint paint = new Paint();
    public NumberProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.NumberProgressbar,defStyleAttr,0);
        unreach_color = typedArray.getColor(R.styleable.NumberProgressbar_progress_unreach_color, Color.BLUE);
        unreach_dimension = typedArray.getDimension(R.styleable.NumberProgressbar_progress_unreach_dimension,2f);
        typedArray.recycle();
    }

    public void setProgressColor(int color){
        this.unreach_color = color;
        paint.setColor(color);
        invalidate();
    }

    public void setProgressTextSize(float textSize) {
        this.unreach_dimension = textSize;
        paint.setTextSize(textSize);
        invalidate();
    }

/*    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       if mode is EXACTLY{
            父布局已经告诉了我们当前布局应该是多大的宽高, 所以我们直接返回从measureSpec中获取到的size
        }else{
            计算出希望的desiredSize
            if mode is AT_MOST
                    返回desireSize和specSize当中的最小值
     else:
            返回计算出的desireSize
        }
    }*/

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = measure(widthMeasureSpec,true);
        int measureHeight = measure(heightMeasureSpec,false);
        setMeasuredDimension(measureWidth,measureHeight);
    }

    private int measure(int measureSpec, boolean isWidth){
        int result = 0;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int padding = isWidth?getPaddingLeft()+getPaddingRight():getPaddingTop()+getPaddingBottom();
        if(mode == MeasureSpec.EXACTLY){
            result = size;
        }else {
            result = isWidth?getSuggestedMinimumWidth():getSuggestedMinimumHeight();
            result += padding;
            if(mode == MeasureSpec.AT_MOST){
                if (isWidth) {
                    result = Math.max(result, size);
                } else {
                    result = Math.min(result, size);
                }
            }

        }
       return result;
    }
}
