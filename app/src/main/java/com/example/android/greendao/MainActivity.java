package com.example.android.greendao;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.greendao.gen.DaoMaster;
import com.example.android.greendao.gen.DaoSession;
import com.example.android.greendao.gen.PersonDao;

public class MainActivity extends AppCompatActivity {
    //第一步
    private DaoMaster.DevOpenHelper dbHelper;
    private SQLiteDatabase database;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private PersonDao personDao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //使用GreenDao
        setDatabase();
        //GreenDao
          //1.GreenDao优点
              //存取快、体积小、支持缓存、支持加密
          //2.使用步骤
            //一.配置
               //a.添加依赖
               //b.设置版本号和生成路径
                 /* greendao{
                    //数据库版本号，升级时修改
                   schemaVersion 1
                   //生成的DAO,DaoMaster和DaoSession的包路径，默认与表实体所在的包路径相同
                   daoPackage 'com.dev.base.model.db'
                   //生成源文件的路径。(默认源文件目录是在build目录中的(build/generated/source/greendao)
                   targetGenDir 'src/main/java'
                } */
            //2.建库建表
                 //a.创建数据库
                 DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"test.db",null);
                 //b.创建数据表
                  //GreenDAO通过ORM（Object Relation Mapping 对象关系映射）的方式创建数据表.创建一个实体类
                  //将该实体结构映射成表对应的结构
                   //b1.创建表实体

                   //b2.MakeProject
           //3.增删改查
           //5.数据库升级
              //在版本迭代时，我们经常需要对数据库进行升级，而GreenDAO默认的DaoMaster.DevOpenHelper在
              //进行数据升级时，会把旧表删除，然后创建新表，并没有迁移旧数据到新表中，从而造成数据丢失。



    }
    private void setDatabase(){
        dbHelper = new DaoMaster.DevOpenHelper(this,"notes_db",null);
        database = dbHelper.getWritableDatabase();
        daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    private void getPersonDao(){
        personDao = daoSession.getPersonDao();
    }
}
