package com.example.android.view_dispatch.view_dispatch_basic;

import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diapatch_basic);
        //一 事件分发概念
        //1.事件分发的对象是谁:
             //a.事件分发的对象是 事件 ，事件的分发是向下传递的，也就是父到子的顺序
             //b.当用户触摸屏幕时，将产生点击事件(Touch事件)。Touch事件的相关细节(发生触摸的位置，时间，手势等等)，被封装成MoveEvent对象
             //c.主要发生的Touch事件有4种
                           //MotionEvent.ACTION_DOWN:按下view
                           //MotionEvent.ACTION_CANCEL:非人为原因的取消
                           //MotionEvent.ACTION_MOVE:滑动view
                           //MotionEvent.ACTION_UP:抬起view
             //d.事件列:从手指接触屏幕到手指离开屏幕，这个过程产生的一系列事件，即当一个MotionEvent完成后，需要把这个事件传递给具体的view去处理
        //2.事件分发的本质:
          //a.将点击事件MotionEvent向某个view进行传递，并最终得到处理。这个传递的过程就是分发的过程
          //b.Android 事件分发的本质是：点击事件由哪个事件发出，经过哪个对象，最终到达哪个对象并最终得到处理
        //3.事件在哪些对象间进行传递:
          //Activity ->ViewGroup->View
        //4.事件分发过程涉及到的几个方法
          //dispatchTouchEvent() 、onInterceptTouchEvent()和onTouchEvent()
        //二.事件分发方法
         //事件分发过程由dispatchTouchEvent().onInterceptTouchEvent().和onTouchEvent()三个方法协助完成
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }



}
