package com.example.android.ipc.ipc_introduce;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     /*   客户端进程：
        首先绑定服务端 Service ，绑定成功之后用服务端的 IBinder 对象创建一个 Messenger ，通过这个 Messenger
         就可以向服务端发送消息了，消息类型是 Message 。如果需要服务端响应，
        则需要创建一个 Handler 并通过它来创建一个 Messenger（和服务端一样），
        并通过 Message 的 replyTo 参数传递给服务端。服务端通过 Message 的 replyTo 参数就可以回应客户端了。*/
       /* 服务端进程：
        服务端创建一个 Service 来处理客户端请求，同时通过一个 Handler 对象来实例化一个 Messenger 对象，然后在 Service 的 onBind
        中返回这个 Messenger 对象底层的 Binder 即可。*/
    }
    private void bindService(){
        Intent intent = new Intent(this,MessengerService.class);
        this.bindService(intent,conn, Context.BIND_AUTO_CREATE);
    }
    private Messenger service;
    private Messenger mGetReplyMessenger = new Messenger(new MessageHandler());
    private class MessageHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_FROM_SERVICE:
                    Log.d("@_@", "received msg form service: msg = [" + msg.getData().getString(MSG_KEY) + "]");
                    Toast.makeText(MainActivity1.this, "received msg form service: msg = [" + msg.getData().getString(MSG_KEY) + "]", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
    private final int MSG_FROM_SERVICE = 1;
    private int MSG_FROM_CLIENT = 2;
    private String MSG_KEY = "KEY";
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            service = new Messenger(iBinder);
            Message msg = Message.obtain(null,MSG_FROM_CLIENT);
            Bundle data = new Bundle();
            data.putString(MSG_KEY, "Hello! This is client.");
            msg.setData(data);
            msg.replyTo = mGetReplyMessenger;
            try {
                service.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
