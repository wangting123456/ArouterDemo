package com.example.android.youhua.youhua_oom;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Application;
import com.squareup.leakcanary.RefWatcher;

public class OtherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        leakThread thread = new leakThread();
        thread.start();
    }

    class leakThread extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                //做自己事情的处理
                Thread.sleep(5*11111);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = Application.getRefWatcher(this);
        refWatcher.watch(this);

        //该Activity存在内存泄漏，原因是非静态内部类持有OtherActivity的引用，LeakThread作了耗时操作，导致OtherActivity无法被释放
        //解决办法：LeakThread改为静态内部类，这样OtherActivity对它持有弱引用
    }
}
