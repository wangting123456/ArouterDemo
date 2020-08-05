package com.example.android.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

@Entity
public class School {
    //用来声明和“对多”关系，referencedJoinProperty 指定实体中与外联实体属性相对应的外键
    @ToMany(referencedJoinProperty = "fk_schoolId")
    private List<Person> mList;
}
