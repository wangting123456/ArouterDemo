package com.example.java.json.json_fastjson;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.arouterdemo.R;
import com.example.java.json.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_json_fastjson_main);
        createJsonToString();
    }

    //1.生成Json字符串
      //{"name":"zhangsan"}
      //{} 表示对象
      //[] 表示数组
      //"" 双引号内是属性或值
      //: 冒号表示后者是前者的值 (这个值可以是字符串、数字、也可以是另一个数组或对象)

    //2.Json字符串转化为JSONObject
      //json:一个键对应一个值，超级简单的一对一关系
      //JSONObject：json对象，一个键对应一个值。使用大括号{"name":"zhangsan","age":14}
      //JSONArray:json数组，使用[],只不过数组里面也是键值对。
                  //json对象中添加的是键值对，json数组中添加的是json对象
      //Json字符转化为JsonObject test()
      //Json字符 转换为 JSONArray test2()

    /**
     *   生成Json字符串
     */
    private void createJsonToString(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zhangsan");
        Log.d("createJsonToString","jsonObject:"+jsonObject.toString());

    }

    /**
     * Json字符转化为JsonObject
     * @param jsonString
     */
    public void test(String jsonString){
        JSONObject jsonObject =  JSON.parseObject(jsonString);
        String name = jsonObject.getString("teacherName");
        int age = jsonObject.getInteger("teacherAge");
        JSONObject jsonObject1 = jsonObject.getJSONObject("course");
        JSONArray jsonArray = jsonObject.getJSONArray("students");
        Log.d("test",""+jsonObject.toString());
    }

    /**
     * Json字符转化为JsonArray
     */
    public void test2(String jsonString){
        JSONObject jsonObject =  JSON.parseObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("students");
    }
    /**
     *
     * @param jsonString
     * @return
     */

    //fastJson 获取javaBean
    public Person getPerson(String jsonString){
        Person person = JSON.parseObject(jsonString,Person.class);
        return person;
    }

    //fastJson 获取javaBeanList
    public void getPersonList(String jsonString){
        List list = new ArrayList();
        list = JSON.parseArray(jsonString,Person.class);
    }


}
