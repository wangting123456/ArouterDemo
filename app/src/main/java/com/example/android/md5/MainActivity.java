package com.example.android.md5;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MD5简介
          //MD5 消息摘要算法 (Message-Digest Algorithm)是一种常用的信息摘要算法，
          //用于将一个文件或一大段文本转化为16字节的字符串

          //生成字符串的特点：
          //不可逆：因为不论文件/文本大小，均会转换成长度大小的字符串，转化过程中丢失了大量信息
                    //因此几乎不可能根据MD5字符串推算出原始文字
          //高度离散：只要对原文本/文件做出修改，哪怕是一个字符串，都会引起MD5字符串的巨大变化
          //弱碰撞性：因为生成字符串的高度离散性，导致构造一对文本内容不同，但MD5值相同的数据十分困难。

        //MD5使用场景
          //存储密码：数据库中存储的一般都是用户密码的MD5值，方式因服务器被盗后用户密码外泄
          //作为文件指纹：利用MD5的高度离散性，将MD5作为文件指纹，判断两个文件是否相同

    }

    /**
     * 32位加密
     */

    private String MD5Decode32(String content){
        byte[] hash = null;
        try {
            hash = MessageDigest.getInstance("MD5").digest(content.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //对生成的16位字节进行补零操作
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10){
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}
