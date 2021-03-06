package com.example.java.static_shenru;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * static 深入
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.static 的作用和特点
           //a.可以用来修饰 成员变量，成员方法，代码块，内部类具体如下
              //1>.修饰成员变量和成员方法
                    //被static修饰的成员属于类，不属于单个这个类的某个对象，被类中所有对象共享，并且可以建议通过类名调用
                    //被static修饰的成员变量属于静态成员变量，静态变量存放在java内存区域的方法区
              //2>.静态代码块
                    //静态代码块定义在类中方法外，静态代码块在非静态代码块之前执行(静态代码块->非静态代码块->构造方法)
                    //该类不管创建多少个对象，静态代码块只执行一次
              //3>.静态内部类（static修饰类的话只能修饰内部类）
              //4>.静态内部类与非静态内部类之间存在一个最大的区别:
                   //非静态内部类在编译之后会隐含的保存着一个引用，该引用指向创建他的外围。但是静态内部类却没有
                   //没有这个引用就意味着：1.它的创建是不需要依赖外围类的创建。2.它不能使用任何外围类的非static成员变量和方法。
              //5>.静态导包
         //b.static关键字的特点
            //1>.随着类的加载而加载
            //2>.优先于对象存在
            //3>.被类的所有对象共享
            //4>.可以通过类名调用
         //c.static的注意事项
            //1>.在静态方法中，是没有this关键字的
              //静态是随着类的加载而加载，this是随着对象的创建而存在
              //静态比对象优先存在
            //2>.静态方法只能访问静态的成员变量和静态的成员方法
        //2.static变量存储位置
          //a.存储在JVM的方法区中
          //b.static变量是类被加载时被初始化，存储在JVM的方法区内，整个内存中只有一个static内存的拷贝，
            //可以通过类名直接访问，也可以通过类的实例化对象访问，一般不推荐通过实例化对象访问，通俗的
            //讲static变量属于类，不属于对象。任何实例化的对象访问的都是同一个static变量
        //3.用static静态变量潜在性问题
          //a.占用内存，一般不会释放
          //b.在系统不够内存情况下会自动回收静态内存，这样就会引起访问全局静态错误
          //c.在Android中不能将activity作为static静态对象，这样使activity的所有组件对象都存入全局内存中，并且不会被回收
        //4.静态变量的生命周期
          //a.类在什么时候被加载?
          //b.当我们启动一个app的时候，系统会创建一个进程，此进程会加载一个Dalvik VM的实例,然后代码就运行
            //在DVM之上，类的加载和卸载，垃圾回收等事情都由DVM负责.也就是说在进程启动的时候，类被加载，静态变量被分配内存。
        //5.静态变量何时销毁
           //类在什么时候被卸载？在进程结束的时候。
        //6.静态引用的对象回收
           //只要静态变量没有被销毁也没有置null，其对象一直被保持引用，也即引用计数不可能是0，因此
           //不会被垃圾回收。因此，单例对象在运行时不会被回收
        //7.静态变量和成员变量的区别
           //A:所属不同
             //静态变量属于类，所以也称为类变量
             //成员变量属于对象，所以也称为实例变量(对象变量)
           //B:内存中位置不同
             //静态变量存储于方法区的静态区
             //成员变量存储于堆内存
           //C:内存出现时间不同
            //静态变量随着类的加载而加载，随着类的消失而消失
            //成员变量随着对象的创建而存在，随着对象的消失而消失
           //D:调用不同
            //静态变量可以通过类名调用，也可以通过对象调用
            //成员变量只能通过对象名调用
    }
}
