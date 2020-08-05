package com.example.java.design.proxy.dynamic_proxy;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        举个例子来说明代理的作用:假设我们想邀请一位明星,那么并不是直接连接明星,而是联系明星的经纪人,
          来达到同样的目的.明星就是一个目标对象,他只要负责活动中的节目,而其他琐碎的事情就交给他的代理人
          (经纪人)来解决.这就是代理思想在现实中的一个例子*/
       // 1.代理对象,不需要实现接口
       // 2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
       // 3.动态代理也叫做:JDK代理,接口代理
        // 目标对象
        IUserDao target = new UserDao();

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
        proxy.setName("张三");
    }
}
