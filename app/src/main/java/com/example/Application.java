package com.example;

import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.smtt.sdk.QbSdk;

public class Application extends MultiDexApplication {
    private RefWatcher refWatcher;
    private static Application mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        initX5();
        //initLeak();
        refWatcher = stepUpRefWatcher();
    }
    public static Application getInstance(){
        return mInstance;
    }

    /**
     * 如果只关注activity的内存泄漏，那么在Application中onCreate加入LeakCanary.install(this);就OK了，
     */
    private void initLeak(){
        //如果当前的进程是用来给LeakCanary 进行堆分析的则return
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        //否则会执行LeakCanary的install方法
        LeakCanary.install(this);
    }

    /**
     * 如果还关注fragment的泄漏情况，那么Application加上RefWatcher，然后在对应fragment页面中onDestroy中加入：
     * @return
     */
    private RefWatcher stepUpRefWatcher(){
        if(LeakCanary.isInAnalyzerProcess(this)){
            return RefWatcher.DISABLED;
        }
        //否则会执行LeakCanary的install方法
       return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context){
        Application application = (Application)context.getApplicationContext();
        return application.refWatcher;
    }

    private void initX5(){
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback callback = new QbSdk.PreInitCallback(){

            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + b);
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),callback);
    }
}
