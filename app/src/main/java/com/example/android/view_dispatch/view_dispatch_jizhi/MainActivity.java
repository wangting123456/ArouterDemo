package com.example.android.view_dispatch.view_dispatch_jizhi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.事件机制代码解释说明
        /**触摸事件
         *如果返回结果为false,表示不消费该事件，并且也不会截获接下来的事件序列，事件会继续传递
         * 如果返回结果为true，表示消费该事件，阻止事件继续传递
         */
       /*  @Override
        public boolean onTouchEvent(MotionEvent event) {
            Log.e("onEvent","MyLinearLayout onTouchEvent");
            return super.onTouchEvent(event);
        }*/

        /**分发事件
         *根据内部拦截状态，向child或者自己分发事件
         */
      /*  @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            Log.e("onEvent","MyLinearLayout dispatchTouchEvent");
            return super.dispatchTouchEvent(ev);
        }*/

        /**拦截事件
         *
         * 默认实现是返回false，也就是默认不拦截任何事件
         * 判断自己是否需要拦截
         * 如果返回true，那么view将消费事件，会调用onTouchEvent()事件
         * 如果返回false，会通过调用子View的dispatchTouchEvent将事件交由子View来处理
         */
      /*  @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            Log.e("onEvent","MyLinearLayout onInterceptTouchEvent");
            return super.onInterceptTouchEvent(ev);
        }*/
       //2.三个事件机制怎么向其调用者传递处理结果
       //3.触摸事件类型
          //ACTION_DOWN:用户手指的按下操作，一次按下事件的操作标志一次触发事件的开始
          //ACTION_UP:用户手指的抬起操作，一次抬起操作标志着一次触发事件的结束
          //ACTION_MOVE:用户手指按压屏幕后，在松开之前，如果距离超过一定得阈值，那么会被判定为ACTION_MOVE。一般情况下，
                        // 手指的轻微移动都会触发一系列的移动事件。
          //通过MotionEvent可以获得事件发生的x和y坐标，getX和getY返回的是相当于当前View左上角的X和Y坐标，getRawX和getRawY返回的是相当于手机屏幕左上角的X和Y坐标
          //其他：Touch触摸事件：在Android中Touch触摸事件主要包括：
                                //点击（onClick） 长按（onLongClick） 拖拽（onDrag）  滑动（onScroll）
                                //在Android中Touch操作状态主要包括：
                                //按下（ACTION_DOWN）抬起（ACTION_UP） 移动（ACTION_MOVE） 取消手势(ACTION_CANCEL) 划出屏幕(ACTION_OUTSIDE)
      //4.Android触摸事件流程总结：
         //一个事件序列从手指触摸屏幕开始，到触摸结束。同一事件序列是以ACTION_DOWN开始，中间有数不定的ACTION_MOVE，最终以ACTION_UP结束
         //事件传递顺序：Activity->ViewGroup->View 顶级View接收到事件后，会按照事件分发顺序去分发事件。
         //事件传递过程是由外向内的，即事件总是有父元素分发给子元素

      //5.三个重要方法的分布
         //1. View
          //分发事件 dispatchTouchEvent
          //处理事件 onTouchEvent
        //2 ViewGroup
          //分发事件 dispatchTouchEvent
          //拦截事件 onInterceptTouchEvent
          //处理事件 onTouchEvent
        //3 Activity
          //分发事件 dispatchTouchEvent
          //处理事件 onTouchEvent
     //6.滑动冲突的思路和解决办法
       //a.滑动方向不同
          // ScrollView里嵌套ViewPager
        //b.滑动方向相同
          // ViewPager嵌套ViewPager
          //ScrollView嵌套RecyclerView或者GridView
        //c.以上两种情况嵌套
          //比如scrollview嵌套recyclerview，recyclerView复杂条目中又有横向滑动的list
      //7.滑动冲突解决办法
         //a.滑动方向不同，以ScrollView里嵌套ViewPager
         //  a_1:以父View着手，onInterceptTouchEvent  MyScrollView
         //  a_2:内部解决法,从从子View着手，父View 先不要拦截任何事件，所有的 事件传递给子View，如果子View需要此事件就消费掉，
              //  不需要此事件的话就交给 父View 处理。 MyViewPager
    }
}
