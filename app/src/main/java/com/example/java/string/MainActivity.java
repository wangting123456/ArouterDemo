package com.example.java.string;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.String的创建机理
          //a.Java为了避免在一个系统中产生大量的String对象，引入了字符串常量池，
          //b.其运行机制是：创建一个字符串时，首先检查池中是否有值相同的字符串对象。如果有则不需要创建直接从池中刚查找到的对象引用
             //如果没有则新建字符串对象，返回对象引用，并且将新创建的对象放入池中。
          //c.通过new方法创建的String对象是不检查字符串池的，而是直接在堆区或栈区创建一个新的对象，也不会把对象放入池中
          String str = "123";//通过直接量赋值方式，放入字符串常量池
          String s = new String("123");//通过new方式赋值方式，不放入字符串常量池
        //2.StringBuffer/StringBuilder
          //a.其底层在内存中的存储方式与String相同，都是以一个有序的字符序列（char类型的数组）进行存储
          //b.不同点是StringBuffer/StringBuilder对象的值是可以改变的,并且值改变以后，对象引用不会发生改变
          //c.两者对象在构造过程中，首先按照默认大小申请一个字符数组，由于会不断加入新数据，当超过默认大小后
            //会创建一个更大的数组，并将原先的数组内容复制过来，再丢弃旧的数组。因此，对于较大对象的扩大
            //会涉及大量的内存复制操作，如果能够预先评估大小，可提升性能。
        //3.String 不可变性天生具备线程安全，可以在多个线程中安全地使用。
    }
}
