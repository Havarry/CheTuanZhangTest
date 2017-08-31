package com.example.han.demo1.car.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.han.demo1.car.util.DensityUtil;

import at.technikum.mti.fancycoverflow.FancyCoverFlow;

/**
 * Created by 15622 on 2017/3/13.
 */

public class MyFancyCoverFlow extends FancyCoverFlow {
    private int FLING_THRESHOLD;
    private int FLING_MOVE_THRESHOLD;
    public MyFancyCoverFlow(Context context) {
        super(context);
    }

    public MyFancyCoverFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFancyCoverFlow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float rateX = 1.2f*velocityX;
        if (FLING_THRESHOLD == 0) {
            FLING_THRESHOLD = DensityUtil.dip2px(getContext(),900);
        }
        if (rateX>FLING_THRESHOLD)
            rateX = FLING_THRESHOLD;

        if (rateX < -FLING_THRESHOLD)
            rateX = -FLING_THRESHOLD;
        return super.onFling(e1, e2, rateX, velocityY);
    }
}
