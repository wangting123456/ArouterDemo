package com.example.android.view.view_huizhiliucheng;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.View的绘制流程
          //a.View的绘制是从上往下，一层层迭代下来的DecorView->ViewGroup->View
             //onMeasure：先DecorView->ViewGroup->View
        //2.View中的重要方法
          //a.onMeasure(widthMeasureSpec,heightMeasureSpec)
             //a.1onMeasure过程决定了View的宽高，Measure测量完成后可以通过getMeasureWidth和getMeasureHeight
                //获取到测量后的View宽高，
             //a.2 onMeasure有两个参数，widthMeasureSpec和heightMeasureSpec这两个值分别用来确定视图的
                //宽度和高度的规格和大小

          //b.onLayout(boolean change,int left, int top, int right, int bottom)
             //layout过程决定了View的四个顶点，和实际的View宽高，完成以后，
             //可以通过getTop，getLeft，getRight,getBottom获取View四个顶点的位置，并通过getWidth和getHeight获取View最终的宽高

          //c.onDraw(Canvas canvas)
             //a.draw过程决定了View的显示，完成Draw后View会显示出来
             //b.绘制背景(background.draw(Canvas))
             //c.绘制自己 protected void onDraw(Canvas canvas) onDraw绘制自己，新建一个paint 在canvas上绘制自己的图形
             //d.绘制children (dispatchDraw)dispatchDraw会遍历调用所有子元素的draw方法
             //e.绘制装饰（onDrawScrollBars）
          //d.isEnabled() 当前视图是否可用。
              //a.可以调用setEnable()方法来改变视图的可用状态，传入true表示可用，传入false表示不可用。
              //b.它们之间最大的区别在于，不可用的视图是无法响应onTouch事件的。
          //e.isFocused()当前视图是否获取焦点
              //requestFocus()来让视图获取焦点
          //f.offsetTopAndBottom()
             //a.直接改变的是top, bottom,相当于在parent中上下平移View的位置
             //b.View的边界直接发生了变化，View和他的子View的相对位置没变，所以他的子View的边界也跟着变化了


        //3.自定义View优化策略
           //a.尽可能少调用onDraw(),调用invalidate().就回回调onDraw()如果可能的话，尽量调用含有4个参数的invalidate()
              // 方法而不是没有参数的invalidate()。没有参数的invalidate会强制重绘整个view。
           //b.任何时候执行requestLayout(),会使得Android UI系统去遍历整个View的层级来计算出每一个view的大小。

    }
}
