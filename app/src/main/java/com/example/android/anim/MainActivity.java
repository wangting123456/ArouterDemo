package com.example.android.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Property;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.demo.mymaven.MyViewLib;
import com.example.arouterdemo.R;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_main);
        Button button1 =  findViewById(R.id.button1);


       /* 1.Android动画类型
        1.1 Android动画类型分类
            逐帧动画【Frame Animation】，即顺序播放事先做好的图像，跟电影类似
            补间动画【Tween Animation】，即通过对场景里的对象不断做图像变换 ( 平移、缩放、旋转 ) 产生动画效果
            属性动画【Property Animation】，补间动画增强版，支持对对象执行动画
            过渡动画【Transition Animation】,实现Activity或View过渡动画效果
        1.2 Android动画实现方式分类
           XML资源文件
           代码方式


        /* Tween Animation*/
        // XML资源文件
        Animation animation_xml = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        button1.startAnimation(animation_xml);
        // 代码方式
        Animation animation_java = TweenAnim.getAlphaAnimation(0.0f,1.0f,2000);
        button1.startAnimation(animation_java);

        /*Property Animation*/
        // XML资源文件
        @SuppressLint("ResourceType") Animator anim_value = AnimatorInflater.loadAnimator(this,R.anim.animator_valueanim);
        anim_value.setTarget(button1);
        anim_value.start();

        //代码方式
        ValueAnimator animator = PropertyAnim.setValueAnimator(button1,0, 2, 2000, 500, 2);
        animator.start();

        ObjectAnimator mAnimator = PropertyAnim.setObjectAnimator(button1, "rotation",0,360,800,0);
        mAnimator.start();

        //方法一
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //动画开始时执行
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //动画结束时执行
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                //动画取消时执行
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                //动画重复时执行
            }
        });
        //方法二，可以不用重写全部的方法，只重写自己需要的
        animator.addListener(new AnimatorListenerAdapter(){
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                //动画取消时回调
            }
        });

    }
}
