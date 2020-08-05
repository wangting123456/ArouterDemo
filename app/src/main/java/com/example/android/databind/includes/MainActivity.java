package com.example.android.databind.includes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.ActivityDatabindIncludesBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivityDatabindIncludesBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databind_includes);
    }
}
