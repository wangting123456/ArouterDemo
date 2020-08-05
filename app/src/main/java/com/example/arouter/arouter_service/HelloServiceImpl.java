package com.example.arouter.arouter_service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.arouterdemo.constants.Constants;

@Route(path = Constants.HELLO_SERVICE)
public class HelloServiceImpl implements HelloService {
    private Context context;
    @Override
    public String sayHello() {
        return "你好";
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
