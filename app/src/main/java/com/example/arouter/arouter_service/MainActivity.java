package com.example.arouter.arouter_service;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.arouterdemo.R;
import com.example.arouterdemo.constants.Constants;
import com.example.arouterdemo.service.HelloServiceImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HelloServiceImpl impl =  (HelloServiceImpl) ARouter.getInstance().build(Constants.HELLO_SERVICE).navigation();
        impl.sayHello();
    }
}
