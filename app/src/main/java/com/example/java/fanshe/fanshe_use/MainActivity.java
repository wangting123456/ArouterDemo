package com.example.java.fanshe.fanshe_use;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射实际使用
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.反射生成类实例对象
            //1.生成类的实例对象
             //a.使用Class对象的newInstance()方法来创建该Class对象对应类的实例,这种方式要求该Class对象
               // 的对应类有默认构造器，而执行newInstance()方法时实际上是利用默认构造器来创建该类的实例
            //b.先使用Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建该Class对象对应类的实例
              //可以选择指定的构造器来构造对象
        try {
            //第一种
            Class class1 = Class.forName("com.example.java.fanshe.fanshe_use.Employee");
            Object object = class1.newInstance();
            //第二种
            Constructor<?> constructor = class1.getDeclaredConstructor(String.class);
            Object object2 = constructor.newInstance("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
         //2.new 对象和反射得到类实例对象区别
            //a.在使用反射的时候，必须确保这个类已经加载并已经连接了。使用new的时候，这个类可以没有被加载，也可以已经被加载。
            //b.new关键字可以调用任何public构造方法，而反射只能调用无参构造方法
            //c.new关键字是强类型的，效率相对较高。 反射是弱类型的，效率低。
            //d.反射提供了一种更加灵活的方式创建对象，得到对象的信息。动态代理的使用，都是基于反射的。解耦

        //二.反射调用类的方法
           //1.调用类的方法
               //a.通过Class对象getMethods()方法或者getMethod()方法获得指定方法，返回Method数组或对象
               //b.调用Method对象中的Object invoke(Object obj, Object... args)方法
                   //第一个参数对应调用该方法的实例对象，第二个参数对应该方法的参数。
        try {
            Class class2= Class.forName("com.example.java.fanshe.fanshe_use.Employee");
            Object obj = class2.newInstance();
            Method method = class2.getDeclaredMethod("setAge",int.class);
            method.setAccessible(true);
            //调用指定的函数并传递参数
            method.invoke(obj, 28);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //三.反射访问成员变量值
          //1.反射访问成员变量值
           //a.通过Class对象的getFields()方法或者getField()方法获得指定方法，返回Field数组或对象
           //b.Field提供了两组方法来读取或设置成员变量的值
               //getXXX(Object obj):获取obj对象的该成员变量的值
               //setXXX(Object obj,XXX val)：将obj对象的该成员变量设置成val值
        try {
            Class class3= Class.forName("com.example.java.fanshe.fanshe_use.Employee");
            Employee employee = (Employee)class3.newInstance();
            Log.d("DEMO","employee.age:"+employee.getAge());

            Field field = class3.getDeclaredField("age");
            field.setAccessible(true);
            field.setInt(employee,10);
            field.getInt(employee);
            Log.d("DEMO","employee.age2:"+ field.getInt(employee));

            Field gradeField = class3.getDeclaredField("name");
            // 如果是 private 或者 package 权限的，一定要赋予其访问权限
            gradeField.setAccessible(true);
            // 修改 student 对象中的 Grade 字段值
            gradeField.set(employee, "逗比");
            Object o = gradeField.get(employee);
            Log.d("DEMO","反射访问成员变量值3:"+o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //四.访问私有权限说明
         //设置暴力访问权限为.setAccessible(true);

    }
}
