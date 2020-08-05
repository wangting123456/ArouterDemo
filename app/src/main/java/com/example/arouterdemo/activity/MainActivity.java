package com.example.arouterdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.arouterdemo.R;
import com.example.arouterdemo.constants.Constants;
import com.example.arouterdemo.service.HelloServiceImpl;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.getInstance().build(Constants.ONE_ACTIVITY).navigation();
        ARouter.getInstance().build(Constants.ONE_ACTIVITY).withString("name","zhangsan")
                .withInt("age",14).navigation();
        HelloServiceImpl impl =  (HelloServiceImpl) ARouter.getInstance().build(Constants.HELLO_SERVICE).navigation();
        impl.sayHello();
    }
}
