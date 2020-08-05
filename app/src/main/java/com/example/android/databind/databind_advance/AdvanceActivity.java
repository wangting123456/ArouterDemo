package com.example.android.databind.databind_advance;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.ActivityDatabindAdvanceBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdvanceActivity extends Activity {
    private ActivityDatabindAdvanceBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_databind_advance);
        binding.setStr("lisi");
        binding.setAge(24);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        binding.setList(list);
        HashMap<String,Object> map = new HashMap<>();
        map.put("key0","1");
        map.put("key1",1);
        binding.setMap(map);
        String[] array = new String[]{"1","2"};
        binding.setArray(array);
    }
}
