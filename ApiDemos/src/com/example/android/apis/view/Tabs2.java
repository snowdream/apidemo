package com.example.android.apis.view;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;
import android.view.View;
import com.example.android.apis.R;

/**
 *  演示如何使用TabHost
 *
 */
public class Tabs2 extends TabActivity implements TabHost.TabContentFactory {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //获取TabActivity内置的TabHost对象
        final TabHost tabHost = getTabHost();
        
        //新建选项卡
        //tabHost.newTabSpec("tab1")  新建一个以“tab1”为标记的选项卡
        //setIndicator("tab1")    设置选项卡标签标题为 tab1 ，图标为 getResources().getDrawable(R.drawable.star_big_on)
        //setContent(this))   由于该TabActivity继承了 TabHost.TabContentFactory 接口，因此，点击选项卡标签时，会调用
        // public View createTabContent(String tag)来创建每个选项卡内容。该函数中的参数tag和newTabSpec中的参数是一样的。
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("tab1", getResources().getDrawable(R.drawable.star_big_on))
                .setContent(this));
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("tab2")
                .setContent(this));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("tab3")
                .setContent(this));
    }

    
    //每次点击选项卡标签时，根据选项卡tag标记来创建具体内容。
    /** {@inheritDoc} */
    public View createTabContent(String tag) {
        final TextView tv = new TextView(this);
        tv.setText("Content for tab with tag " + tag);
        return tv;
    }
}
