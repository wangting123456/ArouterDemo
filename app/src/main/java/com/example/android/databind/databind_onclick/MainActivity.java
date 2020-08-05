package com.example.android.databind.databind_onclick;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.ActivityDatabindOnclickBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityDatabindOnclickBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_databind_onclick);
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        binding.setViewmodel(myViewModel);
    }
}
