package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * 演示如何使用 TextSwitcher 控件
 */
public class TextSwitcher1 extends Activity implements ViewSwitcher.ViewFactory,
        View.OnClickListener {

    private TextSwitcher mSwitcher;

    private int mCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.text_switcher_1);
        
        // 通过findViewById获得一个TextSwitcher对象
        mSwitcher = (TextSwitcher) findViewById(R.id.switcher);
        mSwitcher.setFactory(this);

        //加载并设置TextSwitcher的淡入淡出动画
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);

        // 通过findViewById获得一个Button对象，并设置监听器
        Button nextButton = (Button) findViewById(R.id.next);
        nextButton.setOnClickListener(this);

        updateCounter();
    }

    //Button的监听器实现代码。
    //每次点击按钮，mCounter就会加上1，并且刷新界面
    public void onClick(View v) {
        mCounter++;
        updateCounter();
    }

    //每次调用TextSwitcher的setText方法，都会刷新界面。
    //用淡出动画效果隐藏旧的TextView,接着用淡入效果加载新的TextView
    private void updateCounter() {
        mSwitcher.setText(String.valueOf(mCounter));
    }

    //每次调用TextSwitcher的setText方法，UI主线程会调用该函数来生成一个TextView,用于显示文字。
    //这里可以加上自定义属性来自定义TextView。例如，我设置了文字的颜色为蓝色。
    public View makeView() {
        TextView t = new TextView(this);
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        t.setTextColor(Color.BLUE);
        t.setTextSize(36);
        return t;
    }
}
