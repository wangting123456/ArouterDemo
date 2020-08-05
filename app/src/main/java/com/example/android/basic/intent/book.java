package com.example.android.basic.intent;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.livedata.activity.User;

public class book implements Parcelable {
    private String name;
    private String data;

    public book(String name,String data){
        this.name = name;
        this.data = data;
    }
    protected book(Parcel in) {
       name = in.readString();
       data = in.readString();
    }

    public static final Creator<book> CREATOR = new Creator<book>() {
        @Override
        public book createFromParcel(Parcel in) {
            return new book(in);
        }

        @Override
        public book[] newArray(int size) {
            return new book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(data);
    }
}
