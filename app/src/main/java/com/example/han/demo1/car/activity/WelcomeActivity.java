package com.example.han.demo1.car.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.example.han.demo1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15622 on 2017/3/8.
 * 第一步 在xml布局放置该控件
 * 第二步 在代码中通过id获取该控件
 * 第三步 获取数据源
 * 第四步 创建适配器
 * 第五步 实例化适配器
 * 第六步 关联适配器
 */

public class WelcomeActivity extends Activity {

    private static final String TAG = "WelcomeActivity";
    private ViewPager mViewPager;
    private List<View> data;
    private MyAdapter myAdapter;
    private Button button;
    private int currentItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        mViewPager= (ViewPager) findViewById(R.id.welcome_vp);
        getData();
        myAdapter=new MyAdapter();
        mViewPager.setAdapter(myAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentItem=position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            float xStart,xEnd;
            int width;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                        xEnd=motionEvent.getX();
                        WindowManager windowManager= (WindowManager) getApplication().getSystemService(Context.WINDOW_SERVICE);
                        Point point=new Point();
                        windowManager.getDefaultDisplay().getSize(point);
                        width=point.x;
                        if ((currentItem==data.size()-1)&&((xStart-xEnd)>=width/5)){
                            Intent intent=new Intent(WelcomeActivity.this,GalleryActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        break;
                    case MotionEvent.ACTION_DOWN:
                        xStart=motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void getData() {
        data=new ArrayList<>();
        View view1= LayoutInflater.from(this).inflate(R.layout.welcome_layout1,null);
        View view2= LayoutInflater.from(this).inflate(R.layout.welcome_layout2,null);
        View view3= LayoutInflater.from(this).inflate(R.layout.welcome_layout3,null);
        View view4= LayoutInflater.from(this).inflate(R.layout.welcome_layout4,null);
        button= (Button) view4.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WelcomeActivity.this,GalleryActivity.class);
                startActivity(intent);
                finish();
            }
        });
        data.add(view1);
        data.add(view2);
        data.add(view3);
        data.add(view4);
        }
    class MyAdapter extends PagerAdapter{
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(data.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(data.get(position));
            return data.get(position);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
