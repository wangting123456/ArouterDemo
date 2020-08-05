package com.example.android.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import androidx.annotation.Nullable;

/**
 * 补间动画 java代码
 */
public class TweenAnim extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    /**
     * 旋转动画Rotate
     */
    public static Animation getRotateAnimation(float fromDegree, float toDegree, long durationMillis) {
        RotateAnimation animation = new RotateAnimation(fromDegree, toDegree, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(durationMillis);
        animation.setFillAfter(true);
        return animation;
    }

    /**
     * 透明度动画Alpha
     */
    public static Animation getAlphaAnimation(float fromAlpha,float toAlpha,long durationMillis){
        AlphaAnimation animation = new AlphaAnimation(fromAlpha,toAlpha);
        animation.setDuration(durationMillis);
        animation.setFillAfter(true);
        return animation;
    }

    /**
     * 缩放动画Scale
     */
    public static Animation getScaleAnimation(float scrollXY,long durationMillis){
        ScaleAnimation animation = new ScaleAnimation(1.0f,scrollXY,1.0f,scrollXY,Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(durationMillis);
        return animation;
    }

    /**
     * 位移动画Translate
     */
    public static Animation getTranslateAnimation(float fromXdelta,float toXdelta,float fromYdelta,float toYdelta,long durationMillis){
        TranslateAnimation animation = new TranslateAnimation(fromXdelta,toXdelta,fromYdelta,toYdelta);
        animation.setDuration(durationMillis);
        return animation;
    }

}
