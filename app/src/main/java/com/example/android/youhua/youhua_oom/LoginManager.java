package com.example.android.youhua.youhua_oom;

import android.content.Context;


public class LoginManager {
    private static LoginManager mInstance;
    private Context context;
    private LoginManager(Context context){
        this.context = context;
        //或者修改为：
        //this.context = context.getApplicationContext();

    }
    public static LoginManager getInstance(Context context){
        if(mInstance == null){
            synchronized (LoginManager.class){
                if(mInstance == null){
                    mInstance = new LoginManager(context);
                }

            }

        }
        return mInstance;
    }

    public void dealData(){

    }
}
