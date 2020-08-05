package com.example.android.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity //将我们的java普通类，变成一个能够被greendao识别的数据库类型的实体类
public class Person {
    //定义好字段后，点击MakeProject,自动生成get和set方法
    //通过这个类型标记的字段必须是Long类型的，这个字段在数据库中表示它就是主键，并且它默认就是自增的
    @Id
    private int id;
    private String username;
    private String password;
    //这个字段表示，不会被写入数据库，只是作为一个普通的java类字段，用来临时存储数据的
    @Transient
    private String mobile;

    //用来声明某变量在表中的实际字段名为EMAIL
    @Property(nameInDb = "EMAIL")
    private String emali;

    @Generated(hash = 2004823682)
    public Person(int id, String username, String password, String emali) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.emali = emali;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmali() {
        return this.emali;
    }
    public void setEmali(String emali) {
        this.emali = emali;
    }

   



}
