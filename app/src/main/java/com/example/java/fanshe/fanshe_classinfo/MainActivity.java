package com.example.java.fanshe.fanshe_classinfo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 反射查看类信息
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.Java反射查看类信息
          //a.在取得 Class 对象后，就可以操作 Class 对象的公开方法取得类基本信息

        //2.获得Class对象
          //a.每个类被记载之后，系统就会为该类生产一个对应得Class对象，通过该Class对象就可以访问到JVM中的这个类
          //b.在Java程序中获得Class对象通常有如下三种方式
             //第一种方式 通过Class类的静态方法——forName()来实现
          try {
              Class class1 = Class.forName("com.example.java.fanshe.fanshe_classinfo.Student");
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
           }
          //第二种方式 通过类的class属性
             Class class2 = Student.class;
             //第三种方式 通过对象getClass方法
             Student student = new  Student();
             Class class3 = student.getClass();

          //3.获取Class父类对象
             Student.class.getSuperclass();

    }
}
