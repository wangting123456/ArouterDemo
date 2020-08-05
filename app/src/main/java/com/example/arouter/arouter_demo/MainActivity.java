package com.example.arouter.arouter_demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //为何需要组件化
        //各个业务模块之间不是隔离的
        //Module A 需要跳转到Module B的界面
        //Module A 需要调用Module C中的退出登录的方法
        //必然需要一种支持组件化需求的交互方式，提供UI跳转以及方法调用的能力。

        //实现路由的方式
        //1.隐式调用:Manifest会有很多过滤配置，不方便维护
        //2.反射:大量的使用反射跳转对性能会有影响,组件之间不容易拿到Class文件
        //3.广播/EventBus:对于跳转界面比较多的场景，维护成本比较高

        ARouter.getInstance().build("/demo/OtherActivity").navigation();
    }
}
