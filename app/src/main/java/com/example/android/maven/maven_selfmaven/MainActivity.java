package com.example.android.maven.maven_selfmaven;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //a.上传自己的Library (或者插件) 到本地仓库。然后再引用自己的本地仓库
        //b.上传自己的Library
           //以下是自定义的控件类库,需要在不同的项目中使用，我们可以拷贝到这些项目中
           //然后在app/build.gradle中添加依赖implementation project(’:OXViewLib’)，这样就可以在项目中使用了
           //突然有一天我发现了一个bug，并把它修复了，但是只有一个项目中的类库修复，其他的项目中类库还是有bug
           //这样不算共享库

           //为了解决这个问题，我们可以将这个类库发布到本地Maven中，然后在不同的项目中，引用该库即可，
           //以下是发布本地仓库流程

        //c.uploadArchives 上传档案
          //uploadArchives是发布仓库到中央库的Task,我们需要指定本地仓库路径和一些库的信息

        //d.使用本地仓库中的类库
          //在使用的时候，需要告诉gradle去哪里找到我们所需要的类库，在项目工程的build.gradle中，我们需要告诉gradle本地仓库的地址

        //e.然后在app下build.script中添加依赖implementation 'com.demo.mymaven:MyViewLib:1.0.0'
    }
}
