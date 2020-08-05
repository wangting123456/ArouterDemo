package com.example.android.net.net_basic;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Retrofit基本使用和源码解析
 */
public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.关于Retrofit基本介绍
         //1.Retrofit是Square 公司开发的一款正对Android 网络请求的框架。底层基于OkHttp 实现，OkHttp
            //已经得到了google 官方的认可。
         //2.Retrofit是由Square公司出品的针对于Android和Java的类型安全的Http客户端，如果看源码会发
            //现其实本质上是OkHttp的封装。使用面向接口的方式进行网络请求，利用动态生成的代理类封装了
            //网络接口请求的底层，其将请求返回JavaBean，对网络认证REST API进行了很友好的支持。使用
            //Retrofit将会极大的提高我们应用的网络体验。
         //3.RxJava + Retrofit + okHttp组合，流行的网络请求框架
           //a.Retrofit 负责请求的数据和请求的结果，使用接口的方式呈现，OkHttp 负责请求的过程，RxJava
            //负责异步，各种线程之间的切换。
           //b.一个在 Java VM 上使用可观测的序列来组成异步的、基于事件的程序的库。
        //4.为什么要使用Retrofit
          //a.请求的方法参数注解可以定制
          //b.支持同步、异步和RxJava
          //c.超级解耦
          //d.可以配置不同的反序列化工具来解析数据，如json、xml等

        //二.注解的种类
          //1.请求方法注解
            //a.@GET        get请求
            //b.@POST       post请求
            //c.@PUT        put请求
            //d.@DELETE     delete请求
            //e.@PATCH      patch请求，该请求是对put请求的补充，用于更新局部资源
            //f.@HEAD       head请求
            //g.@OPTIONS    option请求
            //h.@HTTP       通用注解,可以替换以上所有的注解，其拥有三个属性：method，path，hasBody
         //2.请求头注解
            //a.@Headers    用于添加固定请求头，可以同时添加多个。通过该注解添加的请求头不会相互覆盖，而是共同存在
            //b.@Header     作为方法的参数传入，用于添加不固定值的Header，该注解会更新已有的请求头
         //3.标记注解
            //@FormUrlEncoded  表示请求发送编码表单数据，每个键值对需要使用@Field注解
            //@Multipart      作用于方法 表示请求发送multipart数据，使用该注解，表示请求体是多部分的，
              //每个部分作为一个参数，且用Part注解声明。
            //@Streaming    作用于方法  未使用@Straming 注解，默认会把数据全部载入内存，之后通过流获
              //取数据也是读取内存中数据，所以返回数据较大时，需要使用该注解。处理返回Response的方法的响应体，
              //用于下载大文件。提醒:如果是下载大文件必须加上@Streaming 否则会报OOM。

              //@Streaming
              //@GET
              //Call<ResponseBody> downloadFileWithDynamicUrlAsync(@Url String fileUrl);
           //4.参数注解
             //@Query  @QueryMap
             //@Field  @FiledMap
             //@Part   @PartMap
             //@Body
           //5.其他注解
             //@Path  @Url

        //三.Retrofit相关请求参数
          //1.@Query()  [get请求/接上参数]
            //作用于方法参数，用于添加查询参数，即请求参数
            //@GET("book/search")
            //Call<Book> getSearchBook(@Query("q") String name);
         //2.@QueryMap()  [get请求/接上参数]
            //作用于方法参数，以Map的形式添加查询参数，即请求参数。参数的键和值都通过String.valueOf()转换为String格式。
            //@GET("book/search")
            //Call<book> getSearchBook(@QueryMap Map<String,String> options)
         //3.@Field() [post请求/ 用于传送表单数据]
            //用于传送表单数据：
            //@FormUrlEncoded
            //@POST("user/edit")
            //Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);
            //开头必须加@FormUrlEncoded这句注释，不然会报错。表单自然是有多组键值对组成，这里的first_name就是键，
            //而具体传入的first就是值啦。多用于post请求中表单字段,Filed和FieldMap需要FormUrlEncoded结合使用
        //4.@FieldMap()[post请求/ 用于传送表单数据]
            //@FormUrlEncoded
            //@POST("book/search")
            //Call<User> updateUser(@FieldMap Map<String,String> map)
        //5.@Body() [post请求/ 指定一个对象作为HTTP请求体]
            //使用@Body 注解定义的参数不能为null 。当你发送一个post或put请求，但是又不想作为请求参数
            //或表单的方式发送请求时，使用该注解定义的参数可以直接传入一个实体类，retrofit会通过convert
            //把该实体序列化并将序列化的结果直接作为请求体发送出去。
            // @POST("users/new")
            //Call createUser(@Body User user)
            //多用于post请求发送非表单数据,比如想要以post方式传递json格式数据
        //6.@Path [get请求/ 替换url中某个字段]
            //@GET("/ranking/{rankingid}")
            //Observable<SubHomeTopBean> getRanking(@Path("rankingId") String rankingId)
            //像这种请求接口，在group和user之间有个不确定的id值需要传入，就可以这种方法
            //@GET("/group/{id}/user")
            //Call<Book> groupList(@Path("id") String id,@Query("sort") String sort)

        //7.@Header/@Headers()[添加请求头部]
           //用于动态添加请求头部：
           //@GET("user")
           //Call<User> getUser(@Header("Author") String author)
           //表示将头部Author属性设置为你传入的author；当然你还可以用@Headers表示,作用是一样的

        //8.@Part()作用于方法的参数，用于定义Multipart请求的每和part
          //使用该注解定义的参数，参数值可以为空，为空时，则忽略。使用该注解定义的参数类型有如下3中方式可选：
          //@Multipart
          //@POST("/")
          //Call<ResponseBody> example(@Part("des") String des,@Part(value = "image", encoding = "8-bit") RequestBody image);
       //9.@PartMap()作用于方法的参数
          //以map的方式定义Multipart请求的每个part map中每一项的键和值都不能为空，否则抛出IllegalArgumentException异常。
          //使用@PartMap 注解定义的参数类型有一下两种：
          //a.如果类型是RequestBody，那么该值将直接与其内容类型与其使用。
          //b.其它对象类型将通过使用转换器转换为适当的格式。

        //四.OkHttpClient
         //1.拦截器说明
           //a.addNetworkInterceptor添加的是网络拦截器Network,Interfacetor它会在request和response时分别被调用一次；
           //b.addInterceptor添加的是应用拦截器Application Interceptor他只会在response被调用一次
         //2.日志拦截器
           //a.一种是使用HttpLoggingInterceptor,需要使用到依赖
         //3.请求头拦截器

         //4.统一请求拦截器

         //5.缓存拦截器

        //五.Form表单提交与multipart/form-data

        //六.content-type介绍
         //1.application/x-www-form-urlencoded
           //这应该是最常见的POST提交数据的方式了。浏览器的原生表单，如果不设置enctype属性，那么最终会
           //以application/x-www-form-urlencoded方法提交数据。请求类似于如下内容(省略了部分无关的内容):
           //提交的数据按照key-value的格式，也就是key1=value1,key2=value2这种方式进行编码
           //POST http://www.hao123.com/ HTTP/1.1
           //Content-Type: application/x-www-form-urlencoded;charset=utf-8
           //title=test&sub%5B%5D=1&sub%5B%5D=2&sub%5B%5D=3
        //2.application/json
          //application/json 这个Content-Type作为响应头大家肯定不陌生。事实上现在已经基本都是都是这种方
          //式了，来通知服务器消息体是序列化后的JSON字符串。
          //POST http://www.hao123.com/ HTTP/1.1
          //Content-Type: application/json;charset=utf-8
          //{"title":"test","sub":[1,2,3]}
        //3.text/xml
          //XML-RPC 协议很简单、功能够用，各种语言的实现都有。它的使用也很广泛，但是我还是比较倾向于
          // JSON，因为相比于JSON，XML太过于臃肿。
        //4.multipart/form-data
          //常见的POST数据提交的方式。我们使用表单上传文件时，必须让form表单enctype等于multipart/form-data

    }

    /**
     * log拦截器
     * @return
     */
    private HttpLoggingInterceptor getLogInter(){
        HttpLoggingInterceptor log = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("OkHttp", "log = " + message);
            }
        });
        return log;
    }

    /**
     * 请求头拦截器
     * 使用addHeader()不会覆盖之前设置的header,若使用header()则会覆盖之前的header
     * @return
     */
    private Interceptor getRequestHeader(){
        //使用addInterceptor()方法添加到OkHttpClient中
        //我的理解是，请求头拦截器是为了让服务端能更好的识别该请求,服务器那边通过请求头判断该请求是否为有效请求等.
        Interceptor headInter = new Interceptor(){
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder();
                builder.addHeader("version", "1");
                builder.addHeader("time", System.currentTimeMillis() + "");
                Request.Builder requestBuilder = builder.method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return headInter;
    }

}
