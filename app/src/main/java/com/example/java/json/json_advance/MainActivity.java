package com.example.java.json.json_advance;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.java.json.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private String TAG = MainActivity.class.getSimpleName();
    private Gson gson;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
    }

    /**
     * JSON数组转化为字符串数组
     */
    private void gsonToArray(){
        String jsonArray1 = "[\"111\",\"222\",\"333\"]";
        String[] strings = gson.fromJson(jsonArray1, String[].class);
        System.out.println("Json数组 转为 字符串数组: ");
        for (String string : strings) {
            Log.e(TAG,string);
        }
    }

    /**
     * 字符串数组转换为Json数组
     */
    private void arrayToJson() {
        String jsonArray = "[\"2222\",\"3333\",\"4444\",\"5555\"]";
        //字符串数组 转为 Json数组
        jsonArray = gson.toJson(jsonArray, new TypeToken<String>() {}.getType());
        Log.e(TAG,jsonArray);
        //打印日誌
        //"[\"2222\",\"3333\",\"4444\",\"5555\"]"
    }

    /**
     * Json数组转化为List
     */
    private void jsonToList(){
        //Json数组 转为 List
        String jsonArray = "[\"2222\",\"3333\",\"4444\",\"5555\"]";
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
        for (String string : stringList) {
            Log.e(TAG,string);
        }
    }

    /**
     * List转为Json数组
     */
    private void listToJson(){
        Gson gson = new Gson();
        String jsonArray = "[\"2222\",\"3333\",\"4444\",\"5555\"]";
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
        //List 转为 Json数组
        jsonArray = gson.toJson(stringList, new TypeToken<List<String>>() {}.getType());
        Log.e(TAG,jsonArray);
    }
    private void listModelToJson() {
        Person model1 = new Person("yangChong", 25, true);
        Person model2 = new Person("doubi", 26, false);
        final ArrayList<Person> lists = new ArrayList<>();
        lists.add(model1);
        lists.add(model2);
        Gson gson = new Gson();
        String s = gson.toJson(lists);
        Log.e(TAG,s);
        //打印日志
        //[{"age":25,"name":"yangChong","sex":true},{"age":26,"name":"doubi","sex":false}]
    }
}
