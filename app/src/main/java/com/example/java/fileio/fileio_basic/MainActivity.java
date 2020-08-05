package com.example.java.fileio.fileio_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.IO流分类
          //字节流:
           /*输入流:InputStream
             输出流:OutPutStream
           */
          //字符流: 文件通过windows自带的记事本打开并能读懂里面的内容，就用字符流。其他用字节流.你什么都不知道，就用字节流
           /*输入流:Reader
             输出流:Writer
           */

         //2.字节流和字符流的区别
           //字节流:以字节为单位8bit，字节流能处理所有类型的数据(图片,AI)
           //字符流:以字符为单位，只能处理字符类型的数据，比如文本

        //3.什么是字节:就是8bit，一个字节
            //什么是字符:由于字节流操作中文不是很方便，所有有了字符流
    }
}
