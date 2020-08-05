package com.example.android.annotation.annotation_apt;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //APT，就是Annotation Processing Tool的简称，叫做注解处理工具。就是可以在代码编译期间对注解进行处理，
        // 并且生成Java文件，减少手动的代码输入。注解我们平时用到的比较多的可能会是运行时注解，
        // 比如大名鼎鼎的retrofit就是用运行时注解，通过动态代理来生成网络请求。编译时注解平时开发中可能会涉及的比较少，
        // 但并不是说不常用，比如我们经常用的轮子Dagger2, ButterKnife, EventBus3 都在用。
    }
}
