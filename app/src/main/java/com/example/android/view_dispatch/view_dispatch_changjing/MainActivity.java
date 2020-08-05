package com.example.android.view_dispatch.view_dispatch_changjing;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityA :ViewGroupB:ViewC  ViewC有了点击事件
        //事件传递情况
        //a.默认情况：
            //不对控件里面的三个方法dispatchTouchEvent()、onTouchEvent()、onInterceptTouchEvent()进行重写/或者修改返回值
            //事件传递情况:从Activity A---->ViewGroup B--->View C，从上往下调用dispatchTouchEvent()
                          //再由View C--->ViewGroup B --->Activity A，从下往上调用onTouchEvent()
            //虽然ViewGroup B 的onInterceptTouchEvent方法对DOWN事件返回了false，但是后续的MOVE UP 等事件还是会走onInterceptTouchEvent
        //b.处理事件
           //如果ViewC希望处理这个事件，即C被设置成可点击的，或者重写其onTouchEvent()返回true
             //最常见的是设置button按钮来响应事件
          //因为DOWN事件被传递给ViewC的onTouchEvent方法，并返回true，表示处理了这个事件
          //所以DOWN事件不会再往上上传给B和A的onTouchEvent()
          //该事件的其他事件MOVE UP也会被传递给C的onTouchEvent()
        //拦截DOWN事件
           //假设ViewGroupB 想处理这个事件，B会重写onInterceptTouchEvent()返回true，onTouchEvent返回true
           //DOWN事件被传递给B的onInterceptTouchEvent()方法，该方法返回true，表示拦截这个事件，即自己处理这个事件（不再往下传递）
           //DOWN事件不会再调用A的onTouchEvent事件
           //该事件的MOVE UP事件也是直接传递给B的onTouchEvent事件。 onInterceptTouchEvent只要返回过一次true，就不会再调用
        //拦截DOWN的后续事件
           //假设ViewGroup B没有拦截DOWN事件（还是View C来处理DOWN事件），但它拦截了接下来的MOVE事件。
           //DOWN事件传递到C的onTouchEvent方法，返回了true。
           //在后续到来的MOVE事件，B的onInterceptTouchEvent方法返回true拦截该MOVE事件，但该事件并没有传递给B；这个MOVE事件将会被系统变成一个CANCEL事件传递给C的onTouchEvent方法
           //后续又来了一个MOVE事件，该MOVE事件才会直接传递给B的onTouchEvent()
           //后续事件将直接传递给B的onTouchEvent()处理
           //后续事件将不会再传递给B的onInterceptTouchEvent方法，该方法一旦返回一次true，就再也不会被调用了。
           //C再也不会收到该事件列产生的后续事件。

    }
}
