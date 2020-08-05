package com.example.android.net.net_basic;

import android.accounts.NetworkErrorException;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 网络请求详解
 */
public class MainActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.Http请求与响应
          //一次请求就是向目标服务器发送一串文本。什么样的文本？有下面结构的文本
          //1.HTTP请求包结构
            //POST /meme.php/home/user/login HTTP/1.1
            //Host:114.215.86.90
            //Cache-Control:no-cache
            //Content-Type:application/x-www-form-urlencoded
            //tel=13637829200&password=123456
         //2.HTTP响应包结构
            //Date:
            //Server:Apache/2.4.6 (CentOS) PHP/5.6.14
            //Content-Length:78
            //Keep-Alive:timeout=5, max=100    Connection: Keep-Alive
            //Content-Type: application/json;charset=utf-8
            //{"status":202,"info":"\u6b64\u7528\u6237\u4e0d\u5b58\u5728\uff01","data":null}

        //二.Http请求方式
          //1.常见的请求网络方式
             //a.GET:获取资源
               //当前网络请求中，大部分是Get方式
             //b.HEAD:获取报文首部
               //和Get方法一样，但是不返回报文实体主体部分
               //主要用于确认URL的有效性以及资源更新的日期时间
             //c.POST:传输实体主体
               //POST主要用来传输数据，GET主要用来获取数据
             //d.PUT:上传文件
                //由于自身不带验证机制，任何人都可以上传文件，因此存在安全性问题，一般不使用该方法。
             //e.PATCH:中文意思(小块) 对资源进行部分修改
                //PUT 也可以用于修改资源，但是只能完全替代原始资源，PATCH 允许部分修改
             //f.DELETE:删除文件
                //与 PUT 功能相反，并且同样不带验证机制
             //g.OPTIONS:查询支持的方法
                //查询指定的 URL 能够支持的方法，会返回 Allow: GET, POST, HEAD, OPTIONS 这样的内容
             //h.CONNECT:要求在与代理服务器通信时建立隧道
                //使用 SSL（Secure Sockets Layer，安全套接层）和 TLS（Transport Layer Security，
                //传输层安全）协议把通信内容加密后经网络隧道传输。
             //i:TRACE:追踪路径
                //服务器会将通信路径返回给客户端。

        //2.常见Content-Type定义
           //a.普通文本:text/plain(清楚的，明显的)
           //b.表单键值对:application/x-www-form-urlencoded
           //c.文件和字符数据一起传输的多块数据:multipart/form-data
           //e.文件数据:application/octet-stream
           //f.json数据:application/json
           //g.xml数据:text/xml

        //三.普通get和post网络请求
          //1.普通的get请求
          //2.普通的post请求
          //3.使用普通网络请求将网络图片转化为bitmap

        //四.Http响应方式
          //1.请求是键值对，但返回数据我们常用Json。
          //2.对于内存中的结构数据，肯定要用数据描述语言将对象序列化成文本，再用Http传递,接收端并从
            //文本还原成结构数据。
          //3.对象(服务器)<-->文本(Http传输)<-->对象(移动端)
        //五.get和post请求的区别
          //1.Get和Post请求的区别
            //a.Get请求的参数是直接放在url后面的，而Post请求是放在请求体中的
            //b.Get请求参数拼接的url的长度会根据浏览器的不同实现有一定限制，而Post请求参数长度没有限制
            //c.Get请求方便测试，直接输入地址即可，而Post请求不方便测试，需要借助代码或者工具进行发送
          //2.Post请求的使用场景
            //a.使用Post请求上传键值对
            //b.用Post请求上传json串
            //c.使用Post请求上传单个文件
            //d.使用Post请求上传多个文件
            //e.参数是经过编码放在请求体中的。 编码包括：
                //x-www-form-urlencoded
               //form-data
          //3.Get请求的使用场景
            //a.在url中填写参数:
               //http://xxxx.xx.com/xx.php?params1=value1&params2=value2
               //https://api.douban.com/v2/book/search?tag=文学&start=0&count=30

        //六.Http缓存机制讲解
          //1.缓存对于移动端是非常重要的存在。
            //a.减少请求次数，减小服务器压力.
            //b.本地数据读取速度更快，让页面不会空白几百毫秒。
            //c.在无网络的情况下提供数据。
            //d.缓存一般由服务器控制(通过某些方式可以本地控制缓存，比如向过滤器添加缓存控制信息)。
              //通过在请求头添加下面几个字端：
         //2.request请求字段含义
            //Accept:Accept: text/plain, text/html  指定客户端能够接收的内容类型
            //Accept-Charset: iso-8859-5            浏览器可以接受的字符编码集
            //Accept-Encoding: compress, gzip       指定浏览器可以支持的web服务器返回内容压缩编码类型
            //Accept-Language: en,zh                浏览器可接受的语言
            //Accept-Ranges: bytes                  可以请求网页实体的一个或者多个子范围字段
            //Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==        HTTP授权的授权证书
            //Cache-Control: no-cache               指定请求和响应遵循的缓存机制
            //Connection: close                     表示是否需要持久连接。（HTTP 1.1默认进行持久连接）
            //Cookie: $Version=1; Skin=new;         HTTP请求发送时，会把保存在该请求域名下的所有cookie值
              //一起发送给web服务器
            //Content-Length: 348                   请求的内容长度
            //Content-Type: application/x-www-form-urlencoded        请求的与实体对应的MIME信息
            //Date: Tue, 15 Nov 2010 08:12:31 GMT   请求发送的日期和时间
            //Expect: 100-continue                  请求的特定的服务器行为
            //From: user@email.com                  发出请求的用户的Email
            //Host: www.zcmhi.com                   指定请求的服务器的域名和端口号
            //If-Match: "737060cd8c284d8af7ad3082f209582d"      只有请求内容与实体相匹配才有效
            //Warn: 199 Miscellaneous warning                   关于消息实体的警告信息
            //Via: 1.0 fred, 1.1 nowhere.com (Apache/1.1)       通知中间网关或代理服务器地址，通信协议
            //User-Agent: Mozilla/5.0 (Linux; X11)              User-Agent的内容包含发出请求的用户信息
            // Upgrade: HTTP/2.0, SHTTP/1.3, IRC/6.9, RTA/x11   向服务器指定某种传输协议以便服务器进行转换（如果支持）
         //3.response响应字段含义
            //Accept-Ranges: bytes                  表明服务器是否支持指定范围请求及哪种类型的分段请求
            //Age: 12                               从原始服务器到代理缓存形成的估算时间（以秒计，非负）
            //Allow: GET, HEAD                      对某网络资源的有效的请求行为，不允许则返回405
            //Cache-Control: no-cache               告诉所有的缓存机制是否可以缓存及哪种类型
            //Content-Encoding: gzip                web服务器支持的返回内容压缩编码类型
            //Content-Language: en,zh               响应体的语言
            //Content-Length: 348                   响应体的长度
            //Content-Location: /index.htm          请求资源可替代的备用的另一地址
            //C Content-MD5: Q2hlY2sgSW50ZWdyaXR5IQ==     返回资源的MD5校验值
            //Content-Range: bytes 21010-47021/47022      在整个返回体中本部分的字节位置
            // Content-Type: text/html; charset=utf-8     返回内容的MIME类型
            //Date: Tue, 15 Nov 2010 08:12:31 GMT         原始服务器消息发出的时间
            //ETag: "737060cd8c284d8af7ad3082f209582d"    请求变量的实体标签的当前值
            //Expires: Thu, 01 Dec 2010 16:00:00 GMT       响应过期的日期和时间
            //LLast-Modified: Tue, 15 Nov 2010 12:45:26 GMT 请求资源的最后修改时间
            //Location: http://blog.csdn.net/coder_pig    用来重定向接收方到非请求URL的位置来完成请求或标识新的资源
            //Pragma: no-cache                包括实现特定的指令，它可应用到响应链上的任何接收方
            //Proxy-Authenticate: Basic        它指出认证方案和可应用到代理的该URL上的参数

    }

    /**
     * 普通的get请求
     */
    private String get(String url){
        //利用string url构建URL对象
        URLConnection connection = null;
        try {
            URL url1 = new URL(url);
            //调用URL的openConnection()方法,获取HttpURLConnection对象
            connection = url1.openConnection();
            //设置请求方法为get
            //connection.setRequestMethod("GET");
            //设置读取超时为5秒
            connection.setReadTimeout(5000);
            //设置连接网络超时为10秒
            connection.setConnectTimeout(10*1000);
            //调用此方法就不必再使用conn.connect()方法
            int responseCode = 0;//connection.getResponseCode();
            if (responseCode == 200) {
                //返回从打开的连接读取的输入流
                InputStream is = connection.getInputStream();
                String response = getStringFromInputStream(is);
                return response;
            } else {
                throw new NetworkErrorException("response status is "+responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                //connection.disconnect();
            }
        }
        return null;
    }
    private static String getStringFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // 模板代码 必须熟练
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        is.close();
        // 把流中的数据转换成字符串,采用的编码是utf-8(模拟器默认编码)
        String state = os.toString();
        os.close();
        return state;
    }

    /**
     * 普通的post请求
     * @param url
     * @param content
     */
    private String StringPost(String url,String content){
        URLConnection connection = null;
        try {
            URL url1 = new URL(url);
            connection = url1.openConnection();
            connection = url1.openConnection();
            //设置请求方法为post
            //connection.setRequestMethod("POST");
            //设置读取超时为5秒
            connection.setReadTimeout(5000);
            //设置连接网络超时为10秒
            connection.setConnectTimeout(10*1000);
            //设置此方法,允许向服务器输出内容
            connection.setDoOutput(true);

            String data = content;
            //获得一个输出流,向服务器写数据,默认情况下,系统不允许向服务器输出内容
            OutputStream out = connection.getOutputStream();
            out.write(data.getBytes());
            out.flush();
            out.close();
            // 调用此方法就不必再使用conn.connect()方法
            int responseCode = 0;//connection.getResponseCode();
            if (responseCode == 200) {
                InputStream is = connection.getInputStream();
                String response = getStringFromInputStream(is);
                return response;
            } else {
                throw new NetworkErrorException("response status is "+responseCode);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                //connection.disconnect();
            }
        }
        return null;
    }
}
