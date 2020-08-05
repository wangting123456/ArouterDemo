package com.example.java.fileio.file;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //File
        //构造函数
        File file1 = new File("c:\\tmp\\1.log");
        File file2 = new File("c:\\tmp","1.log");
        File file3 = new File("c:"+File.separator+"tmp");
        File file4 = new File(file3,"1.log");
    }
}
