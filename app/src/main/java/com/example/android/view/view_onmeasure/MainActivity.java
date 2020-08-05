package com.example.android.view.view_onmeasure;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.Measure流程分析
          //a.顾名思义，就是测量每个View的大小，调用measure()进行一些逻辑处理，任何调用OnMeasure(),在其中
            //调用setMeasuredDimension()设置View的宽高信息，完成View的测量
          //b.measure()方法中，传入了两个参数 widthMeasureSpec, heightMeasureSpec 表示View的宽高的一些信息。
          //c.由上述流程来看，测量很简单，关键点是在于widthMeasureSpec, heightMeasureSpec这两个参数信息怎么获得

        //2.MeasureSpec的确定
          //a.先介绍什么是MeasureSpec
             //MeasureSpec 测量规格(4个字节) = 测量模式Mode(2个字节) + 测量大小SpecSize(2个字节)
          //b.MeasureSpec有两部分组成：测量模式和测量尺寸大小
             //Mode:分三种
               //a.UNSPECIFIED :unspecified 不具体说明：不对View进行任何限制，要多大给多大，一般用于系统内部
               //b.EXACTLY:检测到View的具体大小，对应LayoutParams里面的MatchParent和具体数值这两种模式
                   //这时候View的大小就是SpecSize所指定的值
         //c.那么MeasureSpec又是如何确定的？
             //a.对于DecorView，其确定是通过屏幕的大小，和自身的布局参数LayoutParams。
             //b.这部分很简单，根据LayoutParams的布局格式（match_parent，wrap_content或指定大小），
                // 将自身大小，和屏幕大小相比，设置一个不超过屏幕大小的宽高，以及对应模式。
             //c.对于其他View（包括ViewGroup），其确定是通过父布局的MeasureSpec和自身的布局参数LayoutParams。
    }
}
