package com.example.java.list.Parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<StudentBean> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this,OtherActivity.class);
        StudentBean stu = new StudentBean("0001","zhangsan");
        list.add(stu);
        intent.putExtra("student",stu);
        intent.putParcelableArrayListExtra("list",(ArrayList<? extends Parcelable>) list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Parcelable和Serializable区别和比较
        //共同点：都是对对象进行序列化并可以使用Intent传递数据
        //区别：Serializable是java的实现方式，可能会频繁的io操作，消耗比较大。实现简单。
              //Parcelable是Android的实现方式，效率比较高，但是实现起来比较复杂。
    }
}
