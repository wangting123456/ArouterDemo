package com.example.android.databind.databind_advance;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.ActivityDatabindAdvanceOtherBinding;

public class Advance2Activity extends Activity {
    private ActivityDatabindAdvanceOtherBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databind_advance_other);
        UserBean userBean = new UserBean();
        userBean.setName("张三");
        userBean.setAge(23);
        binding.setUserbean(userBean);
        com.example.android.databind.databind_basic.UserBean userBean2 = new com.example.android.databind.databind_basic.UserBean();
        userBean2.setName("lisi");
        userBean2.setAge(12);
        binding.setUserbean2(userBean2);
        binding.setClickHandler(new OnClickHandler());
    }
}
