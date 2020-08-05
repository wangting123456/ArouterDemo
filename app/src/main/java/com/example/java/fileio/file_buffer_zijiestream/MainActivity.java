package com.example.java.fileio.file_buffer_zijiestream;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //高效
        //BufferOutPutStream bufferOutPut()
        //BufferInPutStream
    }

    private void bufferOutPut() throws IOException {
        BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream("1.txt"));
        buffer.write("你好".getBytes());
        buffer.close();
    }

    private void bufferInout() throws IOException {
        BufferedInputStream input = new BufferedInputStream(new FileInputStream("1.txt"));
        // 一次读取一个字节
        //int by = 0 ;
        //while((by = bis.read()) != -1){
        //    System.out.print((char)by);
        //}
        // 一次读取一个字节数组
        byte[] bytes = new byte[1024] ;
        int len = 0 ;
        while((len = input.read(bytes)) != -1){
            System.out.print(new String(bytes , 0 , len));
        }
        // 释放资源
        input.close();
    }
}
