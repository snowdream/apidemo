package com.example.android.apis.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.apis.R;

/**
 * 演示如何使用rating bar
 */
public class RatingBar1 extends Activity implements RatingBar.OnRatingBarChangeListener {
    RatingBar mSmallRatingBar;
    RatingBar mIndicatorRatingBar;
    TextView mRatingText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ratingbar_1);

         // 通过findViewById方法获得一个TextView对象
        mRatingText = (TextView) findViewById(R.id.rating);

        // 通过findViewById方法获得两个用作指示牌的RatingBar对象
        mIndicatorRatingBar = (RatingBar) findViewById(R.id.indicator_ratingbar);
        mSmallRatingBar = (RatingBar) findViewById(R.id.small_ratingbar);

        // 通过findViewById方法获得两个可以交互的RatingBar对象，并设置监听器
        ((RatingBar)findViewById(R.id.ratingbar1)).setOnRatingBarChangeListener(this);
        ((RatingBar)findViewById(R.id.ratingbar2)).setOnRatingBarChangeListener(this);
    }

    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromTouch) {
        final int numStars = ratingBar.getNumStars();
         //显示当前星星总数多少，被选中高亮的星星数多少
        mRatingText.setText( 
                getString(R.string.ratingbar_rating) + " " + rating + "/" + numStars);

         //当用户点击上面可以交互的RatingBar，触发监听器，在这里更新两个作为指示牌作用的RatingBar对象的三个参数
        //更新两个作为指示牌作用的RatingBar对象的星星总数
        if (mIndicatorRatingBar.getNumStars() != numStars) {
            mIndicatorRatingBar.setNumStars(numStars);
            mSmallRatingBar.setNumStars(numStars);
        }
        
        //更新两个作为指示牌作用的RatingBar对象的星星数（被选中高亮）
        if (mIndicatorRatingBar.getRating() != rating) {
            mIndicatorRatingBar.setRating(rating);
            mSmallRatingBar.setRating(rating);
        }
        
        //更新两个作为指示牌作用的RatingBar对象的步长值
        final float ratingBarStepSize = ratingBar.getStepSize();
        if (mIndicatorRatingBar.getStepSize() != ratingBarStepSize) {
            mIndicatorRatingBar.setStepSize(ratingBarStepSize);
            mSmallRatingBar.setStepSize(ratingBarStepSize);
        }
    }

}
