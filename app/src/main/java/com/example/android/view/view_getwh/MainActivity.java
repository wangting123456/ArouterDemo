package com.example.android.view.view_getwh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

public class MainActivity extends Activity {
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_view_getwh);
        frameLayout = findViewById(R.id.framelayout);
     /*   如果我们想在activity已启动时去获取某个View的宽、高，实际上在onCreate，onStart，onResume中均无法正确得到某个View的宽高信息。
        因为View的measure过程和activity的生命周期方法不是同步执行的，因此无法保证Activity执行了onCreate，
        onStart，onResume时，某个View已经测量完毕，一旦View没有测量完毕，那么我们此时获得的宽/高就是0。*/
       //方法二
        frameLayout.post(new Runnable() {
            @Override
            public void run() {
               int width = frameLayout.getMeasuredWidth();
               int height = frameLayout.getMeasuredHeight();
            }
        });
       //方法三
        ViewTreeObserver observer = frameLayout.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int width = frameLayout.getMeasuredWidth();
                int height = frameLayout.getMeasuredHeight();
            }
        });

        //方法四
        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        frameLayout.measure(w, h);
        int height = frameLayout.getMeasuredHeight();
        int width = frameLayout.getMeasuredWidth();
    }

    //方法一
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
          int width =  frameLayout.getMeasuredWidth();
          int height =  frameLayout.getMeasuredHeight();
        }
    }
}
