package com.example.android.apis.view;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.DatePicker;

import com.example.android.apis.R;

public class DateWidgets2 extends Activity {

	// 日期和时间显示区域
	private TextView mTimeDisplay;

	// 日期和时间相关定义数据
	private int mYear;
	private int mMonth;
	private int mDay;
	private int mHour;
	private int mMinute;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.date_widgets_example_2);

		// 通过findViewById方法获得一个TextView对象，用作日期和时间显示区      
		mTimeDisplay = (TextView) findViewById(R.id.dateDisplay);

		// 通过java类Calendar获得系统当前时间数据信息，并更新显示在TextView上
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		mHour = c.get(Calendar.HOUR_OF_DAY);
		mMinute = c.get(Calendar.MINUTE);
		updateDisplay();

		// 通过findViewById方法获得一个DatePicker对象
		DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
		datePicker.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener(){

			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				mYear = year;
				mMonth = monthOfYear;
				mDay = dayOfMonth;
				updateSystemTime();
				updateDisplay();				
			}       
		});

		// 通过findViewById方法获得一个TimePicker对象
		TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
		timePicker.setIs24HourView(true); //参数is24HourView，如果是true，则为24小时制，否则，则为12小时制。
		timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				mHour = hourOfDay;
				mMinute = minute;
				updateSystemTime();
				updateDisplay();
			}
		});

	}

	// 更新日期和时间显示区的信息
	private void updateDisplay() {
		mTimeDisplay.setText(new StringBuilder()
		// 由于月份是按照从0到11进行计算，因此显示的时候加上1，进行转换。
		.append(mMonth + 1).append("-").append(mDay).append("-")
		.append(mYear).append(" ").append(pad(mHour)).append(":")
		.append(pad(mMinute)));
	}

	// 理论上可以修改系统时间，但由于系统限制，缺乏root权限，实际上这个函数并不能真正去修改系统时间。
	private void updateSystemTime() {
		final Calendar c = Calendar.getInstance();
		// 由于月份是按照从0到11进行计算，因此设置的时候减去1，进行转换。
		c.set(mYear, mMonth - 1, mDay, mHour, mMinute);
	}

	// 当小时或者分钟为个位数字时，前面加一个0	
	private static String pad(int c) {
		if (c >= 10)
			return String.valueOf(c);
		else
			return "0" + String.valueOf(c);
	}

}
