package com.example.han.demo1.car.myapplication;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 15622 on 2017/3/14.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
