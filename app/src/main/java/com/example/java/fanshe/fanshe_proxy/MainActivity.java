package com.example.java.fanshe.fanshe_proxy;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 动态代理
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.代理分类说明
          //a.静态代理
            //代理类是在编译时就实现好的。也就是说 Java 编译完成后代理类是一个实际的 class 文件
          //b.动态代理
            //代理类是在运行时生成的，也就是说Java编译完成之后并没有实际的 class 文件，而是在运行时
            //动态生成的类字节码，并加载到JVM中

        //二.什么是动态代理
          //1.动态代理定义
             //a.代理对象是中介，原对象是房东的房子，客户就是我们需要找房的人。
          //2.动态代理参与者
        //三.动态代理要掌握
          //1.为何需要动态代理
             //动态代理：代理类是在运行时生成的。也就是说Java编译完之后并没有实际的class文件，而是在
                       //运行时动态生成的类字节码，并加载到JVM中
          //2.动态代理组成元素
             //为其他对象提供一种代理以控制对这个对象的访问
          //3.为何用到反射
             //Java 反射机制在程序运行时，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意
             //一个对象，都能够调用它的任意一个方法和属性。这种 动态的获取信息 以及 动态调用对象的方法
             //的功能称为 java 的反射机制。
        //四.动态代理原理
          //1.实现动态代理步骤
          //2.重要类介绍
           //a.java.lang.reflect.Proxy: 这是生成代理类的主类，通过 Proxy 类生成的代理类都继承了 Proxy 类，
               //即 DynamicProxyClass extends Proxy。
          //b.java.lang.reflect.InvocationHandler: 这里称他为"调用处理器"，他是一个接口，我们动态生成
              //的代理类需要完成的具体内容需要自己定义一个类，而这个类必须实现 InvocationHandler 接口。
    }
}
