package com.example.android.gradle.gradle_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //基础知识
          //a.Android Studio 不知道如何将Java /Kotlin 文件编译成apk
              //Gradle也不知道如何将Java /Kotlin 文件编译成apk
          //b.Gradle 是一个构建工具，着重于构建自动化和多功能开发，如何你在任何平台上构建，测试
             //发布和部署软件，Gradle 提供了一个灵活的模型，可以支持从编译和打包代码到发布的整个开发生命周期。
          //c.Gradle本身实际上不能做太多东西，所有有用的功能都来自丰富的插件生态系统。就像Gradle使用插件
             //来扩展自己的功能一样。有很多与 Gradle 捆绑在一起的插件，以及更多可以下载的插件。

        //Android Plugin For Gradle
          //Android Plugin For Gradle是一个使 Gradle 能够将您的代码编译成密钥签名APK文件的插件。
          //没有它，Gradle就无法对代码做任何事情，这也就是我前面说的 Android Studio 和 Gradle 不知道如何构建你的 Android 项目。

        //gradle-wrapper.properties
          //决定在构建项目时，使用那个Gradle版本，它将随后会自动为你下载并保存该版本的 Gradle。

        //settings.gradle
          //文件是保存在你通知 Gradle 的地方，如果你将另一个模块添加到你的工程中，Android Studio 将会自动将其添加到这个文件中。

        //build.gradle
          //根目录的build.gradle
          //app 模块的 build.gradle


    }
}
