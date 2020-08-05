package com.example.viewmodel;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

/**
 * ViewModel 是 Android 架构组件之一，用于分离 UI 逻辑与 UI 数据。在发生 Configuration Changes 时，它不会被销毁
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.ViewModel介绍
          //1.数据持久化
             //a.由于屏幕旋转时，会经历Activity的销毁和重建，这里就是涉及到数据的保存问题，显示重新请求和加载数据不好
                //在 ViewModel 出现之前我们可以用 activity 的onSaveInstanceState()机制保存和恢复数据。但缺点很明显，
                //onSaveInstanceState只适合保存少量的可以被序列化、反序列化的数据
                //假如我们需要保存是一个比较大的 bitmap list ，这种机制明显不合适。
             //b.ViewModel的特殊性。ViewModel的生命周期
                //Activity oncreate --> ViewModel oncreate onstart onresume
                //Activity onrotate --> ViewModel onpause onstop ondestory oncreate onstart onresume
                //Activity onfinish --> ViewModel onpause onstop ondestory
                //finished          --> ViewModel onclear
                //ViewModel的生命周期贯穿整个Activity的生命周期，直到 Activity 真正意义上销毁后才会结束。既然如此，用来存放数据再好不过了
        //2.Fragments间共享数据
           //一个Activity里面有多个Fragment，这些Fragment之间需要做多个交互，之前的做法是接口回调，
           //不可避免的Fragment之间互相有对方的引用，大量容错判断(对方fragment是否还活着)
           //使用ViewModel 是这样的，Activity和内部的Fragment共用一个ViewModel
         //3.分担 UI controller负担
            //Activity 、Fragment 是设计用来渲染展示数据、响应用户行为、处理系统的某些交互。如果再要求他
            // 去负责加载网络或数据库数据，会让其显得臃肿和难以管理。所以为了简洁、清爽、丝滑，我们可以分离出数
            // 据操作的职责给 ViewModel


        //二.用法简介
          //ViewModel一般配合LiveData使用
            //a.首先获取ViewModel实例
               /*  MyViewModel model = ViewModelProviders.of(activity).get(MyViewModel.class);
                或
                 MyViewModel model = ViewModelProviders.of(fragment).get(MyViewModel.class);
               或
                MyViewModel model = ViewModelProviders.of(activity，factory).get(MyViewModel.class); */
            //b.MyViewModel内部操作
             MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
             myViewModel.getList().observe(this, new Observer<List<Item>>() {
                 @Override
                 public void onChanged(List<Item> items) {
                   //Update UI
                 }
                });
         //三.源码分析
           //ViewModel的出生
             //ViewModelProviders: 类提供了4个静态工厂方法 of() 创建一个新的 ViewModelProvider 对象。
             //ViewModel         : 是一个抽象类，只定义了一个空的 onCleared()方法。
             //ViewModelProvider : 负责提供 ViewModel 对象
             //ViewModelStore    : 使用Map存储当前页面已存在的ViewModel
             //Factory           : 创建ViewModel工厂的接口类
          //总结:
              //1.通过 ViewModelProviders 创建 ViewModelProvider 对象，调用ViewModelProvider的 get()方法获取 ViewModel 对象。 当 ViewModelStore 里不存在想要的对象，ViewModelProvider 会使用 Factory 新建一个对象并存放到 ViewModelStore 里。
              //2.当发生 发生 Configuration Changes 时，FragmentActivity 利用 getLastNonConfigurationInstance()、onRetainNonConfigurationInstance() 方法实现 ViewModelStore 的保留与恢复，进而实现 ViewModel 对象的保活。
              //3.当 FragmentActivity 和 Fragment 被销毁时，会根据是否发生 Configuration Changes 来决定是否销毁 ViewModel


    }
}
