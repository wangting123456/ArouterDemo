package com.example.arouter.arouter_basic;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 存放所有的路由跳转工具类
 */
public class ARouterUtils {
    public static void nagivation(String url){
        if(url == null){
            return;
        }
        ARouter.getInstance().build(url).navigation();
    }
}
