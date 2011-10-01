package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.view.View;

import java.util.Calendar;

public class DateWidgets1 extends Activity {

	// 日期和时间显示区域
	private TextView mDateDisplay;

	// 日期和时间相关定义数据
	private int mYear;
	private int mMonth;
	private int mDay;
	private int mHour;
	private int mMinute;

	// 对话框标示，用于创建对话框时进行区分
	static final int TIME_DIALOG_ID = 0;
	static final int DATE_DIALOG_ID = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.date_widgets_example_1);

		// 通过findViewById方法获得一个TextView对象
		mDateDisplay = (TextView) findViewById(R.id.dateDisplay);

		// 通过findViewById方法获得一个Button对象：pickDate，并设置监听器。
		Button pickDate = (Button) findViewById(R.id.pickDate);
		pickDate.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID); // 点击按钮时，触发响应，创建或者显示日期选择对话框
			}
		});

		// 通过findViewById方法获得一个Button对象：pickTime，并设置监听器。
		Button pickTime = (Button) findViewById(R.id.pickTime);
		pickTime.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				showDialog(TIME_DIALOG_ID); // 点击按钮时，触发响应，创建或者显示时间选择对话框
			}
		});

		// 通过java类Calendar获得系统当前时间数据信息，并更新显示在TextView上
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		mHour = c.get(Calendar.HOUR_OF_DAY);
		mMinute = c.get(Calendar.MINUTE);
		updateDisplay();
	}

	// 根据对话框标识创建对话框
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			// 创建时间选择对话框 最后一个参数is24HourView，如果是true，则为24小时制，否则，则为12小时制。
			return new TimePickerDialog(this, mTimeSetListener, mHour, mMinute,
					true);
		case DATE_DIALOG_ID:
			// 创建日期选择对话框
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
					mDay);
		}
		return null;
	}

	// 根据对话框标识更新对话框
	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case TIME_DIALOG_ID:
			// 更新时间选择对话框信息
			((TimePickerDialog) dialog).updateTime(mHour, mMinute);
			break;
		case DATE_DIALOG_ID:
			// 更新日期选择对话框信息
			((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);
			break;
		}
	}

	// 更新日期和时间显示区的信息
	private void updateDisplay() {
		mDateDisplay.setText(new StringBuilder()
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

	// 日期设置监听器，当改变日期时，更新时间显示信息
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateSystemTime();
			updateDisplay();
		}
	};

	// 时间设置监听器，当改变时间时，更新时间显示信息
	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			mHour = hourOfDay;
			mMinute = minute;
			updateSystemTime();
			updateDisplay();
		}
	};

	// 当小时或者分钟为个位数字时，前面加一个0
	private static String pad(int c) {
		if (c >= 10)
			return String.valueOf(c);
		else
			return "0" + String.valueOf(c);
	}
}
