package com.example.java.design.moshi_moban;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.java.design.moshi_moban.demo.Human;
import com.example.java.design.moshi_moban.demo.HumanMode;
import com.example.java.design.moshi_moban.demo2.Cricket;
import com.example.java.design.moshi_moban.demo2.Football;
import com.example.java.design.moshi_moban.demo2.Game;


/**
 * 模板模式
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //优点:封装不变部分，扩展可变部分；行为有父类控制，子类实现
        //应用实例:西游记里面菩萨定好的 81 难
                   //多个子类有公有的方法，并且逻辑基本相同时
        //使用 Game 的模板方法 play() 来演示游戏的定义方式
        Game game = new Football();
        game.play();
        Game game1 = new Cricket();
        game1.play();

        HumanMode humanMode = new Human();
        humanMode.lifeday();
    }
}
