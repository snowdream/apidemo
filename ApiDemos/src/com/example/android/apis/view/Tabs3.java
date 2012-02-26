package com.example.android.apis.view;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.content.Intent;

/**
 *  演示如何使用TabHost
 *
 */
public class Tabs3 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取TabActivity内置的TabHost对象
        final TabHost tabHost = getTabHost();

        //新建选项卡
        //tabHost.newTabSpec("tab1")  新建一个以“tab1”为标记的选项卡
        //setIndicator("tab1")    设置选项卡标签标题为 list
        //setContent(new Intent(this, List1.class)))  点击该选项卡时，通过Intent，跳转到List1界面
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("list")
                .setContent(new Intent(this, List1.class)));

        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("photo list")
                .setContent(new Intent(this, List8.class)));
        
        // 这个选项卡设置 Intent.FLAG_ACTIVITY_CLEAR_TOP 标记，是为了 每次点击该选项卡时，重新创建选项卡内容。
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("destroy")
                .setContent(new Intent(this, Controls2.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
    }
}
