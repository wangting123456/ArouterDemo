package com.example.lifecycle;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(new MyLifeCycleObserver());
        //LifeCycle是Google 推荐的组件
        //一.作用
             //简单来说就是监听Activity和Fragment的生命周期变化
                //a.生命周期拥有着和生命周期被观察者之间快速方便的建立一种联系，在生命周期拥有者的生命周期变化时，观察者会收到对应的通知。
                //b.可以方便的判断当前生命周期拥有者所处在的生命周期状态。
        //二.场景
             //自定义View需要对页面生命周期变化进行对应的处理，如动画的开始和结束，页面销毁时释放资源等。这种情况下，
             //同样需要在Activity或Fragment的生命周期回调中调用View的各个方法。
        //三.LifeCycle的两个角色
             //LifeCycleOwner 生命周期拥有者：即Activity和Fragment
             //LifeCycleObserver 生命周期观察者：可以是任何类，比如自定义View
        //四.如何使用
             //LifeCycleOwner：AppCompatActivity与V4中的Fragment都已默认实现了LifeCyclerOwner接口，所以可以直接使用。
             //LifeCycleObserver：生命周期观察者需要实现LifeCycleObserver接口，这个接口没有任何方法。
                                 //那他如何对生命周期进行观察呢？答案是依赖注解-->OnLifecycleEvent
        //五.角色定义好后，建立联系
             getLifecycle().addObserver(new MyLifeCycleObserver());

    }
}
