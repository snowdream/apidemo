package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


/**
 * 演示如何在窗口标题栏中使用进度条。
 * 进度条将会一直显示，直到进度完成，此时进度条消失。
 */
public class ProgressBar1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 请求在标题栏中显示进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.progressbar_1);
        
        //设置标题栏中的进度条可见
        setProgressBarVisibility(true);
        
        // 通过findViewById方法获得一个ProgressBar对象
        final ProgressBar progressHorizontal = (ProgressBar) findViewById(R.id.progress_horizontal);
        
         //获取ProgressBar对象（取值范围0~100）的主要进度值和第二进度值，经过转换后设置到标题栏中的ProgressBar对象（取值范围0~10000）。
        setProgress(progressHorizontal.getProgress() * 100);
        setSecondaryProgress(progressHorizontal.getSecondaryProgress() * 100);
        
        //该按钮用于增大ProgressBar的主要进度值，步进值为1
        Button button = (Button) findViewById(R.id.increase);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            	 //progressHorizontal主要进度值加1
                progressHorizontal.incrementProgressBy(1);
                
                //标题栏中的进度条取值范围0~10000，而progressHorizontal取值范围0~100，因此，获取progressHorizontal进度值，乘以100，设置成标题栏上进度条的进度值。下同。
                setProgress(100 * progressHorizontal.getProgress());
            }
        });

        //该按钮用于减小ProgressBar的主要进度值，步进值为1
        button = (Button) findViewById(R.id.decrease);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
           	 //progressHorizontal主要进度值减1
               progressHorizontal.incrementProgressBy(-1);

               setProgress(100 * progressHorizontal.getProgress());
            }
        });

        //该按钮用于增大ProgressBar的第二进度值，步进值为1
        button = (Button) findViewById(R.id.increase_secondary);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //progressHorizontal第二进度值加1
                progressHorizontal.incrementSecondaryProgressBy(1);
                
                  //标题栏中的进度条取值范围0~10000，而progressHorizontal取值范围0~100，因此，获取progressHorizontal第二进度值，乘以100，设置成标题栏上进度条的第二进度值。下同。
                setSecondaryProgress(100 * progressHorizontal.getSecondaryProgress());
            }
        });

        //该按钮用于减小ProgressBar的第二进度值，步进值为1
        button = (Button) findViewById(R.id.decrease_secondary);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //progressHorizontal第二进度值减1
                progressHorizontal.incrementSecondaryProgressBy(-1);

                setSecondaryProgress(100 * progressHorizontal.getSecondaryProgress());
            }
        });
        
    }
}
