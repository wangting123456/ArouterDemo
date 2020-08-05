package com.example.android.annotation.annotation_basic;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
    private TextView tvShow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.Annotation的简单介绍
           //a.包含一系列有用元注解，帮助开发者在编译期间可能存在的bug
           //b.是属于SupportLib之一，独立的jar包
           //c.通过注释来完善代码质量
        //2.库的特点
           //依赖注入(Dependency injection)，支持view, extras, system service, resource
           //简单的线程模型：进行方法注解，让该方法在UI线程或者后台线程执行
           //事件绑定:进行方法注解，让方法执行view的时间而不用再去写一些监听

        //3.@Nullable  @NonNull
          //a.说明：检测参数/方法返回值是否为空，使用这个两个注解后，如果出现代码不安全的情况下，会给出智能提示
                   //@Nullable作用于函数参数或者返回值，标记参数或者返回值可以为空
                   //@NonNull作用于函数参数或者返回值，标记参数或者返回值不可以为空


          //b.使用：showName(null);

        //4.资源注释类型
           //a.说明：在开发过程中会引用一些资源，比如字符串资源，图片资源，颜色资源等等，因为都是int类型
                     //有可能我们在给TextView设置字符串资源的时候改成了图片资源
           //b.资源类型注解：
                //@StringRes：表示参数、变量或者函数返回值应该是一个字符串类型的资源
                //@ColorInt : 表示参数、变量或者函数返回值应该是一个颜色值而不是颜色资源引用，
                             // 例如应该是一个 AARRGGBB 的整数值。
                //@ColorRes : 表示参数、变量或者函数返回值应该是一个 color 类型的资源，而不是颜色值。注意和 ColorInt 区别
                //@AnimRes : 表示参数、变量或者函数返回值应该是一个 Anim 类型的资源
                //@DrawableRes : 表示参数、变量或者函数返回值应该是一个 drawable 类型的资源
                //@DimenRes : 表示参数、变量或者函数返回值应该是一个 dimension 类型的资源
            //c.使用：
               //showStringRes(R.drawable.ic_launcher_foreground);
               //showStringRes(R.string.app_name);

         //5.线程注解
            //a.说明：线程注解主要用于检测一个函数是否在指定类型的线程中执行
            //b.类型注解：
                //@UiThread：标记运行在UI线程
                //@MainThread：标记运行在主线程
                //@WorkerThread：标记运行在后台运行线程。
                //@BinderThread：标记运行在Binder线程
            //c.使用
               threadTest();

        //6.值范围注释
           //类型说明
             //a.@IntRange：参数类型是int或者long，用法如下
                 //public void setInt(@intRange(from=0,to=255)){...}
             //b.FloatRange：参数类型是float或者double，用法如下
                //public void setFloat(@FloatRange(from=0.0,to=1.0)){...}
             //c.@Size：对于类似数组、集合和字符串之类的参数，我们可以使用@Size注解来表示这些参数的大小。
                 //@Size(min=1)//可以表示集合不可以为空
                 //@Size(max=23)//可以表示字符串最大字符个数为23
                 //@Size(2)//表示数组元素个数为2个
                 //@Size(multiple=2)//可以表示数组大小是2的倍数

         //7.权限注解：
           //说明：Android应该在使用某些系统功能时，需要在清单文件中声明权限，否在在运行时就会提示缺失对应的权限，
                   //为了在编译时及时发现权限的缺失，添加RequiresPermission
           //类型：
                 // a.如果添加一个权限：@RequiresPermission(Manifest.permission.SET_WALLPAPER)
                 // b.如果同时需要添加多个权限：@RequiresPermission(allOf = {Manifest.permission.SET_WALLPAPER,Manifest.permission.CAMERA})

         //8.keep注解
           //@Keep：编码时标注出一些不需要混淆的类或者方法

         //9.@SuppressWarnings注解 Suppress 镇压的意思
            //说明：就是对一些警告信息的过滤
            //类型
               // a. @SuppressWarnings("unchecked")
                  //告诉编译器忽略 unchecked 警告信息，如使用List，ArrayList等未进行参数化产生的警告信息。
               //b. @SuppressWarnings("serial")
                  //如果编译器出现这样的警告信息：使用这个注释将警告信息去掉。
               //c. @SuppressWarnings("deprecation")
                  //如果使用了使用@Deprecated注释的方法，编译器将出现警告信息。使用这个注释将警告信息去掉。
              //d. @SuppressWarnings("unchecked", "deprecation")
                  //告诉编译器同时忽略unchecked和deprecation的警告信息。
               //e.@SuppressWarnings(value={"unchecked", "deprecation"})
                  //等同于@SuppressWarnings("unchecked", "deprecation")


    }

    private void showName(@NonNull String name){
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }
    private void showName2(@Nullable String name){
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }

    private void showStringRes(@StringRes int id){
        Toast.makeText(this,getString(id),Toast.LENGTH_SHORT).show();
    }

    private void threadTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                testShow();
            }
        }).start();
    }

    /**
     * 那么上面会报错。提示：不做线程切换，只起到提示作用！
     */
    @UiThread
    public void testShow(){
        tvShow.setText("测试");
    }
}
