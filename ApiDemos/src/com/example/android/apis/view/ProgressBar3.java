package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 演示如何使用进度对话框
 */
public class ProgressBar3 extends Activity {

    ProgressDialog mDialog1;
    ProgressDialog mDialog2;

    private static final int DIALOG1_KEY = 0;
    private static final int DIALOG2_KEY = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.progressbar_3);

        Button button = (Button) findViewById(R.id.showIndeterminate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG1_KEY); //显示带有标题的进度对话框
            }
        });

        button = (Button) findViewById(R.id.showIndeterminateNoTitle);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG2_KEY); //显示不带标题的进度对话框
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG1_KEY: {           	  
                ProgressDialog dialog = new ProgressDialog(this);  //创建ProgressDialog
                dialog.setTitle("Indeterminate"); //设置标题
                dialog.setMessage("Please wait while loading..."); //设置主题信息
                dialog.setIndeterminate(true);  //设置进度条为不明确进度的类型（环形）
                dialog.setCancelable(true);  //设置窗口可以通过退回键取消
                return dialog;
            }
            case DIALOG2_KEY: {
                ProgressDialog dialog = new ProgressDialog(this); //创建ProgressDialog
                dialog.setMessage("Please wait while loading...");  //设置主题信息
                dialog.setIndeterminate(true);  //设置进度条为不明确进度的类型（环形）
                dialog.setCancelable(true); //设置窗口可以通过退回键取消
                return dialog;
            }
        }
        return null;
    }
}
