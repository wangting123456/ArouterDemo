package com.example.android.recycleview.recycleview_itemtouchhelper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.yczbj.ycrefreshviewlib.utils.RefreshLogUtils;

public class RecycleViewItemLine extends RecyclerView.ItemDecoration {
    private Context context;
    /**
     * 列表的方向：LinearLayoutManager.VERTICAL或LinearLayoutManager.HORIZONTAL
     */
    private int orientation;
    private Drawable mDivider;
    private int mDividerHeight;
    private static int[] ATTRS = new  int[]{android.R.attr.listDivider};
    private Paint mPaint;


    /**
     * 自定义分割线
     * @param context 上下文
     * @param orientation 列表方向
     */
   public RecycleViewItemLine(Context context,int  orientation){
       if(orientation != LinearLayoutManager.VERTICAL || orientation != LinearLayoutManager.HORIZONTAL){
           throw new IllegalArgumentException("请输入正确的参数！");
       }
       this.context = context;
       this.orientation = orientation;
       TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
       mDivider = typedArray.getDrawable(0);
       typedArray.recycle();
   }

    /**
     * 自定义分割线
     * @param context 上下文
     * @param orientation 列表方向
     * @param drawableId 分割线图片
     */
   public RecycleViewItemLine(Context context,int  orientation,int drawableId){
       this(context,orientation);
       mDivider = ContextCompat.getDrawable(context,drawableId);
       if(mDivider != null){
           mDividerHeight = mDivider.getIntrinsicHeight();
       }
   }

    /**
     自定义分割线
     * @param context 上下文
     * @param orientation 列表方向
     * @param dividerHeight 分割线高度
     * @param dividerColor 分割线颜色
     */
   public RecycleViewItemLine(Context context,int orientation,int dividerHeight, int dividerColor){
       this(context, orientation);
       mDividerHeight = dividerHeight;
       mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
       mPaint.setColor(dividerColor);
       mPaint.setStyle(Paint.Style.FILL);
   }

    /**
     * 调用的是getItemOffsets会被多次调用，在layoutManager每次测量可摆放的view的时候回调用一次，
     * @param outRect 核心参数，这个rect相当于item摆放的时候设置的margin，
     *                                        rect的left相当于item的marginLeft，
     *                                        rect的right相当于item的marginRight
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //给bottom留出一个高度为mDividerHeight的空白
        //这样做的目的是什么呢？就是为下面onDraw方法绘制高度为mDividerHeight的分割线做准备用的
        //set方法作用：将矩形的坐标设置为指定的值
        outRect.set(0,0,0,mDividerHeight);
        Log.d("RecycleViewItemLine","getItemOffsets");
    }

    /**
     * 绘制分割线
     * ItemDecoration的onDraw方法是在RecyclerView的onDraw方法中调用的
     * 注意这时候传入的canvas是RecyclerView的canvas，要时刻注意这点，它是和RecyclerView的边界是一致的。
     *      这个时候绘制的内容相当于背景，会被item覆盖。
     * @param c 用来绘制的画板
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if(orientation == LinearLayoutManager.VERTICAL){
            drawVertical(c,parent);
        }else {
            drawHoritontal(c,parent);
        }
        Log.d("RecycleViewItemLine","onDraw");
    }
    private void drawVertical(Canvas canvas,RecyclerView recyclerView){

    }
    private void drawHoritontal(Canvas canvas,RecyclerView parent){
        final int left = parent.getPaddingLeft();
        final int right = parent.getMeasuredWidth() - parent.getPaddingRight();
        RefreshLogUtils.d("小杨逗比左右的间距分别是" + left + "----"+right);
        //获取的当前显示的view的数量，并不会获取不显示的view的数量。
        //假如recyclerView里共有30条数据，而当前屏幕内显示的只有5条，这paren.getChildCount的值是5，不是30。
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            //获取索引i处的控件view
            final View child = parent.getChildAt(i);
            //拿到layoutParams属性
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)
                    child.getLayoutParams();
            final int top = child.getBottom() + layoutParams.bottomMargin;
            final int bottom = top + mDividerHeight;
            if (mDivider != null) {
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(canvas);
            }
            //使用画笔paint进行绘制
            if (mPaint != null) {
                canvas.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }
}
