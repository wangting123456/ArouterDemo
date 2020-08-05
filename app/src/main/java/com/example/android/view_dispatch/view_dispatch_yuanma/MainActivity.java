package com.example.android.view_dispatch.view_dispatch_yuanma;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends Activity {
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dispatch_yuanma);
        LinearLayout line = (LinearLayout) findViewById(R.id.line);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        //1.Android中事件分发顺序
           //Activity ->ViewGroup ->View
           //super 调用父类的方法
           //返回true:消费事件，事件不继续向下传递
           //返回false:不消费事件，事件继续向下传递/交给父控件onTouchEvent处理
        //充分理解Android的分发机制：
          //Activity的分发机制
          //ViewGroup的分发机制
          //View的分发机制

        //2.Activity的事件分发机制
           //源码分析：当一个点击事件发生时，事件最先传到Activity的dispatchTouchEvent事件进行分发

        //3.ViewGroup的事件分发机制
           //当点击Button1的点击事件时，执行onclick,但是ViewGroup的onTouchEvent事件不会再执行
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"button1 onClick");
            }
        });
        line.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG,"line onTouch");
                return true;
            }
        });

        //第一条：当点击Button1的事件时，事件从Activity 分发到ViewGroup,再到View Button,Button自己处理了事件。事件不会再向上级传递
        //第二条：当触摸line时，事件从从Activity 分发到ViewGroup，ViewGroup自己处理了事件
        //结论：Android 事件分发先由Activity传到ViewGroup，再由ViewGroup传到View,
                //在ViewGroup中通过onInterceptTouchEvent对事件传递进行拦截
                //onInterceptTouchEvent返回true，代表拦截事件，不允许事件向子View传递
                //onInterceptTouchEvent返回false，代表不拦截事件，允许向子View传递（默认返回false）
                //子View中如果将传递的事件处理掉（消费掉），事件不会再向View的上层传递



        //4.View事件的分发机制
           //View 中的ondispatchTouchEvent() 源码分析
       /* public boolean dispatchTouchEvent(MotionEvent event) {
              //设置了OnTouchListener监听    //控件enable(默认enable)      //onTouch()方法返回true
            if (mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED &&
                    mOnTouchListener.onTouch(this, event)) {
                return true;
            }
            return onTouchEvent(event);
        }*/
       //三个条件全部成立。dispatchTouchEvent 分发事件返回true。事件分发完毕，并setOnTouchListener 去处理事件。事件结束
        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        //设置了OnTouchListener监听，控件enable true ，onTouch()返回false。 会走View的onTouchEvent事件的回掉
        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

      /*  @Override
        public boolean onTouchEvent(MotionEvent event) {
            return super.onTouchEvent(event);
        }
         //分析onTouchEvent源码发现。里面有执行onclick()事件
        */

      //结论: 如果onTouch()返回false；就会执行Button 的onTouchEvent ->Button.setOnclick()方法
              // 如果onTouch()返回true；就不会执行Button 的onTouchEvent ->不会执行Button.setOnclick()方法




    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //里面调用的是ViewGroup.dispatchTouchEvent,这样就把事件分发到了ViewGroup
        return super.dispatchTouchEvent(ev);
    }
}
