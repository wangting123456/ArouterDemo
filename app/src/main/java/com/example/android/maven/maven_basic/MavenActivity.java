package com.example.android.maven.maven_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MavenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.Android Studio Maven 仓库使用
          //如果你想在项目中引用一个library库，只需要在build.gradle中添加一句话
          //compile 'com.inthecheesefactory.thecheeselibrary:fb-like:0.9.3'

          //a.就可以引用该库。你可能很好奇Android Studio是从哪里得到这个library的。
          //b.你可能很好奇Android Studio是从哪里得到这个library的。这篇文章将详细讲解这是怎么回事
          //c.包括如何把你的库发布出去分享给世界各地的其他开发者，这样不仅可以让世界更美好，还可以耍一次酷。

        //2.Android Studio 从哪里得到库
          //a.我相信不是每个人都完全明白Android studio 是从哪里得到这些library的。莫非就是Android studio 从google搜索然后下载了一个合适的给我们？
          //b.Android Studio是从build.gradle里面定义的Maven 仓库服务器上下载library的。
              //Apache Maven 是Apache 的一个开发工具，提供了用于贡献library的文件服务器
              //总的来说，只有两个标准的Android Library文件服务器 jcenter 和  Maven Central

        //3.jcenter
          //jcenter是一个由 bintray.com维护的Maven仓库
          //我们在项目的build.gradle
          //allprojects {
             //    repositories {
             //        jcenter()
             //    }
             //}
        //4.Maven Central
          //Maven Central 则是由sonatype.org维护的Maven仓库
          //我们在项目的build.gradle 文件中如下定义仓库，就能使用Maven Central了：
          //allprojects {
            //    repositories {
            //        mavenCentral()
            //    }
            //}

         //虽然jcenter和Maven Central都是标准的Android Library服务器，但是它们维护在完全不同的服务器上，由不同的人提供内容
         //它们两个毫无任何关系，在jcenter上有的可能 Maven Central 上没有，反之亦然。


        //5.自定义特有的仓库服务器
        /*   repositories {
              maven { url 'https://maven.fabric.io/public' }
          }*/

        //6.理解jcenter 和 Maven Central
          //为何有两个标准的仓库
            //共同点：提供Java或者Android library服务。上传到哪个（或者都上传）取决于开发者。
            //不同点：jcenter 通过CDN发送library，开发者可以享受到更快的下载体验。
                      //jcenter是全世界最大的Java仓库，因此在Maven Central 上有的，在jcenter上也极有可能有。换句话说jcenter是Maven Central的超集。
                      //上传library到仓库很简单，不需要像在 Maven Central上做很多复杂的事情。

        //7.gradle 是如何从仓库上获取Library的？
          //比如：compile 'com.inthecheesefactory.thecheeselibrary:fb-like:0.9.3'
          //library的字符串形式包含三个部分：GROUP_ID:ARTIFACT_ID:VERSION
          //GROUP_ID是com.inthecheesefactory.thecheeselibrary ，ARTIFACT_ID是fb-like，VERSION是0.9.3。
          //然后Android Studio 将下载这些文件到我们的电脑上，与我们的项目一起编译。整个过程就是这么简单
    }
}
