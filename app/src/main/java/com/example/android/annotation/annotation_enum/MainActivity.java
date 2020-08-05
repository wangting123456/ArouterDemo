package com.example.android.annotation.annotation_enum;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.IntDef;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.先来看一个枚举案例
            //a.枚举使用的场景：适用于分组常量场景
            //b.使用枚举得出来的结论：
                 //枚举值是类对象， 且是静态常量(被static final修饰)。
                 //枚举的构造函数是私有的， 防止new出对象。
                 //枚举类是继承于java.lang.Enum的类。
        //2.枚举损耗性能
            //a.每一个枚举值都是一个对象,在使用它时会增加额外的内存消耗,所以枚举相比与 Integer 和 String 会占用更多的内存。
            //b.较多的使用 Enum 会增加 DEX 文件的大小,会造成运行时更多的开销,使我们的应用需要更多的空间。
            //c.如果你的应用使用很多的 Enum ,最好使用Integer 或 String 替代他们,但是这样还会有问题。
        //3.使用注解代替枚举
            int a = getInt(Numbers.ONE);
            String b = getString(Numbers.STR_TWO);

    }

    private enum SeasonEnum{
        SPRING,SUNNER,AUTUMN,WINTER
    }

    public static class Numbers{
        public static final int ONE = 1;
        public static final int TWO = 2;
        public static final int THREE = 3;

        public static final String STR_ONE = "1";
        public static final String STR_TWO = "2";
        public static final String STR_THREE = "3";

        @IntDef({ONE,TWO,THREE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface NumbersInt{

        }

        @StringDef({STR_ONE,STR_TWO,STR_THREE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface NumbersString{

        }
    }

    /**
     * 如何使用注解
     */
    private String getString(@Numbers.NumbersString String b){
        return b;
    }

    private int getInt(@Numbers.NumbersInt int a){
        return a;
    }



}
