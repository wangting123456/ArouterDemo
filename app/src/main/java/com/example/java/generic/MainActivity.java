package com.example.java.generic;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.livedata.activity.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //泛型类，把泛型定义到类上
     /*   public <T> void show(T t) {

        }*/
       /* Conrainer<String,String> conrainer = new Conrainer<String,String>("11","12");
        Conrainer<String,Integer> c2 = new Conrainer<>("age",22);*/

        //泛型方法
      /*  public <T> T fun(T t){   // 可以接收任意类型的数据
            return t ;     // 直接把参数返回
        }*/

        //泛型接口
        InterTest<String> inter = new InterTestImpl<String>();
        inter.show("hello");

        //通配符
     /*   它表示集合中的所有元素都是Animal类型或者其子类
          List<? extends Animal>*/
        List<? extends Animal> list = new ArrayList<Cat>();


        //它表示集合中的所有元素都是Cat类型或者其父类
       /* List <? super Cat>*/

    }

}
