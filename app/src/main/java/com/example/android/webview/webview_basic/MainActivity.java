package com.example.android.webview.webview_basic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

import java.util.HashMap;
import java.util.Set;

import javax.xml.validation.Schema;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_webview_basic);
        webView = (WebView) findViewById(R.id.webView);
        //1.常用的基础介绍
        webView.loadUrl("http://www.baidu.com/");//会在系统内置的浏览器中打开，解决这个问题需要为webView设置setWebViewClient，
        //并重写shouldOverrideUrlLoading
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                super.shouldOverrideUrlLoading(view, request);
                view.loadUrl("http://www.baidu.com/");
                //返回值是true的时候控制去WebView打开，
                //为false调用系统浏览器或第三方浏览器
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        //2.Android 调用JS
        //第一种方式：native调用JS的方法，一定在onPageFinished之后调用
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("javascript:callByAndroid()");//调用无参方法
        webView.loadUrl("javascript:showData(" + 1 + ")");//调用有参方法
        //第二种方式：新需求情况下，我们想得到Native调用Web的回调怎么办，4.4后为我们新增了一个方式，
        //比loadUrl更简单，更高效，需要加版本判断
        webView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT < 18) {
            //第一种
            webView.loadUrl("javascript:callByAndroid()");
        } else {
            webView.evaluateJavascript("javascript:callByAndroid()", new ValueCallback() {

                @Override
                public void onReceiveValue(Object value) {
                    //此处为js返回的结果
                }
            });
        }

        //3.JS调用Android
        //第一种方式：通过 addJavascriptInterface 注解
        webView.addJavascriptInterface(new JSObject(this), "showToast");
        //JS代码调用
              /*  function showToast(){
                 var result = myObj.showToast("我是来自web的Toast");
              }*/
        //缺点：会存在漏洞


        //第二种方式：利用WebViewClient 回调接口拦截url
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                super.shouldOverrideUrlLoading(view, request);
                //假定传入进来的 url = "js://openActivity?arg1=111&arg2=222"，代表需要打开本地页面，并且带入相应的参数
                Uri uri = Uri.parse(request.toString());
                String schema = uri.getScheme();
                if (schema.equals("js")) {//如果 scheme 为 js，代表为预先约定的 js 协议
                    if (uri.getAuthority().equals("openActivity")) {//如果 authority 为 openActivity，代表 web 需要打开一个本地的页面
                        HashMap<String, String> params = new HashMap<>();
                        //解析 web 页面带过来的相关参数
                        Set<String> collection = uri.getQueryParameterNames();
                        for (String name : collection) {
                            params.put(name, uri.getQueryParameter(name));
                        }
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        intent.putExtra("param", params);
                        startActivity(intent);
                    }
                }
                //代表应用内部处理完成
                return true;
            }
        });
        //JS代码调用
            /*   function openActivity(){
                 document.location = "js://openActivity?arg1=111&arg2=222";
            }*/
        //缺点：不会存在漏洞，但是没有返回值


        //第三种方法：
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                //假定传入进来的 message = "js://openActivity?arg1=111&arg2=222"，代表需要打开本地页面，并且带入相应的参数
                Uri uri = Uri.parse(message);
                String scheme = uri.getScheme();
                if (scheme.equals("js")) {
                    if (uri.getAuthority().equals("openActivity")) {
                        HashMap<String, String> params = new HashMap<>();
                        Set<String> collection = uri.getQueryParameterNames();
                        for (String name : collection) {
                            params.put(name, uri.getQueryParameter(name));
                        }
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        intent.putExtra("params", params);
                        MainActivity.this.startActivity(intent);
                        //代表应用内部处理完成
                        result.confirm("success");
                    }
                    return true;
                }
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
               return super.onJsConfirm(view, url, message, result);
            }

        });
       // JS代码调用
      /*  function clickprompt(){
            var result=prompt("js://openActivity?arg1=111&arg2=222");
            alert("open activity " + result);
        }*/

      //4.清除缓存的方法
        webView.clearCache(true);
        webView.clearHistory();
        webView.clearFormData();
    }
}
