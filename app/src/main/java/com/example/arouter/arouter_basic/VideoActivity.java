package com.example.arouter.arouter_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = ARouterConstant.ACTIVITY_VIDEO_VIDEO)
public class VideoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouterUtils.nagivation(ARouterConstant.ACTIVITY_VIDEO_VIDEO);
    }
}
