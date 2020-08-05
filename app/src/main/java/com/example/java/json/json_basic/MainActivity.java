package com.example.java.json.json_basic;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.arouterdemo.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_json_basic_main);
        stringToJson();
        jsonObjectToJson();
        jiheToJson();

    }

    /**
     * String 生成JSON数据
     * String 类型的数据加"",每个Key，Value加单引号
     */
    private void stringToJson() {
        String date = "[{'name':'tony','age':21},{'name':'aly','age':18}]";
        try {
            JSONArray jsonArray = new JSONArray(date);
            Log.d(TAG, "data:" + jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String date2 = "'json':[{'name':'tony','age':12},{'name':'tyon','age':34}]";
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(date2);
            Log.d(TAG, "data:" + jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void jsonObjectToJson() {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        jsonObject.put("age", 12);
        jsonObject.put("name", "zhangsan");
        jsonObject.put("sex", "男");
        jsonObject1.put("age", 24);
        jsonObject1.put("name", "lisi");
        jsonObject1.put("sex", "男");
        array.put(jsonObject);
        array.put(jsonObject1);
        obj.put("name", array);
        Log.d(TAG, "obj:" + obj.toString());
        // 结果：{"name":[{"name":"zhangsan","sex":"男","age":12},{"name":"lisi","sex":"男","age":24}]}

        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject3 = new JSONObject();
        jsonObject2.put("color", "lanse");
        jsonObject2.put("height", "1");
        jsonObject3.put("color", "lanse");
        jsonObject3.put("height", "2");
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject2);
        jsonArray.put(jsonObject3);
        Log.d(TAG, "data:" + jsonArray.toString());
//结果：[{"color":"lanse","height":"1"},{"color":"lanse","height":"2"}]

    }

    private void jiheToJson(){
        Map<String,Object> map = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","23");
        map2.put("name","lisi");
        map2.put("age","24");
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(map);
        jsonArray.put(map2);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key",jsonArray);
        Log.d(TAG,"data:"+jsonObject.toString());
        //结果：{"key":[{"name":"zhangsan","age1":"v"},{"name":"lisi","age":"24"}]}


        Map<String ,String> map1 =new HashMap<>();
        map1.put("as","adasd");
        map1.put("asfa","afasff");
        JSONArray array3 =new JSONArray();
        array3.put(map1);
        System.out.println(array3.toString());
       // 结果：[{"asfa":"afasff","as":"adasd"}]


        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("name","ceshi");
        hashMap.put("password","123456");
        Map<String,Object> json_filter = new HashMap<>();
        json_filter.put("filter",hashMap);
        Map<String,Object> json_data = new HashMap<>();
        json_data.put("data",json_filter);
        Map<String,Object> realHashMap = new HashMap<>();
        realHashMap.put("json", JSON.toJSONString(json_data));
    }

    /**
     * 利用Gson生成简单的gson字符串
     */
    private void toGson(){
       /* JSONObject jsonObject = new JSONObject();
        jsonObject.addProperty("String", "leavesC");
        jsonObject.addProperty("Number_Integer", 23);
        jsonObject.addProperty("Number_Double", 22.9);
        jsonObject.addProperty("Boolean", true);
        jsonObject.addProperty("Char", 'c');
        Log.e(TAG,jsonObject.toString());*/

    }


    //◦首先获取JSON元素数组：JSONArray jsonArray = new JSONArray(jsonData);
    //◦其次循环获取每个元素：JSONObject jsonObject = jsonArray.getJSONObject(index);
    //◦每次循环保存名称相对应的值：String name = jsonObject.getString("name");


}
