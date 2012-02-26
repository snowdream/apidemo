package com.example.android.apis.view;

/**
 * 演示如何使用下拉列表控件Spinner
 */
import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


public class Spinner1 extends Activity {

    // 调用Toast控件来显示消息msg，用来提示用户
   void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_1);

        // 通过findViewById方法获得一个Spinner对象s1，下同
        Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        
        //根据颜色数组R.array.colors创建一个数组适配器
        //第二个参数 R.array.colors 为数组适配器数据源
        //第三个参数 是下拉列表中每个数据所占据的 View 的样式 。这里采用系统默认样式 android.R.layout.simple_spinner_item 
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.colors, android.R.layout.simple_spinner_item);
        
        //设置适配器下拉样式，这里是系统默认样式 android.R.layout.simple_spinner_dropdown_item
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        //将 Spinner 控件绑定适配器 adapter
        s1.setAdapter(adapter);
        
        //设置监听器。当用户选择其中一个选项时，触发响应。
        s1.setOnItemSelectedListener(
        		//选择其中一个选项时，触发该响应
        		//parent:装载数据的视图列表
        		//view:列表中当前选中的item视图
        		//position:选中的item在AdapterView中的索引
        		//id:选中的item视图控件的id值
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        showToast("Spinner1: position=" + position + " id=" + id);
                    }

                    //什么选项都没选择时，触发该响应
                    public void onNothingSelected(AdapterView<?> parent) {
                        showToast("Spinner1: unselected");
                    }
                });

        // 通过findViewById方法获得一个Spinner对象s2
        Spinner s2 = (Spinner) findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(this, R.array.planets,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter);
        s2.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        showToast("Spinner2: position=" + position + " id=" + id);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        showToast("Spinner2: unselected");
                    }
                });
    }
}
