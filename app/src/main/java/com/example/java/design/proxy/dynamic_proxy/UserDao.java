package com.example.java.design.proxy.dynamic_proxy;

/**
 * 目标对象
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }

    @Override
    public void setName(String name) {
        System.out.println("----设置的name是----"+name);
    }
}
