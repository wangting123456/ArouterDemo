package com.example.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends Activity {
    private TextView tvShow;
    private Button btnClick;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        //基于观察者模式，写的发布订阅模式，由geenDao公司贡献。用于Android中的解耦操作
        tvShow = (TextView) findViewById(R.id.tv_show);
        btnClick = (Button) findViewById(R.id.btn_click);
        EventBus.getDefault().register(this);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("你好"));
            }
        });

    }

    /**
     * sticky机制俗称粘性事件。即发送事件之后再订阅该事件也能收到该事件。sticky默认值为false，在Subscribe方法中可以更改。
     * @param event
     */
    @Subscribe(sticky = true)
    public void onMessageEvent(MessageEvent event){
        if(event != null){
            tvShow.setText(event.getMessage());
        }
    }

    /*ThreadMode.ASYNC也表示在后台执行(也就是子线程执行),可以异步并发处理
    (适用于多个线程任务处理,内部有线程池管理,比如请求网络时,用这个方法,他会自动创建线程去请求)
    无论发布者是在子线程还是主线程,该方法都会创建一个子线程,在子线程执行.*/

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void MessageEventBus2(MessageEvent eventBusMessage){
        Log.d("eventBusThread","ThreadMode.ASYNC "+Thread.currentThread().getName());

    }

    /**
     *  //ThreadMode.BACKGROUND表示该方法在后台运行(也就是子线程),不能够并发处理
     *  如果发布者在子线程,那么该方法就在子线程执行
     *   如果发布者在主线程,那么该方法就会创建一个子线程,在子线程运行.
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMeaasgeEvent1(MessageEvent event){

    }

    /**
     * ThreadMode.MAIN表示这个方法在主线程中执行(适合做异步加载,可以将子线程加载到数据直接设置到UI界面里)
     * @param eventBusMessage
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent eventBusMessage){
        //在TextView显示接收的消息,从这个类里拿属性.
        tvShow.setText(eventBusMessage.getMessage());
        Log.d("eventBusThread","ThreadMode.MAIN "+Thread.currentThread().getName());

    }


    //ThreadMode.POSTING表示该方法和消息发送方在同一个线程.
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void MessageEventBus1(MessageEvent eventBusMessage){
        Log.d("eventBusThread","ThreadMode.POSTING "+Thread.currentThread().getName());
    }


    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
