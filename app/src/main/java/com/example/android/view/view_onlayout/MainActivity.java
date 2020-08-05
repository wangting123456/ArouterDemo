package com.example.android.view.view_onlayout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout流程
          //1.测量完View的大小后，就需要将View布局在Window中，View的布局主要是通过上下左右四个点来确定
            //布局也是自上而下，ViewGroup先在layout()中确定自己的布局，然后在onLayout()方法中再调用
               // 子View的layout()方法，让子View布局
          //2.setOpticalFrame（）内部也是调用了setFrame（）确定自身内部位置
            //mRenderNode.setLeftTopRightBottom(mLeft, mTop, mRight, mBottom);
          //3.确定了自身的位置后，就要通过onLayout()确定子View的布局。onLayout()是一个可继承的空方法。
          //4.注意：
            //a.如果当前View就是一个单一的View，那么没有子View，就不需要实现该方法。
            //b.如果当前View是一个ViewGroup，就需要实现onLayout方法，该方法的实现个自定义ViewGroup时
                // 其特性有关，必须自己实现。

    }

 /*   public void layout(int l, int t, int r, int b) {

        // 当前视图的四个顶点
        int oldL = mLeft;
        int oldT = mTop;
        int oldB = mBottom;
        int oldR = mRight;

        // setFrame（） / setOpticalFrame（）：确定View自身的位置
        // 即初始化四个顶点的值，然后判断当前View大小和位置是否发生了变化并返回
        boolean changed = isLayoutModeOptical(mParent) ?
                setOpticalFrame(l, t, r, b) : setFrame(l, t, r, b);

        //如果视图的大小和位置发生变化，会调用onLayout（）
        if (changed || (mPrivateFlags & PFLAG_LAYOUT_REQUIRED) == PFLAG_LAYOUT_REQUIRED) {

            // onLayout（）：确定该View所有的子View在父容器的位置
            onLayout(changed, l, t, r, b);

        }*/
}
