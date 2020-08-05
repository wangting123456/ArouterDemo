package com.example.java.list.data_structure;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取功能
       /*  Set<Map.Entry<K,V>> entrySet(): 返回一个键值对的Set集合
        V get(Object key):根据键获取值
        Set<K> keySet():获取集合中所有键的集合
        Collection<V> values():获取集合中所有值的集合*/

       //1.Map存储数据
         /* Map<String,String> map = new HashMap<>();
            map.put("语文","111");
            map.put("数学","222");
            map.put("英语","333");*/
       //2.查找数据
          // Object value = map.get(key);
        //3.遍历数据
           // foreach：参考map()
           //迭代器:参考map2()
    }

    /**
     * map集合遍历：根据键值对对对象遍历
     */
    private void map(){
        Map<String,String> map = new HashMap<>();
        map.put("语文","111");
        map.put("数学","222");
        map.put("英语","333");
        Set<Map.Entry<String,String>> set = map.entrySet();
        for (Map.Entry<String,String> bean:set){
            Log.d("map2",bean.getKey());
            Log.d("map2",bean.getValue());
        }
    }

    /**
     * map集合遍历：根据键找对应的值
     */
    private void map1(){
        Map<String,String> map = new HashMap<>();
        map.put("语文","111");
        map.put("数学","222");
        map.put("英语","333");
        Set<String> set = map.keySet();
        for (String str:set){
            Log.d("map1",map.get(str));
        }
    }
    private void map2(){
        Map<String,String> map = new HashMap<>();
        map.put("语文","111");
        map.put("数学","222");
        map.put("英语","333");
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        //迭代器
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            Log.d("map2",entry.getKey());
            Log.d("map2",entry.getValue());
        }

    }





}
