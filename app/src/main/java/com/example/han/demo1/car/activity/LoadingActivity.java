package com.example.han.demo1.car.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.han.demo1.R;

/**
 * Created by 15622 on 2017/3/13.
 */

public class LoadingActivity extends Activity {
    private Handler handler;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);
        preferences=getSharedPreferences("user",MODE_PRIVATE);
//        SharedPreferences.Editor editor=preferences.edit();
//        editor.putInt("isFirst",1);
//        editor.commit();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isFirst=preferences.getBoolean("isFirst",true);
                if(isFirst){
                    Intent intent=new Intent(LoadingActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putBoolean("isFirst",false);
                    editor.commit();
                }else {
                    Intent intent=new Intent(LoadingActivity.this,GalleryActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        },2000);
    }
}
