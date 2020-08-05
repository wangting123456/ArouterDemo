package com.example.livedata.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.ActivityDatabindBinding;

public class ActivityDataBind extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityDatabindBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_databind);
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        //binding.setMainViewModel(viewModel);
        //binding.setLifecycleOwner(this);
        viewModel.getUser().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                User user = (User)o;
                user.getAge();
                user.getName();
            }
        });
    }
}
