package com.example.android.anim;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

/**
 * 逐帧动画
 */
public class FrameAnim extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_anim_frame);
        //Button button = findViewById(R.id.button);
        //帧动画代码方式
        AnimationDrawable drawable = new AnimationDrawable();
        for (int a = 0; a < 9; a++) {
            int id = getResources().getIdentifier("audio_anim_0" + a, "mipmap", getPackageName());
            Drawable da = getResources().getDrawable(id);
            drawable.addFrame(da, 200);
        }
        //button.setBackground(drawable);
        drawable.setOneShot(false);
      //获取对象实例，用来控制播放与停止
       /* AnimationDrawable rocketAnimation = (AnimationDrawable) button.getBackground();
        rocketAnimation.start();    // 开启帧动画
        rocketAnimation.stop();     // 停止动画*/
    }
}
