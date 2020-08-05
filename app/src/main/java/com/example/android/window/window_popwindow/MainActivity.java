package com.example.android.window.window_popwindow;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.最简单的创造方法
           //a.PopWindow构造方法
           /*   public PopupWindow (Context context)
                public PopupWindow(View contentView)
                public PopupWindow(int width, int height)
                public PopupWindow(View contentView, int width, int height)
                public PopupWindow(View contentView, int width, int height, boolean focusable)*/
           //b.显示PopWindow
             //showAsDropDown(View view)相对某个控件的位置，无便宜
             //showAsDropDown(View anchor, int xoff, int yoff)：相对某个控件的位置，有偏移
             //showAtLocation(View parent, int gravity, int x, int y)：相对于父控件的位置
                //(例如正中央Gravity.CENTER，下方Gravity.BOTTOM等)，可以设置偏移或无偏移

        //c.最简单的创建
        createPopWindow();

        //4.注意宽和高的属性
            //popwindow必须设置宽和高，否则不显示任何东西，指的是popwindow的大小，也是setcontentView的大小
    }

    private void createPopWindow(){
        //创建对象
        PopupWindow popupWindow = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.android_view_popwindow,null);
        //设置View
        popupWindow.setContentView(view);
        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置动画的方式
        popupWindow.setAnimationStyle(R.style.BottomDialog);
        //设置焦点，设置true后，popwindow的内容区域，才可以响应事件
        popupWindow.setFocusable(true);
        //背景色透明
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //点击空白处的时候让popwindow消失
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(false);
        //设置dismiss事件
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        boolean isshowing = popupWindow.isShowing();
        if(!isshowing){
            popupWindow.showAsDropDown(view);
        }
    }
}
