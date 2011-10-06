package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


/**
 * 演示如何在窗口标题栏中使用不确定进度的进度条。
 * 本实例演示了3中不同大小的环形进度条，
 */
public class ProgressBar2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 请求在标题栏中显示不确定进度类型的进度条
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        
        setContentView(R.layout.progressbar_2);

        // 设置标题栏中的进度条可见
        setProgressBarIndeterminateVisibility(true);
    }
}
