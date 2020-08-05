package com.example.android.recycleview.recycleview_itemanimator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.ItemAnimator 基本概念
          //a.官方有一个默认Item动画类DafaultItemAnimator,其中DefaultItemAnimator继承了SimpleItemAnimator
          //b.SimpleItemAnimator 是一个包装类，用来判断当前的ViewHolder是在移动、移除、添加或者改变等行为
          //c.DefaultItemAnimator 是执行具体动画类，它负责将viewHolder初始化、保存需要执行动画的ViveHolder以及动画信息、执行具体的动画。
        //2.如何使用
          //recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
