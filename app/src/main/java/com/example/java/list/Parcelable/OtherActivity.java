package com.example.java.list.Parcelable;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class OtherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentBean stu = getIntent().getParcelableExtra("student");
        List<StudentBean> list =  getIntent().getParcelableArrayListExtra("list");
    }
}
