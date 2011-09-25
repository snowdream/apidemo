package com.example.android.apis.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;


import com.example.android.apis.R;


public class ImageButton1 extends Activity {
    private ImageButton mImageButton = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_button_1);
  
        //通过findViewById获得ImageButton          
        mImageButton = (ImageButton)findViewById(R.id.myImageButton01);
        
        //引用android内置图标，作为ImageButton的按钮图标 
        mImageButton.setImageResource(android.R.drawable.sym_action_call);
        
    }
}
