package com.example.android.view.view_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.组合控件：将系统原有的控件进行组合，组成一个新的控件
        //2.继承控件：继承系统控件(TextView,ViewGroup)，一般是希望在原有系统控件基础上做一些修饰性的修改，而不会做大幅度的改动
        //3.自绘控件：
    }
}
