package com.example.java.fanshe.fanshe_objectinfo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * 获取对象信息
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.获取class对象的信息
          //a.由于反射最终要有类参与，因此反射的组成一般有以下
             //1.java.lang.Class.java：类对象；
             //2.java.lang.reflect.Constructor.java：类的构造器对象；
             //3.java.lang.reflect.Method.java：类的方法对象；
             //4.java.lang.reflect.Field.java：类的属性对象；
          //b.获取所有构造方法
             //public Constructor<?>[] getConstructors();
             //public Constructor<?>[] getDeclaredConstructors();获取所有的构造方法
          //c.获取单个构造方法
             //public Constructor getConstructor(Class<?>... parameterTypes)
             //public Constructor getDeclaredConstructor(Class<?>... parameterTypes)
          //d.方法关键字
             //getDeclareMethods()获取所有方法
             //getReturnType()获取方法的返回值类型
             //getParameterTypes()获取方法的传入参数类型
             //getDeclareMethod("方法名,参数类型.class,....") 获得特定方法
          //e.成员变量
             //getDeclaredFields()获取所有成员变量
             //getDeclaredField(参数类型.class,....) 获取特定成员变量
          //f.父类和父接口
            //getSuperclass() 获取某类的父类
            //getInterfaces() 获取某类实现的接口
        //2.获取对象的变量
            //a.获取class对象的成员变量
              Class<? extends Student> class1 = Student.class;
              Field[] fields = class1.getDeclaredFields();//获取class对象的所有属性
              Field[] fields_public = class1.getFields();//获取class对象的public属性
         try {
             Field ageField = class1.getDeclaredField("age");//获取class指定属性
             Field desField = class1.getField("des");//获取class指定的public属性
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //3.获取class对象的方法
        Class<? extends Student> class2 = Student.class;
        Method[] methods = class2.getDeclaredMethods();//获取class对象的所有声明方法
        Method[] methods_public = class2.getMethods();//获取class对象的所有public方法 包括父类的方法
        try {
            Method method = class2.getMethod("info", String.class);//返回次Class对象对应类的、带指定形参列表的public方法
            Method declaredMethod = class2.getDeclaredMethod("info", String.class);//返回次Class对象对应类的、带指定形参列表的方法
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //4.获取class对象的构造函数
        try {
            Constructor<?>[] allConstructors = class2.getDeclaredConstructors();//获取class对象的所有声明构造函数
            Constructor<?>[] publicConstructors = class1.getConstructors();//获取class对象public构造函数
            Constructor<?> constructor = class1.getDeclaredConstructor(String.class);//获取指定声明构造函数
            Constructor publicConstructor = class1.getConstructor(String.class);//获取指定声明的public构造函数
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5.获取方法属性
        Annotation[] annotations = (Annotation[]) class1.getAnnotations();//获取class对象的所有注解
        Annotation annotation = (Annotation) class1.getAnnotation(Deprecated.class);//获取class对象指定注解
        Type genericSuperclass = class1.getGenericSuperclass();//获取class对象的直接超类的 Type
        Type[] interfaceTypes = class1.getGenericInterfaces();//获取class对象的所有接口的type集合
        //6.获取对象信息案例
        demo();
    }

    private void demo(){
        try {
            Class c1 = Class.forName("com.example.java.fanshe.fanshe_objectinfo.Student");
            //获取包信息
            Package p = c1.getPackage();
            Log.d("demo","p:"+p.getName());

            //获取类的访问修饰符
            int modifier = c1.getModifiers();
            Log.d("demo","类访问修饰符：" + Modifier.toString(modifier));

            //获取构造函数信息
            Constructor [] constructors = c1.getDeclaredConstructors();
            for(Constructor constructor:constructors){
                Log.d("demo","访问修饰符：" + Modifier.toString(constructor.getModifiers()));
                Log.d("demo","构造函数名：" + constructor.getName());
            }

            //取得声明的数据成员
            Field[] fields = c1.getDeclaredFields();
            for(Field field:fields){
                Log.d("demo","访问修饰符：" + Modifier.toString(field.getModifiers()));
                Log.d("demo","类型：" + field.getType().getName());
                Log.d("demo","成员名：" + field.getName());
            }

            //取得成员方法
            Method[] methods = c1.getDeclaredMethods();
            for(Method method:methods){
                System.out.print("访问修饰符：" + Modifier.toString(method.getModifiers()));
                System.out.print("   返回值类型："+method.getReturnType().getName());
                System.out.print("   方法名："+method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
