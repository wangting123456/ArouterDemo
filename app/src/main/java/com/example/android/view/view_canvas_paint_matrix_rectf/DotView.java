package com.example.android.view.view_canvas_paint_matrix_rectf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DotView extends View {
    private boolean isInit = false;
    private int mViewWidth = 0;
    private int mViewHeight = 0;
    private int radius = 0;
    private int mBgUnselectedColor = Color.parseColor("#1A000000");
    private int mBgSelectedColor = Color.parseColor("#FDE26E");
    private Paint paint = new Paint();
    private static final float mArcWidth = 2.0f;
    private boolean isSelected = false;

    public DotView(Context context) {
        super(context);
    }

    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!isInit){
            isInit = true;
            mViewWidth = getWidth();
            mViewHeight = getHeight();
            if(mViewHeight > mViewWidth){
                radius = mViewWidth/2;
            }else {
                radius = mViewHeight/2;
            }
        }
        //是否选中
        if (isSelected){
            drawSelectDot(canvas);
        } else{
            drawUnSelectDot(canvas);
        }
    }

    private void drawSelectDot(Canvas canvas){
        //设置画笔
        paint.setAntiAlias(true);
        paint.setColor(mBgSelectedColor);
        paint.setStyle(Paint.Style.FILL);

        //绘制圆
        canvas.drawCircle(mViewWidth/2,mViewHeight/2,radius,paint);

        //绘制指定的弧线，该弧线将被缩放以适应指定的椭圆形。
        paint.setStyle(Paint.Style.STROKE);
        float offset = 1.f + mArcWidth;
        RectF oval = new RectF(mViewWidth / 2.f - radius + offset, mViewHeight / 2.f - radius + offset,
                mViewWidth / 2.f + radius - offset, mViewHeight / 2.f + radius - offset);

        //绘制指定的弧线，该弧线将被缩放以适应指定的椭圆形。
        canvas.drawArc(oval, 0.f, 360.f, false, paint);
    }
    private void drawUnSelectDot(Canvas canvas){
        paint.setAntiAlias(true);
        paint.setColor(mBgUnselectedColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mViewWidth / 2.f, mViewHeight / 2.f, radius - 8.f, paint);
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
        //使整个视图无效。如果视图是可见的，则{@link#onDraw(android.Graphics.Canvas)}将在将来的某个时候被调用。
        //调用该方法，会进行重新绘制，也就是调用onDraw方法
        this.invalidate();
    }
}
