package com.example.android.view.view_basic.view_extendskongjian;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

@SuppressLint("AppCompatCustomView")
public class UnderLineTextView extends TextView {
    private Paint paint = new Paint();
    public UnderLineTextView(Context context) {
        super(context);
    }

    public UnderLineTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);//设置空心
        paint.setStrokeWidth(10);//设置空心线宽
        int width = getWidth();
        int height = getBaseline();
        canvas.drawLine(0,height,width,height,paint);
    }
}
