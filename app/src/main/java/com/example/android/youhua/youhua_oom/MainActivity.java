package com.example.android.youhua.youhua_oom;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.什么是内存泄漏
          //一些对象带着有限的生命周期，当这些对象，所要做的事情完成了，我们希望他们会被垃圾回收器回收掉。但是如果有一系列对象对
          //这个对象的引用存在，那么垃圾回收器是不会回收的。它还会占用内存，造成内存泄漏，持续累加，内存很快被耗尽。最终会导致内存耗尽
          //引发OOM，而让应用crash掉

        //2.内存泄漏造成什么影响
          //它是造成应用OOM的主要原因之一，由于android系统为每个应用程序分配的内存有限，当一个应用中产生的内存泄露比较多时，就难免会导致
          //应用所需要的内存超过这个系统分配的内存限额。

        //3.内存检测工具
          //Leakcanary

        //4.错误使用单例引起的内存泄漏
            //a.单例设计模式是开发中经常使用的设计模式，在开发中单例经常需要持有context对象，如果持有的context对象的生命周期
                //和单例生命周期更短，或导致context无法被释放，就会引起内存泄漏
            //b.如果此时传入的是Activity的生命周期，当这个context对用的Activity退出时，由于该context的引用被单例对象持有，其生命周期
                //等于整个应用程序的生命周期，所以当前Activity退出时，它的内存并不会被回收，导致内存泄漏
              LoginManager.getInstance(this).dealData();
            //这句话被调用后，关闭该Activity会引起内存泄漏，要保证context和application的生命周期一样
              LoginManager.getInstance(getApplicationContext()).dealData();
        //5.Handler使用不当引起的内存泄漏
            // HandlerActivity 和 HandlerActivity2

        //6.Thread未关闭引起内存泄漏
            //设立个boolean 销毁Activity时 调整变量
            //将线程改为静态内部类，切断Activity 对于Thread的强引用
            //在线程内部采用弱引用保存Context引用，切断Thread对于Activity 的强引用
            //ThreadActivity 和 ThreadActivity2

        //7.错误使用静态变量导致引用后无法销毁
            //平时开发中，我们会创建工具类，比如分享工具类，十分方便多处调用，因此使用静态方法是十分方便的。
            //但是创建的对象，建议不要全局化，这样很容易引起内存泄漏。
            //InnerActivity

        //8.AsyncTask造成的内存泄漏

        //9.非静态内部类创建静态实例造成内存泄漏

        //10.不需要用的监听未移除会发生内存泄露

        //11.资源未关闭造成的内存泄漏
         /* BroadcastReceiver，ContentObserver，FileObserver，Cursor，Callback等在 Activity onDestroy
          或者某类生命周期结束之后一定要 unregister 或者 close 掉，否则这个 Activity 类会被 system 强引用，
          不会被内存回收。值得注意的是，关闭的语句必须在finally中进行关闭，否则有可能因为异常未关闭资源，致使activity泄漏。*/

        //12.广播注册之后没有被销毁

        //13.错误使用context上下文引起内存泄漏
             //ToastUtil
        //14.静态集合使用不当导致的内存泄漏
             //有时候需要把一些对象加入到容器中(ArrayList)，当不再需要当中某些对象时，如果不把该对象的引用从集合中清除掉，也会
             //使的GC无法回收该对象，如果集合石static类型的话，内存泄漏更严重，因此，当不再需要某对象时，应该主动从该集合中移除

        //15.动画资源未释放导致内存泄漏
           //AnimActivity
        //16.系统bug之InputMethodManager导致内存泄漏
       /*  每次从MainActivity退出程序时总会报InputMethodManager内存泄漏，原因系统中的InputMethodManager持有当前MainActivity的
           引用，导致了MainActivity不能被系统回收，从而导致了MainActivity的内存泄漏。查了很多资料，发现这是 Android SDK中输入法的一
           个Bug，在15<=API<=23中都存在，目前Google还没有解决这个Bug。*/

    }
}
