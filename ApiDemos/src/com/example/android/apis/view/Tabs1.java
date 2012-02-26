package com.example.android.apis.view;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.view.LayoutInflater;
import com.example.android.apis.R;

/**
 *  演示如何使用TabHost
 *
 */
public class Tabs1 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //获取TabActivity内置的TabHost对象
        TabHost tabHost = getTabHost();
        
        //将样式R.layout.tabs1解压出来，并应用于TabHost对象
        LayoutInflater.from(this).inflate(R.layout.tabs1, tabHost.getTabContentView(), true);

        //新建选项卡
        //tabHost.newTabSpec("tab1")  新建一个以“tab1”为标记的选项卡
        //setIndicator("tab1")    设置选项卡标签标题为 tab1
        //setContent(R.id.view1)) 设置选项卡内容为 R.id.view1
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("tab1")
                .setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("tab2")
                .setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("tab3")
                .setContent(R.id.view3));
    }
}
