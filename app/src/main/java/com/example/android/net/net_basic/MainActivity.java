package com.example.android.net.net_basic;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 网络基础笔记
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.网络体系结构
         //1.分层
           //应用层      （HTTP、FTP、DNS、SMTP等等）
           //运输层      （TCP、UDP）
           //网络层      （IP等）
           //数据链路层  （ARP等）
           //物理层
        //2.五层的体系结构，自上往下，最终可以实现端对端之间的数据传输和通信，它们各自负责什么，最终怎么
           //实现端对端之间通信的？
           //a.应用层:如http协议，它实际上定义了如何包装数据和解析数据，应用层如果是http协议，则会按照
              //协议规定包装数据，如按照请求头，请求行，请求体进行包装，包装完后将数据传至运输层。
           //b.运输层:运输层有TCP和UDP两种协议，分别对应可靠的运输和不可靠的运输，如TCP因为要提供可靠
              //的传输，所以内部要解决如何建立连接、如何保证传输是可靠的不丢数据、如何调节流量控制和拥
              //塞控制。关于这一层，我们一般都是和Socket打交道，Socket是一组封装的调用接口，通过它，我们
              //就能操作TCP,UDP进行连接的建立，我们平常使用Socket进行建立链接的时候，一般都要指定端口号
              //所以这一层指定了把数据送到对应的端口号
           //c.网络层:这一层IP协议，以及一些路由选择协议等等，所以这一层指定了数据要传送到哪个IP地址。
              //中间涉及到一些最优路线和路由选择算法等等。
           //d.数据链路层:印象比较深的是ARP协议，负责把IP地址解析为MAC地址，即硬件地址，这样就找到了唯一
              //的机器
           //e.物理层:这一层是最底层，提供二进制流传输服务，也就是真正通过传输介质(有线、无线)开始进行数据的传输
        //所以通过上面五层的各司其职，实现物理传输介质--MAC地址--IP地址--端口号--获取到数据根据应用层
        //协议解析数据最终实现了网络通信和数据传输。

        //二.Http相关知识点
          //1.无连接与无状态
            //a.无连接并不是说不需要连接，http协议只是一个应用层协议，最终还是要靠运输层tcp协议向上提供的
               //服务进行连接
            //b.无连接的含义是:http约定了每次连接只处理一个请求，一次请求完成后就断开连接。这样做主要是为了缓解
               //服务器的压力，减少连接去服务器资源的占用，我的理解是，建立连接实际上是运输层的事，
               //面向应用层的http来说的话，它就是无连接的，因为上层对下层无感知。
            //c.无状态:每个请求之间都是独立的，对于之前的请求事务没有记忆的能力。所以就出现了像Cookie
              //这种，用来保存一些状态的东西

          //2.HTTP的缓存机制
           //a.Http的缓存主要利用header里的两个字段来控制
              //private:则只有客户端可以缓存
              //public:客户端和代理服务器都可以缓存
              //max-age:缓存的过期时间
              //no-cache:需要使用对比缓存来验证缓存数据
              //no-store:所有内存都不会进行缓存

           //b.ETag:即用来进行对比缓存，Etag是服务端资源的一个标识码
              //当客户端发送第一次请求时，服务器会下发当前请求资源的标识码ETag，下次再请求时，客户端则会
              //通过header里的If-None-Match将这个标识码Etag带上，服务端将客户端传来的Etag与最新的资源Etag
              //做对比，如果一样，则表示资源没有更新，返回304
              //通过Cache-control和Etag的配合来实现Http的缓存机制

        //三.Https相关知识点
            //1.HTTPS为什么安全
               //a.Https=Http+Ssl Https保证了我们数据传输的安全
               //b.之所以能保证安全，是使用了非对称加密算法，平常用的对称加密算法之所以不安全，是因为
                 //双方是用统一的密匙进行加密解密的，只要双方任意一方泄漏了密匙，那么其他人就可以利用密匙解密数
               //c.非对称加密算法之所以能实现安全传输的核心精华就是：公钥加密的信息只能用私钥解开，
                 //私钥加密的信息只能被公钥解开
            //2.2 非对称加密算法为什么安全
               //a.服务端申请CA机构颁发的证书，则获取到了证书的公钥和私钥，私钥只有服务器端自己知道，
                 //公钥可以告知其他人，如可以把公钥传给客户端，这样客户端通过服务端传来的公钥来加密自己的
                 //数据，而服务端利用私钥就能解密自己的数据。由于客户端这个用公钥加密的数据只有私钥能
                 //解密，而这个私钥只有服务端有，所以数据传输就安全了

        //四.HTTP协议Keep-Alive模式
          //1.什么是Keep-Alive模式
            //a.我们知道http采用 请求-应答模式，当使用普通模式，即非KeepAlive模式时，每个请求/应答客户
              //和服务器都要新建一个连接，完成之后立即断开连接(Http协议为无连接的协议)。当使用KeepAlive模式
              //(持久连接)客户端到服务端的功能持续连接有效，当出现对服务器的后续请求时，Keep-Alive功能
              //避免了建立或者重新建立连接。
           //b.http 1.0中默认是关闭的，需要在http头加入"Connection: Keep-Alive"，才能启用Keep-Alive；
             //http 1.1中默认启用Keep-Alive，如果加入"Connection: close "，才关闭
        //2.启用Keep-Alive的优点
           //更高效，性能更高，因为避免了建立/释放连接的开销
        //3.Keep-Alive方式下如何判断消息内容/长度的大小
           //Keep-Alive模式客户端如何判断请求所得到的响应数据已经接收完成(或者说如何知道服务器已经发生完了数据?)
             //Keep-Alive模式发送玩数据HTTP服务器不会自动断开连接，所有不能再使用返回EOF（-1）来判断:
           //a.使用消息首部字段Conent-Length:
             //Conent-Length表示实体内容长度，客户端（服务器）可以根据这个值来判断数据是否接收完成.
             //但是如果消息中没有Conent-Length，那该如何来判断呢？接下来请看b
           //b.使用消息首部字段Transfer-Encoding:
             //b.1 当客户端向服务器请求一个静态页面或者一张图片时，服务器可以很清楚的知道内容大小，
               //然后通过Content-length消息首部字段告诉客户端 需要接收多少数据。但是如果是动态页面等时，
               //服务器是不可能预先知道内容大小，这时就可以使用Transfer-Encoding：chunk模式来传输 数据了。
               //即如果要一边产生数据，一边发给客户端，服务器就需要使用"Transfer-Encoding: chunked"这样的方
               //式来代替Content-Length。
             //b.2chunk编码将数据分成一块一块的发生。Chunked编码将使用若干个Chunk串连而成，由一个标明
               //长度为0 的chunk标示结束。每个Chunk分为头部和正文两部分，头部内容指定正文的字符总数（十六进
               //制的数字 ）和数量单位（一般不写），正文部分就是指定长度的实际内容，两部分之间用回车换行(CRLF)
               //隔开。在最后一个长度为0的Chunk中的内容是称为footer的内容，是一些附加的Header信息

        //五.url特性
          //1.拼接url链接字符串工具类
          //2.获取Uri对象的各种属性

        //六.其他知识点
          //1.URL编码
            //http协议中请求的url不支持中文和特殊字符(如&?)，所以需要对url进行编码和解码。编码使用的
            //是URLEncoder，解码使用的是URLDecoder；
            //进行url编码:URLEncoder.encode(url)
            //进行url解码:URLDecoder.decode(encodeUrl)
         //2.Http 2.0
           //a.Okhttp支持配置使用Http 2.0协议
           //b.Http2.0相对于Http1.x来说提升是巨大的:
             //二进制格式:http1.x是文本协议，而http2.0是二进制以帧为基本单位，是一个二进制协议，一帧中除
               //了包含数据外同时还包含该帧的标识：StreamIdentifier，即标识了该帧属于哪个request,使得
               //网络传输变得十分灵活。
            //多路复用:一个很大的改进，原先http1.x一个连接一个请求的情况有比较大的局限性，也引发了很多
               //问题，如建立多个连接的消耗以及效率问题。http1.x为了解决效率问题.可能会尽量多的发起
               //并发的请求去加载资源，然而浏览器对于同一域名下的并发请求有限制，而优化的手段一般是将
              //请求的资源放到不同的域名下来突破这种限制。
              //而http2.0支持的多路复用可以很好的解决这个问题，多个请求共用一个TCP连接，多个请求可以同
              //时在这个TCP连接上并发，一个是解决了建立多个TCP连接的消耗问题，一个也解决了效率的问题。
              //那么是什么原理支撑多个请求可以在一个TCP连接上并发呢？基本原理就是上面的二进制分帧，
              //因为每一帧都有一个身份标识，所以多个请求的不同帧可以并发的无序发送出去，在服务端会根
              //据每一帧的身份标识，将其整理到对应的request中。
            //header头部压缩:主要是通过压缩header来减少请求的大小，减少流量消耗，提高效率。因为之前存
              //在一个问题是，每次请求都要带上header，而这个header中的数据通常是一层不变的。 支持服务端推送

    }

    private String getStringUrl(String url,HashMap<String,String> map){
        if(TextUtils.isEmpty(url)){
            return null;
        }
        Uri uri = Uri.parse(url);
        Uri.Builder builder = uri.buildUpon();
        if(map != null && map.size() > 0){
            Set<Map.Entry<String,String>> set = map.entrySet();
            for (Map.Entry<String,String> bean:set ){
                String key = bean.getKey();
                String value = bean.getValue();
                //对键和值进行编码，然后将参数追加到查询字符串中。
                builder.appendQueryParameter(key,value);
            }
        }
        return builder.toString();
    }
}
