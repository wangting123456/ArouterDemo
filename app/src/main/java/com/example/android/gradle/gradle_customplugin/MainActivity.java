package com.example.android.gradle.gradle_customplugin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.Gradle插件类型
          //a.项目中的gradle文件里编写，这种方式的缺点是无法复用插件代码，在其他项目中还得复制一遍代码
          //b.在独立的项目里编写插件，然后发布到中央仓库，之后直接引用就可以了，优点是可以直接复用

        //2.Gradle插件
          //Gradle插件是使用Groovy开发的，而Groovy是可以兼容Java的，Android Studio除了可以开发Android App之外
          //完全可以胜任开发Android 插件这一块

        //3.开发插件
          //a.新建一个Android工程;在该工程中新建一个Android Module项目，类型选择Android Library
          //b.将Module里的内容删除，只保留build.gradle文件和src/main目录，同时移除build.gradle文件里的内容
          //c.建立gradle插件目录
          //d.定义插件名字
              //在resources/META-INF/gradle-plugins目录下新建一个properties文件
              //注意该文件的命名就是你使用插件的名字 com.demo.myplugin.properties  apply plugin: 'com.demo.myplugin'

        //4.插件发布
          //前面我们已经自定义好了插件，接下来就是要打包到Maven库里面去了，你可以选择打包到本地，或者是远程服务器中。

        //5.插件的使用
          //发布到本地maven仓库的插件如何使用，在项目根目录下的gradle.build的文件中加入：
          // 使用自定义插件
          //在项目根目录下的gradle.build 加入 classpath 'com.demo.myplugin:GradlePlugin:1.0'
          //app目录下的build.gradle文件中加入：apply plugin: 'com.demo.myplugin' 是resources/META-INF/gradle-plugins的名字
    }
}
