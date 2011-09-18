package com.example.android.apis.text;

import com.example.android.apis.R;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

public class Link extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //super.onCreate(savedInstanceState)是调用父类的onCreate构造函数
    	//savedInstanceState是保存当前Activity的状态信息
    	super.onCreate(savedInstanceState);

        //将link布局文件渲染出一个View对象，并作为Activity的默认View
        setContentView(R.layout.link);

        // text1 通过 android:autoLink 属性自动识别文本中的链接，例如URL网络地址和电话号码等。
         // 不需要任何java代码来使之起作用。

        // text2 含有由<a>等HTML标记指定的文本链接。默认情况下，这些链接可以显示但不会响应用户输入。
        //要想这些链接响应用户的点击输入，你需要调用TextView的setMovementMethod()方法 。
        
        TextView t2 = (TextView) findViewById(R.id.text2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

        // text3 显示在java代码中通过HTML类来创建包含文本链接的文本，而不是从文本资源中创建。
        //请注意，对于一个固定长度文本，最好像上面的例子一样，从文本资源中创建。
        // 这个例子仅仅说明您怎样去显示来自动态来源（例如，网络）的文本。

        TextView t3 = (TextView) findViewById(R.id.text3);
        t3.setText(
            Html.fromHtml(
                "<b>text3:</b>  Text with a " +
                "<a href=\"http://www.google.com\">link</a> " +
                "created in the Java source code using HTML."));
        t3.setMovementMethod(LinkMovementMethod.getInstance());

        // text4 举例说明完全不通过HTML标记来构建一个包含链接的格式化文本。
        // 对于固定长度的文本，你最好使用string资源文本（即在string.xml中指定），而不是硬编码值（即在java代码中指定）。

        //构建一个SpannableString
        SpannableString ss = new SpannableString(
            "text4: Click here to dial the phone.");

        //设置粗体
        ss.setSpan(new StyleSpan(Typeface.BOLD), 0, 6,
                   Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置电话号码的链接
        ss.setSpan(new URLSpan("tel:4155551212"), 13, 17,
                   Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView t4 = (TextView) findViewById(R.id.text4);
        t4.setText(ss);
        t4.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
