package com.example.java.fanshe.fanshe_yuanma;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射知识点深入
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.setAccessible暴力访问
          //a.设置.setAccessible(true)暴力访问权限
            //一般情况下，我们并不能对类的私有字段进行访问，利用反射也不例外，但有的时候，例如要序列
            //化的时候，我们又必须有能力去处理这些字段，这时候，我们就需要调用AccessibleObject上的
            //setAccessible()方法来允许这种访问，而由于反射类中的Field，Method和Constructor继承自
            //AccessibleObject
        try {
            Class cla = Class.forName("com.example.java.fanshe.fanshe_yuanma.User");
            Method method = cla.getDeclaredMethod("getMethod");
            method.setAccessible(true);
            Field field = cla.getDeclaredField("code");
            field.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.invoke()方法执行
         //a.nvoke() 方法中第一个参数 Object 实质上是 Method 所依附的 Class 对应的类的实例，如果这个
           //方法是一个静态方法，那么 ojb 为 null，后面的可变参数 Object 对应的自然就是参数。
         //b.在对Method调用invoke()的时候，如果方法本身会抛出异常，那么这个异常就会经过包装，由Method
          //统一抛InvocationTargetException。而通过InvocationTargetException.getCause() 可以获取真正的异常。
    }
}
