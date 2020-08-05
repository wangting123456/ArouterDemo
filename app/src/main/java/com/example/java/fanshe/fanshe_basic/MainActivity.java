package com.example.java.fanshe.fanshe_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 反射机制
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.Java反射机制原理
           //a.反射是为了动态的加载一个类，动态的调用一个方法，动态的访问一个属性等动态要求而设计的
             //它的出发点就在于JVM会为每个类创建一个Class实例，通过这个对象可以获取这个类的信息，然后使用
             //java.lang.reflect包下得API已达到各种动态需求
           //b.反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法，对于任意一个
             // 对象，都能够调用它的任意一个方法和属性，这种动态获取信息，以及动态调用对象的方法的功能称为反射机制
        //2.Java反射机制的功能
           //a.Java反射机制的功能有哪些：
              //1.在运行时判断任意一个对象所属的类。
              //2.在运行时构造任意一个类的对象。
              //3.在运行时判断任意一个类所具有的成员变量和方法。
              //4.在运行时调用任意一个对象的方法。
              //5.生成动态代理。
           //b.反射的组成
              //由于反射最终还是有类参与，因此反射的组成有以下：
                //java.lang.Class.java：类对象；
                //2.java.lang.reflect.Constructor.java：类的构造器对象；
                //3.java.lang.reflect.Method.java：类的方法对象；
                //4.java.lang.reflect.Field.java：类的属性对象；

         //3.Java反射的应用
           //a.Java反射的应用
             //1.逆向代码 ，例如反编译
             //2.与注解相结合的框架 例如Retrofit
             //3.单纯的反射机制应用框架 例如EventBus
             //4.动态生成类框架 例如Gson
          //b.反射的作用有哪些
            //1.自定义注解，注解就是在运行时利用反射机制来获取的
            //2.在开发中动态加载类，比如在Android中的动态加载解决65k问题等等，模块化和插件化都离不开反射，离开了反射寸步难行

          //c.反射的用途
            //反射被广泛地用于那些需要在运行时检测或修改程序行为的程序中

        //4.Class与.class文档
          //a.Java在真正需要某个类时才会去加载对应的.class文档，而非在程序启动时就加载所有类，因为大部分时
            //候我们只需要用到应用程序部分资源，有选择地加载可以节省系统资源
          //b.java.lang.Class 的实例代表 Java 应用程序运行时加载的 .class 文档，类、接口、Enum等编译
            //过后，都会生成 .class 文档，所以 Class可以用来包含类、接口、Enum等信息
          //c.Class 类没有公开的构造函数，实例是由 JVM 自动产生，每个 .class 文档加载时， JVM 会自动生成对应的 Class 对象
            demo();
          //d.Java 在真正需要类时才会加载.class文档，即在生成对象时才会加载.class文档。如果只是使用类
            //声明了一个变量，此时并不会加载.class文档，而只是让编译程序检查对应的 .class 文档是否存在。

        //5.反射之动态交互
          //动态加载，也就是在运行的时候才会加载，而不是在编译的时候，在需要的时候才进行加载获取.
        //6.使用反射的初衷
          //反射的初衷不是方便你去创建一个对象，而是在写代码的时候比较灵活，降低解耦
    }

    private void demo(){
        Class cl =  Student.class;
        System.out.println("类名称:"+cl.getName());
        System.out.println("简单类名称:"+cl.getSimpleName());
        System.out.println("包名:"+cl.getPackage());
        System.out.println("是否为接口:"+cl.isInterface());
        System.out.println("是否为基本类型:"+cl.isPrimitive());
        System.out.println("是否为数组对象:"+cl.isArray());
        System.out.println("父类名称:"+cl.getSuperclass().getName());
    }
}
