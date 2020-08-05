package com.example.android.databind.databind_basic;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.ActivityDatabindBasicBinding;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivityDatabindBasicBinding binding =  DataBindingUtil.setContentView(this,R.layout.activity_databind_basic);
        //谷歌2015年IO框架提出来的databind
        UserBean userBean = new UserBean();
        userBean.setName("zhangsan");
        userBean.setAge(26);
        binding.setUserbean(userBean);

    }
}
