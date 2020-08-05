package com.example.zujianhua.zujianhua_kuangjia;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //https://github.com/yangchong211/YCBlogs/blob/master/android/组件化/03.组件化框架.md
        //组件化需要考虑的问题
        //一切皆组件
        //1.代码解耦:对已存在的项目进行模块拆分，模块分为两种类型，一种是功能组件模块，封装一些公共的方法服务等，作为依赖库对外提供；
                    // 另一种是业务组件模块，专门处理业务逻辑等功能，这些业务组件模块最终负责组装APP。
        //2.组件单独运行:通过 Gradle脚本配置方式，进行不同环境切换，我自己操作是添加一个boolean值的开关。比如只需要把 Apply plugin: 'com.android.library' 切换成Apply plugin: 'com.android.application' 就可以独立运行呢！
                        //需要注意：当切换到application独立运行时，需要在AndroidManifest清单文件上进行设置，因为一个单独调试需要有一个入口的Activity。
        //3.组件间通信:Arouter
        //4.让各个业务变得相对独立，业务组件在组件模式下可以独立开发，而在集成模式下又可以变为AAR包集成到“APP壳工程”中，组成一个完整功能的 APP。

    }
}
