package com.example.android.view.view_canvas_paint_matrix_rectf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class MyCanvas extends View {
    private Paint paint = new Paint();

    public MyCanvas(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.绘制圆
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawCircle(200,200,100,paint);
        //2.绘制矩形，圆角矩形
        canvas.drawRect(100, 100, 200, 200,paint);
        canvas.drawRoundRect(100, 100, 200, 200,30,30,paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawRect(100, 100, 200, 200,paint);
        //3.绘制文字
        paint.setTextSize(100);
        canvas.drawText("你好2020",100,100,paint);
        //4.绘制弧形，封闭弧形
        RectF rel = new RectF(50, 50, 150, 150);
        canvas.drawArc(rel,0,135,false,paint);
        canvas.drawArc(rel,0,135,true,paint);
        //5.Canvas绘制Path路径
        Path path = new Path();
        path.moveTo(0,250);
        path.lineTo(250,0);
        path.lineTo(250,250);
        path.close();
        canvas.drawPath(path,paint);

        //Matrix
        // Rotate旋转
        paint.setColor(Color.BLUE);
        canvas.drawRect(new Rect(0,0,800,800),paint);
        canvas.save();
        canvas.rotate(45,400,400);
        paint.setColor(Color.RED);
        canvas.drawRect(new Rect(0,0,800,800),paint);
        canvas.restore();
        //Scale缩放
        paint.setColor(Color.YELLOW);
        canvas.drawRect(new Rect(0,0,800,800),paint);
        canvas.save();
        canvas.scale(0.5f,0.5f);
        paint.setColor(Color.GREEN);
        canvas.drawRect(new Rect(0,0,800,800),paint);
        canvas.restore();

    }
}
