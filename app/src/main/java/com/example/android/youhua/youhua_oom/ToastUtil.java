package com.example.android.youhua.youhua_oom;

import android.content.Context;
import android.widget.Toast;

/**
 *
 */
public class ToastUtil {
    private static Toast mToast = null;
    //长生命周期对象持有短生命周期对象，导致短生命周期对象不能回收。
    //首先单例模式当中SingleInstance对应的实例是静态的，静态变量被创建之后，是被所有的该类对象公用的，
    //静态变量的生命周期是跟随类的生命周期的，也就是只有该类被jvm从内存中干掉后，这个对应的实例的生
    //命周期也就结束了，占用的内存也就被回收了。
    /**
     * 这里如果传入context会报内存泄漏；应该传入ApplicationContext
     * @param context
     * @param toast
     */
    public static void showToast(Context context,String toast){
        if(toast == null){
            mToast = Toast.makeText(context,toast,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(toast);
        }
    }

    public static void cancel(){
        if(mToast != null){
            mToast.cancel();
            mToast = null;
        }
    }
}
