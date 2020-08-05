package com.example.android.basic.basic_introduction;

import android.app.Activity;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

public class BasicActivity2 extends Activity {

    /**
     *重写旋转时方法，避免销毁和重建Activity。已经在AndroidMainfest.xml里面配置了该Activity属性
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
