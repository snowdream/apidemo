package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.LinearLayout;


public class RadioGroup1 extends Activity implements RadioGroup.OnCheckedChangeListener,
        View.OnClickListener {

    private TextView mChoice;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.radio_group_1);

        // 通过findViewById方法获得一个RadioGroup对象        
        mRadioGroup = (RadioGroup) findViewById(R.id.menu);

        // 向RadioGroup中动态添加一个RadioButton对象
        RadioButton newRadioButton = new RadioButton(this);
        newRadioButton.setText(R.string.radio_group_snack);
        newRadioButton.setId(R.id.snack);
        LinearLayout.LayoutParams layoutParams = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT);
        mRadioGroup.addView(newRadioButton, 0, layoutParams);

        //为RadioGroup添加监听器，当点击RadioButton时，会触发监听器， 执行onCheckedChanged中的动作
        mRadioGroup.setOnCheckedChangeListener(this);
        
        //在TextView控件上显示被选择项的提示信息
        String selection = getString(R.string.radio_group_selection);
        mChoice = (TextView) findViewById(R.id.choice);
        mChoice.setText(selection + mRadioGroup.getCheckedRadioButtonId());

        // 通过findViewById方法获得一个Button对象，点击该对象会清除RadioGroup中的选择项
        Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(this);
    }

    //当RadioButton状态发生改变时，触发监听器，执行下面的动作。当清除选择项时,checkedId为-1。
    public void onCheckedChanged(RadioGroup group, int checkedId) {
    	String selection = getString(R.string.radio_group_selection);
    	String none = getString(R.string.radio_group_none);
    	String choice = null;
    	//根据checkedId判断用户选择了哪一个选项，并执行相应的动作。
    	switch (checkedId) {
    	case R.id.breakfast: 
    		choice = "breakfast";
    		break;
    	case R.id.lunch:
    		choice = "lunch";
    		break;
    	case R.id.dinner:
    		choice = "dinner";
    		break;
    	case R.id.all:
    		choice = "all";
    		break;		
    	case R.id.snack:
    		choice = "snack";
    		break;	   		
    	default:
    		break;
    	}
    	mChoice.setText(selection + choice +
    			(checkedId == View.NO_ID ? none : checkedId));       
    }

    //点击clearButton时，清空所有RadioButton的选择状态
    public void onClick(View v) {
        mRadioGroup.clearCheck();
    }
}
