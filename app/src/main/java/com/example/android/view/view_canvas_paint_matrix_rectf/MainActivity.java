package com.example.android.view.view_canvas_paint_matrix_rectf;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_view_paint_main);
        //1.Paint 画笔介绍：
            //Paint 即画笔，在绘制中起了很重要的作用，主要保存颜色，绘制等信息，指定如何绘制文本和图像
           //a.图形绘制
                //setARGB(int a,int r,int g,int b);设置绘制的颜色，a代表透明度，r，g，b代表颜色值。
                //setAlpha(int a); 设置绘制图形的透明度。
                //setColor(int color);设置绘制的颜色，使用颜色值来表示，该颜色值包括透明度和RGB颜色
                //setAntiAlias(boolean aa);设置是否使用抗锯齿功能，会消耗较大资源，绘制图形速度会变慢。
                //setStyle(Paint.Style style);设置画笔的样式，为FILL，FILL_AND_STROKE，或STROKE

        //b.文本绘制
               //* setTextSize(float textSize);设置绘制文字的字号大小

        //2.Canvas 画布介绍
           //当我们调整好画笔之后，现在需要绘制到画布上，在Android中把Canvas当作画布，那么就可以在画布上
           //绘制我们喜欢的任何东西，还需要绘制画布的一些属性，比如画布的颜色，尺寸等等
           //a.一般属性
               //drawColor(int color): 设置Canvas的背景颜色。
               //translate(float x, float  y): 平移画布
               //skew(float sx, float sy):  设置偏移量。
               //save(): 将Canvas当前状态保存在堆栈，save之后可以调用Canvas的平移、旋转、错切、剪裁等操作。
          //b.画图
               //canvas.drawPaint(Paint paint)
               //将画笔设置的颜色和透明度铺满画布
               //drawRect(Rect rect,Paint paint)//绘制矩形，参数是 Rect的区域
               //dracRect(float left,float top,float rigt,float bottom ,Paint paint)

               //drawRoundRect(RectF rect, float rx, float ry, Paint paint)绘制圆角矩形， rx:x方向的圆角半径，ry:y方向的圆角半径
               //drawRoundRect(float left,float top,float rigt,float bottom,float rx, float ry, Paint paint)

               //drawPath(Path path,Paint paint)绘制一个路径，参数一为Path路径对象

               //drawBitmap(Bitmap bitmap,Rect src,Rect dest,Point point)贴图
                 //参数一就是我们常规的Bitmap对象，参数二是源区域(这里是bitmap)，参数三是目标区域(应该在canvas的位置和大小)，参数四是Paint画刷对象，因为用到了缩放和拉伸的可能，当原始Rect不等于目标Rect时性能将会有大幅损失。
               //drawBitmap (Bitmap bitmap, float left, float top, Paint paint)

               //drawLine(float startX,float startY,float endX,float endY,Paint paint)画线

               //drawPoint(float x,float y,Paint paint) 画点

               //drawText(String text,float x,float y,Paint paint)渲染文本
                 //canvas类除了上面的还可以描绘文字，参数一是String类型的文本，参数二文字左侧到x轴距离，参数三文字BaseLine到y轴距离，参数四是Paint对象。

               //drawOval(Rect rect,Paint paint)画椭圆 参数一是扫描区域，参数二为paint对象
               //drawOval(float left, float top, float right, float bottom, Paint paint）

               //drawCircle(float x.float y,float radius,Paint paint)绘制圆，参数一是中心点的x轴，参数二是中心点的y轴，参数三是半径，参数四是paint对象；

               //drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
                 //画弧，参数一是RectF对象，指定圆弧的外轮廓矩形区域，参数二是起始角(度)在电弧的开始，参数三扫描角(度)开始顺时针测量的，参数四是如果这是真的话,包括椭圆中心的电弧,并关闭它,如果它是假这将是一个弧线,参数五是Paint对象；

        //c.Canvas对象的获取方式
             //a.重写OnDraw(Canvas canvas)
             //b. Canvas canvas = new Canvas();
        //d.Canvas的作用
             //Canvas可以绘制的对象有：弧线(arcs)、填充颜色(argb和color)、Bitmap、圆(circle和oval)、点(point)、线(line)、矩形(Rect)、图片(Picture)、圆角矩形(RoundRect)、文本(text)、顶点(Vertices)、路径(path)。


      //3.Matrix变换矩阵介绍(Canvas位置转换)
          //说明：如果要画一个仪表盘
          //Android提供了对Canvas位置转换的方法，rorate、scale、translate、skew(扭曲)。就像虽然你的笔还是你的笔
          //但是画纸移动/旋转了，所以你画的东西的方位就变化了。Canvas还提供了保存和回滚属性的方法(save和restore)
          //比如你可以先保存目前画纸的位置(save)，然后旋转90度，向下移动100像素后画一些图形，画完后调用restore方法返回到刚才保存的位置。

          //a.translate平移
          //b.rotate旋转
          //c.scale缩放
          //d.skew扭曲

       //4.RectF介绍
         //a.Rect简单属性
            //public int left,top,right,bottom;
         //b.Rect常用的一些属性
          /* public final int width() {
                return right - left;
           }
           public final int height() {
                return bottom - top;
            }*/

        //5.关于使用到这个几个属性的自定义View
           //a.DotView
     }
}
