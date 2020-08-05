package com.example.java.list.data_structure;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class JiHeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.对象数组
        //堆和栈
        //2.集合
        //a.
           /*                list

             Collections      set

                            queue*/
        //b.集合的遍历
        //collectionIterator()


    }

    /**
     * 集合迭代器的遍历
     */
    private void collectionIterator() {
        Collection col = new ArrayList<>();
        col.add("张三");
        col.add("李四");
        col.add("王五");
        col.add("赵六");
        Iterator iterator = col.iterator();
        while (iterator.hasNext()){
            //iterator.next() 获取元素的同时,将指针向后移动一位
            Log.d("collectionIterator",""+iterator.next());
        }

    }

    /**
     * 集合转数组遍历
     */
    private void collectiontoArray() {
        Collection col = new ArrayList() ;
        // 2. 添加元素
        col.add("鸣人") ;
        col.add("佐助") ;
        col.add("佩恩") ;
        Object[] objs = col.toArray();
        for(int x = 0 ; x < objs.length ; x++) {
            // 向下转型
            String s = (String)objs[x] ;
            System.out.println(s.length());
        }
    }
}
