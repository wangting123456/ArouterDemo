package com.example.android.view.view_custom;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_view_custom);
        //自定义控件步骤
          //1、创建View
          //2、处理View的布局
          //3、绘制View
          //4、与用户进行交互
          //5、优化已定义的View

        //一.创建View
          //继承View
            //a.Android为我们创建的很多View都是继承自View的
            //b.所以我们自定义的View当然也是继承于View,然如果你要自定义的View拥有某些android已经提供的控件的功
               // 能，你可以直接继承于已经提供的控件
            //c.在使用Android提供的控件的时候，我们在.xml文件中编辑了一个控件，在运行的时候就能看到和获取这个控件。
               //我们自定义的控件当然也要支持配置和一些自定义属性，所以下面的构造方法就必须有了
               //这个构造方法允许我们在.xml文件中创建和编辑我们自定义控件的实例

          //1.重写构造方法
          //2.定义自定义属性
             //a.大部分情况我们的自定义View需要有更多的灵活性
             //b.比如我们在xml中指定了颜色大小等属性，在程序运行时候控件就能展示出相应的颜色和大小
             //c.自定义属性通常写在在res/values/attrs.xml文件中 下面是自定义属性的标准写法
             //d.使用自定义属性的时候需要指定命名空间，
                  //固定写法http://schemas.android.com/apk/res/你的包名
                  //如果在android studio 中http://schemas.android.com/apk/res/res-auto
          //3.获取自定义属性
             //a.在xml中设置了控件自定义属性，我们就需要拿到属性做一些事情。否则定义自定义属性就没有意义了
             //b.当我们在xml中创建一个View时，所有在xml中声明的属性，都会被传入到View的构造方法的AttributeSet中
             //c.通过调用Context的obtainStyledAttributes()方法返回一个TypedArray对象。然后直接用TypedArray对象获取自定义属性的值。
             //d.由于TypedArray对象是共享的资源，所以在获取完值之后必须要调用recycle()方法来回收。

          //4.添加设置属性事件

        //二.测量View
          //测量
             //一个View是在展示时总是有它的宽和高，测量View就是为了能够让自定义的控件能够根据各种不同的
             // 情况以合适的宽高去展示。提到测量就必须要提到onMeasure方法了。onMeasure方法是一个view确定它的宽高的地方。

          //1.widthMeasureSpec参数
            //a.onMeasure方法里有两个重要的参数，widthMeasureSpec，heightMeasureSpec。
               //在这里你只需要记住它们包含了两个信息:mode和size
            //b.可以通过以下代码拿到mode和size
              //int specMode = MeasureSpec.getMode(measureSpec);
              //int specSize = MeasureSpec.getSize(measureSpec);
            //c.那么获取到的mode和size又代表了什么
              //mode：代码我们当前控件的父控件告诉我们控件，你应该按怎样的方式来布局
                 //EXACTLY：父控件告诉子控件一个固定的大小，你就按照这个大小来布局，比如确定大小dp和MathParent
                 //AT_MOST:当前控件不能超过一个固定的最大值，指wrap_content
                 //UNSPECIFIED:当前控件没有限制，要多大就有多大，这种情况很少出现。
              //size其实就是父布局传递过来的一个大小，父布局希望当前布局的大小。

          //2.重写onMeasure()

        //三.绘制View(Draw)
          //1.一旦自定义控件被创建并且测量代码写好之后，接下来你就可以实现onDraw()来绘制View
             //a.Canvas决定要去画什么;Paint决定怎么画
             //b.比如，Canvas提供了画线方法，Paint就来决定线的颜色。Canvas提供了画矩形，Paint又可
               // 以决定让矩形是空心还是实心。
         //2.在onDraw方法中开始绘制之前,你应该让画笔Paint对象的信息初始化完毕。


        //四.与用户进行交互
          //1.也许某些情况你的自定义控件不仅仅只是展示一个漂亮的内容，还需要支持用户点击，拖动。这时候自定义控件就需要做用户交互这一步骤了。
          //2.在Android系统中最常见的事件就是触摸事件了，它会调用view的onTouchEvent(android.view.MotionEvent).重写这个方法去处理我们的事件逻辑。

    }
}
