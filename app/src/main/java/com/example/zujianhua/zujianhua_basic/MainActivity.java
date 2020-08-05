package com.example.zujianhua.zujianhua_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //什么是组件化
        //偏重单一功能的内聚，哪个组件坏了，整个系统可正常运行

        //什么是模块化
        //登陆模块，注册模块，搜索模块等等 偏向业务功能

      /*  简单来说，组件化相比模块化粒度更小，两者的本质思想都是一致的，都是把大往小的方向拆分，都是为了复用和解耦，
        只不过模块化更加侧重于业务功能的划分，偏向于复用，组件化更加侧重于单一功能的内聚，偏向于解耦。*/

        //组件化好处
        //1.提高编译效率，组件单独编译
        //2.稳定的公共模块可以使用依赖库的方式，给公共线使用，减少重复开发
        //3.每个组件有自己独立的版本，可以独立编译，打包，测试和部署。每个程序员有自己的模块，减少代码冲突
        //4.避免模块之间的交叉依赖
        //5.定制项目可按需加载，组件之间可以灵活组建，快速生成不同类型的定制产品。
        //6.引用的第三方库代码统一管理，避免版本统一，减少引入冗余库。
           //这个可以创建一个公共的gradle管理的文件，比如一个项目有十几个组件，想要改下某个库或者版本号，
           //总不至于一个个修改吧。这个时候提取公共十分有必要

        //区分插件化和组件化
        //插件化是基于多apk的，组件化还是一个apk
        //组件化目标:组件化的目标之一就是降低整体工程（app）与组件的依赖关系，缺少任何一个组件都是可以存在并正常运行的。
                     //app主工程具有和组件进行绑定和解绑的功能。

        //application和library
        //library:第三方lib，称为依赖库
        //application:也称为Component，这种module是一个完整的功能模块。下面讲的组件也就是Component

        //在项目的build.gradle
        //控制组件模式和集成模式
       /* if (rootProject.ext.isDouBanApplication) {
            //是Component，可以独立运行
            apply plugin: 'com.android.application'
        } else {
            //是lib，被依赖
            apply plugin: 'com.android.library'
        }*/

    }
}
