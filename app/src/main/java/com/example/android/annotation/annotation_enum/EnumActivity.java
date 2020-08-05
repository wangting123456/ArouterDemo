package com.example.android.annotation.annotation_enum;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EnumActivity extends AppCompatActivity {
    private String TAG = EnumActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.先看枚举使用
           //a.在jdk1.5之前，定义常量都是 public static final ....,有枚举之后，可以把相关的常量分组在枚举类型里面。
             //枚举提供了比常量更多的方法
          //b.所有的枚举类型隐性地继承自 java.lang.Enum。枚举实质上还是类!而每个被枚举的成员实质就是一个枚举类型的实例，他们默认都是public static final修饰的。
             // 可以直接通过枚举类型名使用它们。
          //c.使用：Log.d(TAG,""+ MainActivity.SeasonEnum.AUTUMN);
          //d.我们可以给枚举中添加属性和方法
             MessageEnum msg = MessageEnum.ACCOUNT_DISABLE;
             Log.d(TAG,msg.desc);    Log.d(TAG,msg.type);

    }

    public enum SeasonEnum{
        SPRING,SUNNER,AUTUMN,WINTER
    }

    public enum MessageEnum{
        SYSTEM("1","系统消息"),
        ORDER_STATE("4","运单状态消息"),
        USER_FLEET("5","用户车队推送信息"),
        VOICE_NOTICE("6","语音播报通知"),
        ACCOUNT_DISABLE("7","账户禁用通知");
        private String type;
        private String desc;
        private MessageEnum(String type,String desc){
            this.type = type;
            this.desc = desc;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
