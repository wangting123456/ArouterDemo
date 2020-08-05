package com.example.android.window.window_inflater;

import android.content.Context;
import android.view.LayoutInflater;

import com.example.Application;

import java.util.zip.Inflater;

public class MainActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //1.LayoutInflater 介绍
           //a.LayoutInflater可以把xml文件加载成View。
           //b.LayoutInflater也可以用过Context获取，他是系统服务的一种,，被注册在ContextImpl的map里，
                // 然后通过LAYOUT_INFLATER_SERVICE来获取
            LayoutInflater inflater = (LayoutInflater)this.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

         //2.PhoneLayoutInflater
          //LayoutInflater是一个抽象类，它的实现类是PhoneLayoutInflater，LayoutInflater会采用深度优先遍历
          //自顶向下遍历树，根据View的全路径名，利用反射获取构造器，从而构建View实例

        //3.inflate()源码分析
          //3.1
          //public View inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)
          //resource：布局ID
          //root:它用来表示根布局
          //attachToRoot:表示是否要添加到父布局root中去

        //注意：
       /* 这个root到底有什么作用呢？它主要有两个方面的作用：
        当attachToRoot == true且root ！= null时，新解析出来的View会被add到root中去，然后将root作为结果返回。
        当attachToRoot == false且root ！= null时，新解析的View会直接作为结果返回，而且root会为新解析的View生成LayoutParams并设置到该View中去。
        当attachToRoot == false且root == null时，新解析的View会直接作为结果返回。
        注意第二条和第三条是由区别的，你可以去写个例子试一下，当root为null时，
        新解析出来的View没有LayoutParams参数，这时候你设置的layout_width和layout_height是不生效的。*/

          //3.2 Activity中的LayoutInflater
           //Activity里的布局应该也是LayoutInflater加载的，我也没做什么处理，但是我设置的layout_width和
           // layout_heigh参数都是可以生效的
    }
}
