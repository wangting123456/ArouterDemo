package com.example.android.databind.databind_advance;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.ActivityDatabindAdvance3Binding;
import com.example.livedata.activity.User;

public class Advance3Activity extends Activity {
    private ActivityDatabindAdvance3Binding binding;
    private ObservableArrayMap<String,Object> map;
    private  ObservableArrayList<String> list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_databind_advance3);
        //自定义注解方法
        UserBean userBean = new UserBean();
        userBean.setImageurl("xxxxx");
        binding.setUserbean(userBean);

        //DataBinding动态更新数据 BaseObservable /ObserverField
        DoubleBindBean doubleBindBean = new DoubleBindBean();
        doubleBindBean.setContent("我是张三");
        binding.setDoublebindbean(doubleBindBean);
        binding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoubleBindBean doubleBindBean = new DoubleBindBean();
                doubleBindBean.setContent("我是张三,顺便补充一下，今年26岁");
            }
        });
        DoubleBindBean2 doubleBindBean2 = new DoubleBindBean2();
        doubleBindBean2.name.set("李四");
        doubleBindBean2.aBoolean.set(true);
        doubleBindBean2.value.set(2);
        UserBean bean = new UserBean();
        doubleBindBean2.observableUserBean.set(bean);
        binding.btnClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoubleBindBean2 doubleBindBean2 = new DoubleBindBean2();
                doubleBindBean2.name.set("李四,顺便补充一下，今年25岁");
                doubleBindBean2.aBoolean.set(false);
                doubleBindBean2.value.set(3);
                UserBean bean = new UserBean();
                doubleBindBean2.observableUserBean.set(bean);
            }
        });

        //除了支持ObservableFile之外，也支持集合的使用 ObservableArrayMap,ObservableArrayList
        map = new ObservableArrayMap<>();
        list = new ObservableArrayList<>();
        list.add("111");
        list.add("222");
        binding.setList(list);

        map.put("key0","zhangsan");
        map.put("key1","lisi");
        binding.setMap(map);
        binding.btnClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.set(0,"333");
                map.put("key0","wangwu");
            }
        });

    }
}
