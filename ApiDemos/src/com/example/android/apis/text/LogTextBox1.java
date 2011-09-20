package com.example.android.apis.text;

import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LogTextBox1 extends Activity {
    
    private LogTextBox mText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.log_text_box_1);
        
        mText = (LogTextBox) findViewById(R.id.text);
        
        //对Button的监听方法一：设置监听器
        Button addButton = (Button) findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mText.append("This is a test\n");
            } });
        
        
    }
    
    //对Button的监听方法二：自定义监听方法，需要设置android:onClick属性
    //这个方法必须是Public类型的，并且只能接受view作为唯一参数 
    public void selfDestruct(View view) {
        mText.append("This is a test\n");
    }
}
