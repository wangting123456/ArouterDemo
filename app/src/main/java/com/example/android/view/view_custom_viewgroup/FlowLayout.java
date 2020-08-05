package com.example.android.view.view_custom_viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //先取出FlowLayout的父view 对FlowLayout 的测量限制 这一步很重要噢。
        //你只有知道自己的宽高 才能限制你子view的宽高
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        int usedWidth = 0;      //已使用的宽度
        int remaining = 0;      //剩余可用宽度
        int totalHeight = 0;    //总高度
        int lineHeight = 0;     //当前行高

        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            LayoutParams lp = childView.getLayoutParams();

            //先测量子view
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            //然后计算一下宽度里面 还有多少是可用的 也就是剩余可用宽度
            remaining = widthSize - usedWidth;

            //如果一行不够放了，也就是说这个子view测量的宽度 大于 这一行 剩下的宽度的时候 我们就要另外启一行了
            if (childView.getMeasuredWidth() > remaining) {
                //另外启动一行的时候，使用过的宽度 当然要设置为0
                usedWidth = 0;
                //另外启动一行了 我们的总高度也要加一下，不然高度就不对了
                totalHeight = totalHeight + lineHeight;
            }

            //已使用 width 进行 累加
            usedWidth = usedWidth + childView.getMeasuredWidth();
            //当前 view 的高度
            lineHeight = childView.getMeasuredHeight();
        }

        //如果FlowLayout 的高度 为wrap cotent的时候 才用我们叠加的高度，否则，我们当然用父view对如果FlowLayout 限制的高度
        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = totalHeight;
        }
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int childTop = 0;
        int childLeft = 0;
        int childRight = 0;
        int childBottom = 0;

        //已使用 width
        int usedWidth = 0;


        //customlayout 自己可使用的宽度
        int layoutWidth = getMeasuredWidth();
        Log.v("wuyue", "layoutWidth==" + layoutWidth);
        for (int j = 0; j < getChildCount(); j++) {
            View childView = getChildAt(j);
            //取得这个子view要求的宽度和高度
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();

            //如果宽度不够了 就另外启动一行
            if (layoutWidth - usedWidth < childWidth) {
                childLeft = 0;
                usedWidth = 0;
                childTop += childHeight;
                childRight = childWidth;
                childBottom = childTop + childHeight;
                childView.layout(0, childTop, childRight, childBottom);
                usedWidth = usedWidth + childWidth;
                childLeft = childWidth;
                continue;
            }
            childRight = childLeft + childWidth;
            childBottom = childTop + childHeight;
            childView.layout(childLeft, childTop, childRight, childBottom);
            childLeft = childLeft + childWidth;
            usedWidth = usedWidth + childWidth;

        }
    }
}
