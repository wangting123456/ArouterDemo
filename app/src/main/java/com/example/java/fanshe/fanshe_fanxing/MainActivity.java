package com.example.java.fanshe.fanshe_fanxing;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

/**
 * 泛型和反射
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.泛型和Class类
          //a.从JDK 1.5之后，Java引入泛型机制，Class类也增加了泛型功能，从而可以使用泛型来约束Class
             //例如String.class的类型 Class<String>,如果Class对应的类暂时未知,Class<?> ?是通配符
          //b.泛型的好处众多，最主要的一点就是避免类型转换
             //上面程序是个工厂类，通过指定的字符串创建Class对象并创建一个类的实例对象返回
             Date date = (Date) ObjectFactory.getInstance("java.util.Date");
          //c.泛型出现后，就可以避免这种情况
             String instance =ObjectFactory2.getInstance(String.class);
              //通过传入String.class便知道T代表String，所以返回的对象是String类型的
    }
}
