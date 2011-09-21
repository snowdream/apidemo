package com.example.android.apis.text;

import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;

public class Marquee extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //将marquee布局文件渲染出一个View对象，并作为Activity的默认View
        setContentView(R.layout.marquee);
    }
}
