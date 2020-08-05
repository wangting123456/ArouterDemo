package com.example.java.fileio.file_buffer_zifustream;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        //高效
        //BufferReader
        //BufferWriter

    }

    private void bufferWriter() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("1.txt")));
        writer.write("你好");
        writer.close();
    }

    private void bufferReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("1.txt")));
        // 读取数据
//		int ch = 0 ;
//		while((ch = br.read()) != -1){
//			System.out.print((char)ch);
//		}
        char[] chs = new char[1024];
        int len = 0;
        while ((len = reader.read(chs)) != -1) {
            System.out.print(new String(chs, 0, len));
        }
        // 释放资源
        reader.close();
    }
}
