package com.example.android.youhua.youhua_oom;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InnerActivity extends AppCompatActivity {
    private static Inner inner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  这里内部类InnerClass隐式的持有外部类MyActivity的引用，而在MyActivity的onCreate方法中调用了。
        这样innerClass就会在MyActivity创建的时候是有了他的引用，而innerClass是静态类型的不会被垃圾回收，
        MyActivity在执行onDestory方法的时候由于被innerClass持有了引用而无法被回收，所以这样MyActivity就总
        是被innerClass持有而无法回收造成内存泄露。*/
        inner = new Inner();
        inner.dothing();
    }

    class Inner{
        public void dothing(){
            Log.d("inner","dothing");
        }
    }
}
