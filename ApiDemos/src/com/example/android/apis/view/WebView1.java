package com.example.android.apis.view;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.android.apis.R;


/**
 *<pre>WebView组件(mWebView)有一个辅助类叫WebSettings，它管理WebView的设置状态。
 *该对象可以通过WebView.getSettings()方法获得。

 *得到WebSettings对象，设置支持Javascript的参数
 *mWebView.getSettings().setJavaScriptEnabled(true);

 *设置可以支持缩放
 *mWebView.getSettings().setSupportZoom(true);

 *设置默认缩放方式尺寸是far
 *mWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);

 *设置允许访问文件数据
 *mWebView.getSettings().setAllowFileAccess(true);
 
 *设置是否保存密码
 *mWebView.getSettings().setSavePassword(true);
  
 *设置网页默认编码
 *mWebView.getSettings().setDefaultTextEncodingName(encoding);
 
 *设置出现缩放工具
 *mWebView.getSettings().setBuiltInZoomControls(true);</pre>
 * 
 */
public class WebView1 extends Activity {
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        setContentView(R.layout.webview_1);
        
        final String mimeType = "text/html";   // image/jpeg  etc
        final String encoding = "utf-8";   //base64  etc

        WebView wv = null;
        String baseUrl = null;
        String data = null;

        //加载在线网页
        wv = (WebView) findViewById(R.id.wv1);
        wv.requestFocus(); //请求焦点
        wv.getSettings().setJavaScriptEnabled(true); //设置是否支持JavaScript
        wv.getSettings().setSupportZoom(true); //设置是否支持缩放
        wv.getSettings().setBuiltInZoomControls(true); //设置是否显示内建缩放工具
        wv.getSettings().setSavePassword(true); //设置是否保存密码
        wv.loadUrl("http://www.baidu.com/");
        
        //加载在线图片       
        wv = (WebView) findViewById(R.id.wv2);
        wv.requestFocus();        
        wv.loadUrl("http://www.google.com/logos/2011/Googles_13th_Birthday-2011-hp.jpg");
     
        //加载本地网页(SD卡根目录下)
        wv = (WebView) findViewById(R.id.wv3);
        wv.requestFocus();                
        wv.loadUrl("file:///mnt/sdcard/Google.html");
    
        //加载本地图片(SD卡根目录下)
        wv = (WebView) findViewById(R.id.wv4);
        wv.requestFocus();                
        wv.loadUrl("file:///mnt/sdcard/Googles_13th_Birthday-2011-hp.jpg");

        //加载在线网页失败，把网页地址当作字符串处理
        wv = (WebView) findViewById(R.id.wv5);
        data = "http://www.baidu.com/";
        wv.requestFocus();                
        wv.loadData(data, mimeType, encoding);
       
        //加载在线图片失败，只显示一个默认图片进行替换               
        wv = (WebView) findViewById(R.id.wv6);
        data = "http://www.google.com/logos/2011/Googles_13th_Birthday-2011-hp.jpg"; 
        wv.requestFocus();                
        wv.loadData(data, mimeType, encoding);

        //加载本地网页Html代码，可以显示超级链接。点击，调用外部浏览器打开该链接。
        wv = (WebView) findViewById(R.id.wv7);
        data = "<a href ='http://www.baidu.com/'>百度</a>";
        wv.requestFocus();
        wv.getSettings().setDefaultTextEncodingName(encoding);  //对于data中含有中文字符的，必须加上这个设置，否则会乱码。
        wv.loadData(data, mimeType, encoding);
   
        //加载本地图片(SD卡根目录下)
        wv = (WebView) findViewById(R.id.wv8);
        data = "loadData方法加载本地图片<img src ='file:///mnt/sdcard/Googles_13th_Birthday-2011-hp.jpg' />";
        wv.requestFocus();       
        wv.getSettings().setDefaultTextEncodingName(encoding); //对于data中含有中文字符的，必须加上这个设置，否则会乱码。
        wv.loadData(data, mimeType, encoding);
        
        //loadDataWithBaseURL方法：加载本地网页Html代码(SD卡根目录下)，可以显示超级链接。点击直接显示本地网页内容。
        wv = (WebView) findViewById(R.id.wv9);
        baseUrl = "file:///mnt/sdcard/";   //网页基础目录
        data = "<a href='Google.html'>谷歌</a>";  //相对路径，相对基础目录而言
        wv.requestFocus();                
        wv.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, null);
        
        //loadDataWithBaseURL方法：加载本地图片(SD卡根目录下)，默认直接显示该图片
        wv = (WebView) findViewById(R.id.wv10);
        baseUrl = "file:///mnt/sdcard/";  //网页基础目录
        data = "<img src ='Googles_13th_Birthday-2011-hp.jpg' />";  //相对路径，相对基础目录而言
        wv.requestFocus();                
        wv.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, null);         
    }
}
