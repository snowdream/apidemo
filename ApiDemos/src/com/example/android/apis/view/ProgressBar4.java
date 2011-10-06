package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.View;
import android.widget.Button;


/**
 * 演示如何在标题栏中使用不确定进度值的进度条
 */
public class ProgressBar4 extends Activity {
    private boolean mToggleIndeterminate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 请求在标题栏中显示不确定进度类型的进度条
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.progressbar_4);
        
        // 设置标题栏中的进度条是否可见
        setProgressBarIndeterminateVisibility(mToggleIndeterminate);
        
        //点击一次，改变一次mToggleIndeterminate值
        Button button = (Button) findViewById(R.id.toggle);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                mToggleIndeterminate = !mToggleIndeterminate;
                setProgressBarIndeterminateVisibility(mToggleIndeterminate);
            }
        });
    }
}
