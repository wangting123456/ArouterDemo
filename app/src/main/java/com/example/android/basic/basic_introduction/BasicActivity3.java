package com.example.android.basic.basic_introduction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class BasicActivity3 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //"后进先出"模式
        //Standard 标准模式
        /**
         * 每启动一次Activity，就会创建一个新的Activity实例，并置于栈顶，谁启动了Activity,那么这个Activity就运行在启动它的那个Activity所在的栈中。
         */
        //SingleTop 栈顶复用
        /**
         * 如果需要新建的Activity位于任务栈栈顶，那么此Activity的实例就不会重建，而是重用栈顶的实例。并回调如下方法onNewIntent
         */
        //SingleTask栈内复用
        /**
         * 该模式是一种单例模式，即一个栈内只有一个该Activity实例。
         * 该模式，可以通过在AndroidManifest文件的Activity中指定该Activity需要加载到那个栈中，即singleTask的Activity可以指定想要加载的目标栈。
         * singleTask和taskAffinity配合使用，指定开启的Activity加入到哪个栈中。
         */
        //SingleInstance 单例模式
        /**
         * 作为栈内复用模式（singleTask）的加强版,打开该Activity时，直接创建一个新的任务栈，并创建该Activity实例放入新栈中。一旦该模式的Activity实例已经存在于某个栈中，任何应用再激活该Activity时都会重用该栈中的实例。
         */



    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
