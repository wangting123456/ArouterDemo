package com.example.java.list.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class StudentBean implements Parcelable {
    //Parcelable 打包的
    private String id;
    private String code;
    private String name;
    private String syouname;
    private String isrollcall="";
    private String time;
    private String reason;
    private String isout;
    private String js;
    private String temperature;

    public StudentBean(String id,String code){
        this.id = id;
        this.code = code;
    }

    protected StudentBean(Parcel in){
        this.id = in.readString();
        this.code = in.readString();
        this.name = in.readString();
        this.syouname = in.readString();
        this.isrollcall = in.readString();
        this.time = in.readString();
        this.reason = in.readString();
        this.isout = in.readString();
        this.js = in.readString();
        this.temperature = in.readString();
    }


    /**
     * 负责文件的描述，只针对特殊的，需要描述的信息对象，需要就返回1，其他返回0
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 反序列化 CREATOR的变量 名称不可以改变
     */
    private static final Creator<StudentBean> CREATOR = new Creator<StudentBean>() {
        @Override
        public StudentBean createFromParcel(Parcel source) {
            return new StudentBean(source);
        }

        @Override
        public StudentBean[] newArray(int size) {
            return new StudentBean[size];
        }
    };

    /**
     * 实现序列化。直接调用parcel的write方法
     * @param parcel
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.id);
        parcel.writeString(this.code);
        parcel.writeString(this.name);
        parcel.writeString(this.syouname);
        parcel.writeString(this.isrollcall);
        parcel.writeString(this.time);
        parcel.writeString(this.reason);
        parcel.writeString(this.isout);
        parcel.writeString(this.js);
        parcel.writeString(this.temperature);
    }
}
