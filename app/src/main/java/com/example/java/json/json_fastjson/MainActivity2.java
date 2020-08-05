package com.example.java.json.json_fastjson;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.arouterdemo.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_json_fastjson_main);
        test();
        test2();
        test3();
        //JSONObject 方法:
         //put(String key,String value):在JSONObject中设置键值对
         //Object get(String key):根据key获取JSONObject中的value值，获取到的值是Object类型，需要手动转化为需要的数据类型
         //int size():获取JSONObject中键值对的个数
         //boolean isEmpty():判断JSONObject是否为空
         //conatinsKey(Object key):判断是否有需要的key值
         //containsValue(Object value)判断是否有需要的value值
         //JSONObject getJSONObject(String key):如果JSONObjct中的value是JSONObjct，根据key获取JSONObject对象
         //JSONArray getJSONArray(String key)：如果JSONObjct中的value是JSONArray，根据key获取JSONArray对象
         //Object remove(String key):根据key清除某一个键值对
         //toJSONString() /toString()：将JSONObjct对象转化问哦json字符串
         //JSONObject是一个map，还有两个特别的方法
         //Set<String> ketSet():获取JSONObject中的key，并放入set
         //Set<Map.Entry<String, Object>> entrySet()：在循环遍历时使用，取得是键和值的映射关系，Entry就是Map接口中的内部接口

    }
    private void test(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zhangsan");
        jsonObject.put("age",24);
        jsonObject.put("chengji",477);
        Log.d("test","jsonObject:"+jsonObject.toString());

        String name = (String)jsonObject.get("name");
        int age = (Integer) jsonObject.get("age");
        Log.d("test","name:"+name);
        Log.d("test","age:"+age);

        int size = jsonObject.size();
        Log.d("test","size:"+size);

        boolean isEmpty = jsonObject.isEmpty();
        Log.d("test","isEmpty:"+isEmpty);

        boolean containname =  jsonObject.containsKey("name");
        Log.d("test","containname:"+containname);

        boolean containvalue = jsonObject.containsValue("zhangsan");
        Log.d("test","containvalue:"+containvalue);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("student",jsonObject);

        JSONObject object = jsonObject2.getJSONObject("student");
        Log.d("test","object:"+object.toString());
        Log.d("test","object:"+object.toJSONString());

        JSONObject objectArray = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0,"111");
        jsonArray.add(1,"222");
        objectArray.put("jsonarray",jsonArray);

        JSONArray array = objectArray.getJSONArray("jsonarray");
        for (int i = 0;i < array.size();i++){
            //JSONObject jsonObject1 = (JSONObject)array.get(i);
            Log.d("test","objectArray jsonObject:"+array.get(i));
        }
        jsonObject.remove("name");

        Set<String> keySet = jsonObject.keySet();
        for(String k:keySet){
            Log.d("test","keySet:k:"+k);
        }

        Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
        for (Map.Entry<String, Object> entry:entrySet){
            Log.d("test","entry:entry:"+entry.getKey());
            Log.d("test","entry:entry:"+entry.getValue());
        }
    }

    /**
     * Json转为Map
     */
    private void test2(){
        String json = "{\"contend\":[{\"bid\":\"22\",\"carid\":\"0\"},{\"bid\":\"22\",\"carid\":\"0\"}],\"result\":100,\"total\":2}";
        JSONObject jsonObject = JSON.parseObject(json);
        Map<String,Object> map = new HashMap<>();
        Iterator iterator =jsonObject.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Object> entry = (Map.Entry<String,Object>)iterator.next();
            map.put(entry.getKey(),entry.getValue());
        }
        Log.d("test","map:"+map.toString());
    }


    /**
     * Map转为Json
     */
    private void test3(){
        Map<String, Object> data_data = new HashMap<>();
        data_data.put("name","lisi");
        Map<String,Object> map = new HashMap<>();
        map.put("filter",data_data);
        Log.d("test","111:"+JSON.toJSONString(map));
        Log.d("test","222:"+JSONObject.toJSONString(map));
        //{"name":"lisi"}
        //{"name":"lisi"}
        //{"filter":{"name":"lisi"}}
        //{"filter":{"name":"lisi"}}
    }
}
