package com.example.android.apis.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.android.apis.R;


public class ScrollBar3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.scrollbar3);
        
        // 通过findViewById方法获得一个id为view3的ScrollView控件，并设置滚动条类型为 View.SCROLLBARS_INSIDE_INSET 
        findViewById(R.id.view3).setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
    }
}
