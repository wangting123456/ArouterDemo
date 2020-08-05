package com.example.android.anim;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

/**
 * 属性动画：补间动画增强版
 *
 */
public class PropertyAnim extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //补间动画存在一些缺陷
           //a.作用对象局限：View ，即只能作用到试图View上，只能对Button，TextView,LinearLayout，或者其他继承View的组件进行动画
                         //无法对非View的对象进行动画操作
           //b.没有改变View的属性，只是对View进行视觉上改变效果
           //c.动画效果单一
        //属性动画的特点
           //作用对象;任意java对象，不再作用于View试图
           //实现的动画效果：可自定义各种动画效果，不再局限于4种基本变换：平移、旋转、缩放 & 透明度
        //基本工作原理
          //在一定时间间隔内，通过不断对值进行改变，并不断将该值赋给对象的属性，从而实现该对象在该属性上的动画效果
    }

    /**
     * 设置属性动画ValueAnimator
     * @param view    view
     * @param start   开始值
     * @param end     结束值
     * @param time    运行时间
     * @param delay   延迟播放时间
     * @param count   重复播放次数
     * @return
     */
    public static ValueAnimator setValueAnimator(View view , int start , int end , int time , int delay , int count){
       /*步骤1：设置动画属性的开始值&结束值
                 ValueAnimator.ofFloat(); 采用默认的浮点型估值器 (FloatEvaluator)
                 ValueAnimator.ofInt();   采用默认的整型估值器 (IntEvaluator)

                 */
        ValueAnimator valueAnimator = ValueAnimator.ofInt(start,end);
         /* ofInt()作用有两个
            a.创建动画实例
            b.将传入的多个参数进行平滑过渡，次数传入0，1，表示将值从0平滑过渡到1
              如果传入了3个Int参数 a,b,c ,则是先从a平滑过渡到b,再从b平滑过渡到C，以此类推
         */
        valueAnimator.setTarget(view);
        //步骤2：设置动画播放的各种属性
        valueAnimator.setDuration(time);
        valueAnimator.setStartDelay(delay);
        valueAnimator.setRepeatCount(count);
        //步骤3：将改变的值手动赋值给对象的属性值，通过动画的更新监听器
        //设置值的更新监听器：即：值每次改变、变化一次,该方法就会被调用一次
        return valueAnimator;
    }

    /**
     * 设置属性动画 ObjectAnimator
     * @param view view
     * @param type 对象属性
     * @param start 开始值
     * @param end   结束值
     * @param time  运行时长
     * @param delay
     * @return
     */
    public static ObjectAnimator setObjectAnimator(View view , String type , int start , int end , long time , int delay){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,type,start,end);
        // ofFloat()作用有两个
        // 1. 创建动画实例
        // 2. 参数设置：参数说明如下
        // Object object：需要操作的对象
        // String property：需要操作的对象的属性
        // property属性值常见有：此处先展示四种基本变换：平移、旋转、缩放 & 透明度   translationX  rotation scaleX alpha
        // float ....values：动画初始值 & 结束值（不固定长度）
        // 若是两个参数a,b，则动画效果则是从属性的a值到b值
        // 若是三个参数a,b,c，则则动画效果则是从属性的a值到b值再到c值
        // 以此类推
        // 至于如何从初始值 过渡到 结束值，同样是由估值器决定，此处ObjectAnimator.ofFloat（）是有系统内置的浮点型估值器FloatEvaluator，同ValueAnimator讲解

        // 设置动画重复播放次数 = 重放次数+1
        // 动画播放次数 = infinite时,动画无限重复
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        // 设置动画运行的时长
        objectAnimator.setDuration(time);
        // 设置动画延迟播放时间
        objectAnimator.setStartDelay(delay);
        // 设置重复播放动画模式
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        // ValueAnimator.RESTART(默认):正序重放
        // ValueAnimator.REVERSE:倒序回放
        // 设置差值器
        objectAnimator.setInterpolator(new LinearInterpolator());
        return objectAnimator;

    }
}
