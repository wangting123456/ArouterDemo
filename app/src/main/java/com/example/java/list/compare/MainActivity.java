package com.example.java.list.compare;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;
import com.example.java.list.compare.bean.ScreenSendUpBean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ScreenSendUpBean> mList = new ArrayList<>();
    private String TAG = MainActivity.class.getSimpleName();
    private DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_list_compare_main);
        initList();
        Collections.sort(mList, new Comparator<ScreenSendUpBean>() {
            @Override
            public int compare(ScreenSendUpBean o1, ScreenSendUpBean o2) {
                try {
                    long time1 = sdf.parse(o1.getCretime()).getTime();
                    long time2 = sdf.parse(o2.getCretime()).getTime();
                    //1是正序；-1是倒序
                    if(time1 - time2 > 0){
                        return -1;
                    }else if(time1 - time2 == 0){
                        return 0;
                    }else {
                        return 1;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        for(ScreenSendUpBean bean:mList){
            Log.d(TAG,"bean排序后:"+bean.getName());
        }
        paixun();
        //https://www.cnblogs.com/yw0219/p/7222108.html?utm_source=itdadao&utm_medium=referral

    }

    private void initList(){
        mList.add(new ScreenSendUpBean("1","2020-03-23"));
        mList.add(new ScreenSendUpBean("2","2020-03-22"));
        mList.add(new ScreenSendUpBean("3","2020-03-21"));
        mList.add(new ScreenSendUpBean("4","2020-03-24"));
        mList.add(new ScreenSendUpBean("5","2020-03-25"));
        for(ScreenSendUpBean bean:mList){
            Log.d(TAG,"bean:"+bean.getName());
        }
    }

    private void paixun(){
        //Collections.sort的两种用法
        //第一种:
        List<Integer> intList = Arrays.asList(2, 3, 1);
        Log.d(TAG,"第一种 before sort");
        for(Integer i:intList){
            Log.d(TAG,""+i);
        }
        Log.d(TAG,"=========================");
        Collections.sort(intList);
        Log.d(TAG,"第一种 after sort");
        for(Integer i:intList){
            Log.d(TAG,""+i);
        }
        //before 2 3 1   after 1 2 3 可以看出默认的排序是正序，如何实现逆序呢，就需要第二种方法
        //第二种:即通过实现Comparator接口的compare方法来完成自定义排序
        Log.d(TAG,"第二种 before sort");
        List<Integer> intList2 = Arrays.asList(2, 3, 1);
        for(Integer i:intList2){
            Log.d(TAG,""+i);
        }
        Log.d(TAG,"=========================");
        Collections.sort(intList2,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 返回值为int类型，大于0表示正序，小于0表示逆序
               /* return o2-o1;*/  //3 2 1 倒序
                return o1-o2; //正序列
            }
        });
        Log.d(TAG,"第二种 after sort");
        for(Integer i:intList2){
            Log.d(TAG,""+i);
        }
        //after 3 2 1
    }
}
