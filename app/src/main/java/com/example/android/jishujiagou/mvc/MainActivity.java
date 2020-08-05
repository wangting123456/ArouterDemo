package com.example.android.jishujiagou.mvc;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_jiagou_mvc);
        initData();
    }
    private void initData(){
        MeAboutModel meAboutModel = new MeAboutModel();
        meAboutModel.getAboutData(new AboutDataListener() {
            @Override
            public void success() {
                //
            }

            @Override
            public void failure() {
                //
            }
        });
    }
}
