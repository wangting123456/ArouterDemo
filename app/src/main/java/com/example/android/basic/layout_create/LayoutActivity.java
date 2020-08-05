package com.example.android.basic.layout_create;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class LayoutActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * Activity的展示界面的特性是通过Window对象来控制的；
         * 每个Activity对象都对应这个一个Window对象，并且Window对象的初始化在启动Activity的时候完成，
         * 在执行Activity的onCreate方法之前；
         * 每个Window对象内部都存在一个FrameLayout类型的mDector对象，它是Acitivty界面的root view；
         * Activity中的window对象的实例是PhoneWindow对象，PhoneWindow对象中的几个成员变量mDector，mContentRoot，mContentParent都是View组件，
         * 它们的关系是：mDector --> mContentRoot --> mContentParent --> 自定义layoutView
         * LayoutInflater.inflate主要用于将布局文件加载到内存View组件中，也可以设定加载到某一个父组件中；
         * 典型的Activity的onCreate方法中需要调用super.onCreate方法和setContentView方法，若不调用super.onCreate方法，执行启动该Activity的逻辑会报错，
         * 若不执行setContentView的方法，该Activity只会显示一个空页面。
         */
    }
}
