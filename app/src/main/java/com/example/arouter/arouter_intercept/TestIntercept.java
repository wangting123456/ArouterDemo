package com.example.arouter.arouter_intercept;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.annotation.Interceptor;

@Interceptor(priority = 1)
public class TestIntercept implements IInterceptor {
    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {
       if("/test/test1".equals(postcard.getPath())){
           {

               // 这里的弹窗仅做举例，代码写法不具有可参考价值
               final AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.getThis());
               ab.setCancelable(false);
               ab.setTitle("温馨提醒");
               ab.setMessage("想要跳转到Test4Activity么？(触发了\"/inter/test1\"拦截器，拦截了本次跳转)");
               ab.setNegativeButton("继续", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       callback.onContinue(postcard);
                   }
               });
               ab.setNeutralButton("算了", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       callback.onInterrupt(null);
                   }
               });
               ab.setPositiveButton("加点料", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       postcard.withString("extra", "我是在拦截器中附加的参数");
                       callback.onContinue(postcard);
                   }
               });

               MyHandler.runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       ab.create().show();
                   }
               });
           }
       }else {
           callback.onContinue(postcard);
       }
    }

    @Override
    public void init(Context context) {

    }
}
