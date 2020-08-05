package com.example.java.design.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        //Invocation调用  Handler 处理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        //invoke 援引，援用
                        System.out.println("开始事务2");
                        Object returnValue =  method.invoke(target,objects);
                        System.out.println("提交事务2");
                        return returnValue;
                    }
                });
    }
}
