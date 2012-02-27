package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Uses a TextSwitcher.
 */
public class TextSwitcher1 extends Activity implements ViewSwitcher.ViewFactory,
        View.OnClickListener {

    private TextSwitcher mSwitcher;

    private int mCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.text_switcher_1);

        mSwitcher = (TextSwitcher) findViewById(R.id.switcher);
        mSwitcher.setFactory(this);

        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);

        Button nextButton = (Button) findViewById(R.id.next);
        nextButton.setOnClickListener(this);

        updateCounter();
    }

    public void onClick(View v) {
        mCounter++;
        updateCounter();
    }

    private void updateCounter() {
        mSwitcher.setText(String.valueOf(mCounter));
    }

    public View makeView() {
        TextView t = new TextView(this);
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        t.setTextSize(36);
        return t;
    }
}
