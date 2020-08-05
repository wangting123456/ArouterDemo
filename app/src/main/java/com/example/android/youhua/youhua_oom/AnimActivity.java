package com.example.android.youhua.youhua_oom;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class AnimActivity extends AppCompatActivity {
    private TextView tvShow;
    private ObjectAnimator animator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_youhua_oom_main);
        tvShow = (TextView) findViewById(R.id.tv_show);
        animator =  ObjectAnimator.ofFloat(tvShow,"rotation",0,360);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
      /*  在属性动画中有一类无限循环动画，如果在Activity中播放这类动画并且在onDestroy中去停止动画，
          那么这个动画将会一直播放下去，这时候Activity会被View所持有，从而导致Activity无法被释放。
          解决此类问题则是需要早Activity中onDestroy去去调用objectAnimator.cancel()来停止动画。*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(animator != null){
            animator.cancel();
            animator = null;
        }
    }
}
