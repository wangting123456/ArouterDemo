package com.example.java.design.proxy.builder;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将一个复杂对象的创建与他的表示分离，使得同样的创建过程可以有不同的创建展示
        BuilderDemo builderDemo = new BuilderDemo.UserBuilder("1","1").address("1").age(1).phone("1").build();
    }
}
