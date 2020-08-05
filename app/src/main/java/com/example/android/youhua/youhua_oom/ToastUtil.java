package com.example.android.youhua.youhua_oom;

import android.content.Context;
import android.widget.Toast;

/**
 *
 */
public class ToastUtil {
    private static Toast mToast = null;

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
