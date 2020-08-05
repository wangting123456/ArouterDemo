package com.example.android.dialogfragment.dialogfragment_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建DialogFragment 有两种方法
        //1.复写OnCreateDialog 利用AlertDialog 或者Dialog 创建出dialog
        MyAlertDialogFragment dialogFragment = MyAlertDialogFragment.newInstance("你好");
        dialogFragment.show(getSupportFragmentManager(),"MyAlertDialogFragment");
    }
}
