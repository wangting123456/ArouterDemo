package com.example.android.view_dispatch.view_dispatch_jizhi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    float downX = 0.0f;
    float downY = 0.0f;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float X = ev.getX();
        float Y = ev.getY();
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = X;
                downY = Y;
                break;
            case MotionEvent.ACTION_MOVE:
                float delatX =  Math.abs(X-downX);
                float delatY =  Math.abs(Y-downY);
                //这里是够拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截
                if(delatX > delatY){
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
