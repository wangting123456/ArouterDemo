package com.example.android.greendao;

import org.greenrobot.greendao.annotation.ToOne;

public class Student {
    //外键
    private long fk_schoolId;

    //对一 实体属性，与外联实体中的fk_schoolId相对应
    @ToOne(joinProperty = "fk_schoolId")
    private School school;
}
