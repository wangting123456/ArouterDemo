package com.example.java.fanshe.fanshe_libi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 反射利弊
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.反射实用场景
         //a.Java的反射机制在做基础框架的时候非常有用，有一句话这么说来着：反射机制是很多Java框架的基
           //石。而一般应用层面很少用，不过这种东西，
         //b.当你做一个软件可以安装插件的功能，你连插件的类型名称都不知道，你怎么实例化这个对象呢？
           //因为程序是支持插件的（第三方的），在开发的时候并不知道 。所以无法在代码中 New出来 ，但反
           //射可以，通过反射，动态加载程序集，然后读出类，检查标记之后再实例化对象，就可以获得正确的类实例
         //c.在编码阶段不知道那个类名，要在运行期从配置文件读取类名, 这时候就没有办法硬编码new
           //ClassName(),而必须用到反射才能创建这个对象.反射的目的就是为了扩展未知的应用。

        //2.尽量远离反射
          //a.反射：在流行的库如Spring和Gson，Retrofit中，反射自然有其用武之地。
          //b.如果这样做就无法得到编译期的安全保证。就像上面这个示例一样，你会发现如果getDeclaredField()
             //方法调用的参数输错了，那么只有在运行期才能发现。要知道的是，寻找运行期Bug的难度要远远超
             //过编译期的Bug

        //3.反射的利弊
           //反射机制是一种程序自我分析的能力。用于获取一个类的类变量，构造函数，方法，修饰符。
           //优点：运行期类型的判断，动态类加载，动态代理使用反射。博客
           //缺点：性能是一个问题，反射相当于一系列解释操作，通知jvm要做的事情，性能比直接的java代码要慢很多。
    }
}
