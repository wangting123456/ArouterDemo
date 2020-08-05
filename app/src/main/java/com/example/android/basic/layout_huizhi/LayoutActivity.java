package com.example.android.basic.layout_huizhi;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class LayoutActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * Activity执行onResume之后再ActivityThread中执行Activity的makeVisible方法。
         * View的绘制流程包含了测量大小，测量位置，绘制三个流程；
         * Activty的界面绘制是从mDector即根View开始的，也就是从mDector的测量大小，测量位置，绘制三个流程；
         * View体系的绘制流程是从ViewRootImpl的performTraversals方法开始的；
         * View的测量大小流程:performMeasure --> measure --> onMeasure等方法;
         * View的测量位置流程：performLayout --> layout --> onLayout等方法；
         * View的绘制流程：onDraw等方法；
         * View组件的绘制流程会在onMeasure,onLayout以及onDraw方法中执行分发逻辑，也就是在onMeasure同时执行子View的测量大小逻辑，在onLayout中同时执行子View的测量位置逻辑，在onDraw中同时执行子View的绘制逻辑；
         * Activity中都对应这个一个Window对象，而每一个Window对象都对应着一个新的WindowManager对象（WindowManagerImpl实例）；
         */
    }
}
