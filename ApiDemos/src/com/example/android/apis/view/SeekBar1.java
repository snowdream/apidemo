package com.example.android.apis.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.android.apis.R;


/**
 * 演示如何使用seek bar
 */
public class SeekBar1 extends Activity implements SeekBar.OnSeekBarChangeListener {
    
    SeekBar mSeekBar;
    TextView mProgressText;
    TextView mTrackingText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.seekbar_1);
        
        // 通过findViewById方法获得一个SeekBar对象和两个用于提示作用的TextView
        mSeekBar = (SeekBar)findViewById(R.id.seek);
        mSeekBar.setOnSeekBarChangeListener(this); //设置Seek Bar监听器
        mProgressText = (TextView)findViewById(R.id.progress);
        mTrackingText = (TextView)findViewById(R.id.tracking);
    }

    //当用户用手移动滑动条，改变进度值时，触发该响应。progress表示当前进度值。
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
        mProgressText.setText(progress + " " + 
                getString(R.string.seekbar_from_touch) + "=" + fromTouch); 
    }

    //用户开始对SeekBar进行触屏操作时触发响应
    public void onStartTrackingTouch(SeekBar seekBar) {
        mTrackingText.setText(getString(R.string.seekbar_tracking_on));
    }

    //用户停止对SeekBar进行触屏操作时触发响应
    public void onStopTrackingTouch(SeekBar seekBar) {
        mTrackingText.setText(getString(R.string.seekbar_tracking_off));
    }
}
