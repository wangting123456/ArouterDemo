package com.example.java.generic;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NormalUseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List list = new ArrayList();
        list.add("123");
        list.add("456");
        System.out.println((String)list.get(0));

        List<String> mList = new ArrayList<String>();
        mList.add("123");
        mList.add("456");
        System.out.println(list.get(0));
    }
}
