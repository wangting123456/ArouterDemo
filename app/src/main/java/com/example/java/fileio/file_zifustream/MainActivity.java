package com.example.java.fileio.file_zifustream;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //字符流
        //OutPutStreamWrite outPutStreanWrite()
        //InputStreamReader inputStreamReader()

        //字符流复制文本文件
    }

    private void copyFile() throws IOException {
        // 创建转换输入流对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("OutputStreamWriterDemo.java")) ;
        // 创建转换输出流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("copyFile.java")) ;
        // 复制文件
        // 一次读取一个字符复制
//		int ch = 0 ;
//		while((ch = isr.read()) != -1){
//			osw.write(ch) ;
//		}
        // 一次读取一个字符数组复制文件
        char[] chs = new char[1024] ;
        int len = 0 ;
        while((len = isr.read(chs)) != -1){
            osw.write(chs, 0, len) ;
        }
        // 释放资源
        osw.close() ;
        isr.close() ;
    }

    private void inputStreamReader() throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("1.txt"));
        InputStreamReader reader2 = new InputStreamReader(new FileInputStream("1.txt"),"UTF-8");
        int ch = 0;
        while((ch = reader.read()) != -1){
            Log.d("inputStreamReader","ch:"+ch);
        }
        reader.close();
    }

    private void outPutStreanWrite() throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("1.txt"));
        OutputStreamWriter writer2 = new OutputStreamWriter(new FileOutputStream("1.txt"),"UTF-8");
        writer.write("中国");
        writer.close();
    }


}
