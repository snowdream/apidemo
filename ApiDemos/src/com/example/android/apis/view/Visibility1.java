package com.example.android.apis.view;


import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 *  设置一个View对象可见，不可见，彻底消失的实例演示
 *
 */
public class Visibility1 extends Activity {

    private View mVictim = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visibility_1);

        // 通过findViewById获得一个待改变可见性的View对象
        mVictim = findViewById(R.id.victim);

        // 通过findViewById获得三个Button对象
        Button visibleButton = (Button) findViewById(R.id.vis);
        Button invisibleButton = (Button) findViewById(R.id.invis);
        Button goneButton = (Button) findViewById(R.id.gone);

        // 给每个Button添加点击监听器
        visibleButton.setOnClickListener(mVisibleListener);
        invisibleButton.setOnClickListener(mInvisibleListener);
        goneButton.setOnClickListener(mGoneListener);
    }


    OnClickListener mVisibleListener = new OnClickListener() {
        public void onClick(View v) {
        	  //设置mVictim可见
            mVictim.setVisibility(View.VISIBLE);
        }
    };

    OnClickListener mInvisibleListener = new OnClickListener() {
        public void onClick(View v) {
      	  	//设置mVictim不可见       	
            mVictim.setVisibility(View.INVISIBLE);
        }
    };

    OnClickListener mGoneListener = new OnClickListener() {
        public void onClick(View v) {
      	  	//设置mVictim彻底隐藏      	        	
            mVictim.setVisibility(View.GONE);
        }
    };
}
