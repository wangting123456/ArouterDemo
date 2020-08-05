package com.example.java.reference;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_reference);
        image = (ImageView) findViewById(R.id.image);
        //1.强引用
         //a.直接new出来的对象
         String str = new String("123");
         //b.强引用介绍：垃圾回收器绝对不会回收它，宁愿抛出OutOfMemberyError使程序终止
         //c.强引用特点:可能导致内存泄漏



        //2.软引用
         //a.SoftReference 当内存不足时，垃圾回收器会指向它指向的对象。用get()方法获取对象
         //b.软引用应用场景: 从网络上获取到图片，然后将获取的图片要显示的同时，通过软引用缓存起来
         //                  当下去再从网络上获取图片时，可以先判断缓存里面是否存在，若存在，就引用缓存里面的
         //c.软引用的简单实用:
             Student student = new Student();
             SoftReference softReference = new SoftReference(student);
             Student stu = (Student)softReference.get();
         //d.软引用的特点
             //d1:特点:
              /*软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被垃圾回收，
                 Java虚拟机就会把这个软引用加入到与之关联的引用队列中。*/
              ReferenceQueue queue = new ReferenceQueue();
              Student student1 = new Student();
              SoftReference softReference1 = new SoftReference(student1,queue);
             //d2:如何回收
              /*那么当这个SoftReference所软引用的aMyOhject被垃圾收集器回收的同时，ref所强引用的SoftReference对象被列入ReferenceQueue。
               也就是说，ReferenceQueue中保存的对象是Reference对象，而且是已经失去了它所软引用的对象的Reference对象。
               另外从ReferenceQueue这个名字也可以看出，它是一个队列，当我们调用它的poll()方法的时候，如果这个队列中不是空队列,
               那么将返回队列前面的那个Reference对象。在任何时候，我们都可以调用ReferenceQueue的poll()方法来检查是否有它所关心
              的非强可及对象被回收。如果队列为空，将返回一个null,否则该方法返回队列中前面的一个Reference对象。利用这个方法，
              我们可以检查哪个SoftReference所软引用的对象已经被回收。于是我们可以把这些失去所软引用的对象的SoftReference对象清除掉。*/
              SoftReference ref = null;
              while ((ref = (SoftReference)queue.poll()) != null){
                  //清除ref
                  ref = null;
              }
          //e.实际应用案例
             Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_foreground);
             Drawable drawable = new BitmapDrawable(bitmap);
             SoftReference<Drawable> soft = new SoftReference<Drawable>(drawable);
             //在垃圾回收器对这个Java对象回收前，SoftReference类所提供的get方法会返回Java对象的强引用，
            // 一旦垃圾线程回收该Java对象之后，get方法将返回null。
             if(soft != null){
                 image.setBackground(soft.get());
             }


      //弱引用
        //a.防止内存泄漏
        //b.造成内存泄漏根本原因
          /*Activity在被结束之后，MessageQueue并不会随之被结束，如果这个消息队列中存在msg，则导致持有handler的引用，但是又由于Activity被结束了，msg无法被处理，从而导致永久持有handler对象，handler永久持有Activity对象，于是发生内存泄漏。但是为什么为static类型就会解决这个问题呢？因为在java中所有非静态的对象都会持有当前类的强引用，而静态对象则只会持有当前类的弱引用。声明为静态后，handler将会持有一个Activity的弱引用，而弱引用会很容易被gc回收，
           这样就能解决Activity结束后，gc却无法回收的情况。
          */
        //c.若引用解决办法
        MyHandler mHandler = new MyHandler(MainActivity.this);

    }

    private class MyHandler extends Handler{
        private WeakReference<MainActivity> weak;
        public MyHandler(MainActivity activity){
            weak = new WeakReference<MainActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
              MainActivity activity =  weak.get();
              if(activity != null){
                  //处理数据
              }
        }
    }
}
