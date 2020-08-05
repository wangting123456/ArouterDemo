package com.example.java.fileio.file_zijiestream;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.FileOutPutStream
        //a.构造函数
           //FileOutputStream fos = new FileOutputStream("1.txt");
           //FileOutputStream fos2 = new FileOutputStream(new File("1.txt"));
           //fileOut();
        //b.FileOutPutStream写出换行追加的函数
           //fileOut2();

        //2.FileInputStream
          //read() 一次读取一个字节
        //3.字节流复制文本文件(一次读取一个字节) copyFile()
        //4.字节流复制文本文件(一次读取一个字节数据)copyFile()
    }

    private void copyFile2() throws IOException {
        FileOutputStream fos = new FileOutputStream("copy.java");
        FileInputStream fis = new FileInputStream("MainActivity.java");
        byte[] buffer = new byte[1024];//一次读取一个字节数组复制文件
        int len = 0;//记录读取到的有效的字节个数
        while ((len = fis.read(buffer))!= -1){
            fos.write(len);
        }
        fis.close();
        fos.close();
    }

    private void copyFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("copy.java");
        FileInputStream fis = new FileInputStream("MainActivity.java");
        int data = 0;
        while ((data = fis.read())!= -1){
            fos.write(data);
        }
        fis.close();
        fos.close();
    }


    private void fileOut2() throws IOException {
        FileOutputStream fos = new FileOutputStream("2.txt", true);
        for (int i = 0; i < 5; i++) {
            byte[] data = ("呵呵" + i + "\r\n").getBytes();
            fos.write(data);
        }
        fos.close();
    }

    private void fileOut() throws IOException {
        FileOutputStream fos = new FileOutputStream("1.txt");
        String str = "你好，我来了";
        byte[] data = str.getBytes();
        fos.write(data);
        fos.close();

    }
}
