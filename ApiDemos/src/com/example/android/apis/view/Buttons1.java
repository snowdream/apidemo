package com.example.android.apis.view;


import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;



public class Buttons1 extends Activity {
    //声明ToggleButton对象  
	private ToggleButton mtoggleBtn = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons_1);
              
        //通过findViewById获得ToggleButton  
        mtoggleBtn = (ToggleButton)findViewById(R.id.button_toggle);
        
        //点击监听
        mtoggleBtn.setOnClickListener(new ToggleButton.OnClickListener() {
			
			public void onClick(View v) {
				// TODO 点击按键时触发响应
				if(mtoggleBtn.isChecked()){
					//当按键被按下，处于选中状态时，执行此处定义的动作
				}
				else{
					//当按键被未被按下，处于未选中状态时，执行此处定义的动作
				}
			}
		});
        
        //状态改变监听
        mtoggleBtn.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO 状态改变时触发响应
				if(isChecked){
					//当按键被按下，处于选中状态时，执行此处定义的动作
				}
				else{
					//当按键被未被按下，处于未选中状态时，执行此处定义的动作
				}				
			}
        });
    }
}
