package com.example.android.basic.fragment_advanced;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * show()，hide()最终是让Fragment的View setVisibility(true还是false)，不会调用生命周期；
         * replace()的话会销毁视图，即调用onDestoryView、onCreateView等一系列生命周期；
         * add()和 replace()不要在同一个阶级的FragmentManager里混搭使用。
         */
        //传递和接收参数
       /* 1.最常用的传递参数
        public static WyNewsFragment newInstance(String param) {
            WyNewsFragment fragment = new WyNewsFragment();
            Bundle args = new Bundle();
            args.putString(TYPE, param);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mType = getArguments().getString(TYPE);
            }
        }*/
      /* 2 Fragment与Activity之间传值
        Fragment与Activity之间是如何传值的？
        a.Activity向Fragment传值：
        步骤：
        要传的值，放到bundle对象里；
        在Activity中创建该Fragment的对象fragment，通过调用
        fragment.setArguments()传递到fragment中；
        在该Fragment中通过调用getArguments()得到bundle对象，就能得到里面的值。
        b.Fragment向Activity传值：
        第一种：
        在Activity中调用getFragmentManager()得到fragmentManager,，调用findFragmentByTag(tag)或者通过findFragmentById(id)
        FragmentManager fragmentManager = getFragmentManager()；
        Fragment fragment = fragmentManager.findFragmentByTag(tag)；
        第二种：
        通过回调的方式，定义一个接口（可以在Fragment类中定义），接口中有一个空的方法，在fragment中需要的时候调用接口的方法，值可以作为参数放在这个方法中，
        然后让Activity实现这个接口，必然会重写这个方法，这样值就传到了Activity中。*/

      /*  3.Fragment与Fragment之间传值
        Fragment与Fragment之间是如何传值的？
        第一种：
        通过findFragmentByTag得到另一个的Fragment的对象，这样就可以调用另一个的方法了。
        第二种：
        通过接口回调的方式。技术博客大总结
        第三种：
        通过setArguments，getArguments的方式。*/
    }
}
