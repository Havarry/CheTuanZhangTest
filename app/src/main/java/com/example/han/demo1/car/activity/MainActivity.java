package com.example.han.demo1.car.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.han.demo1.R;
import com.example.han.demo1.car.fragments.HomeFragment;
import com.example.han.demo1.car.fragments.ShequFragment;
import com.example.han.demo1.car.fragments.WodeFragment;
import com.example.han.demo1.car.fragments.ZixunFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
@ContentView(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    private HomeFragment shouyeFragment;
    private ShequFragment  shequFragment;
    private WodeFragment wodeFragment;
    private ZixunFragment zixunFragment;
    private RadioGroup radioGroup;
    private RadioButton btn_shouye,btn_shequ,btn_zixun,btn_wode;
    private List<Fragment> mData;
    private ViewPager mViewPager;
    private MyFragmentAdapter myFragmentAdapter;
//    private FragmentManager fragmentManager;
//    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
//        setContentView(R.layout.activity_main);
        shouyeFragment=new HomeFragment();
        shequFragment=new ShequFragment();
        wodeFragment=new WodeFragment();
        zixunFragment=new ZixunFragment();
        radioGroup= (RadioGroup) findViewById(R.id.radio_group);
        btn_shouye= (RadioButton) findViewById(R.id.shouye);
        btn_shequ= (RadioButton) findViewById(R.id.shequ);
        btn_wode= (RadioButton) findViewById(R.id.wode);
        btn_zixun= (RadioButton) findViewById(R.id.rb_zixun);
        mViewPager= (ViewPager) findViewById(R.id.main_vp);
        getData();
        myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentAdapter);
        //ViewPager滚动监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        btn_shouye.setChecked(true);
                        break;
                    case 1:
                        btn_zixun.setChecked(true);
                        break;
                    case 2:
                        btn_wode.setChecked(true);
                        break;
                    case 3:
                        btn_shequ.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//给单选按钮添加监听器
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.shouye:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_zixun:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.wode:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.shequ:
                        mViewPager.setCurrentItem(3);
                        break;
                }
            }
        });

       // initView();
       // radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
       //     @Override
       //     public void onCheckedChanged(RadioGroup radioGroup, int i) {

                //注：每次使用Transaction事务后需要重新调用beginTransaction方法获取Transaction

        //        fragmentTransaction=fragmentManager.beginTransaction();
        //        switch (i){
        //            case R.id.shouye:
        //               fragmentTransaction.replace(R.id.frag,shouyeFragment);
        //                break;
        //           case R.id.shequ:
        //                fragmentTransaction.replace(R.id.frag,shequFragment);
        //               break;
        //           case R.id.rb_zixun:
        //                fragmentTransaction.replace(R.id.frag,zixunFragment);
        //                 break;
        //            case R.id.wode:
        //                fragmentTransaction.replace(R.id.frag,wodeFragment);
        //               break;
        //       }
        //        fragmentTransaction.commit();
        //    }
        // });
        //}

        //private void initView() {
        // fragmentManager=getSupportFragmentManager();
        //fragmentTransaction=fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.frag,shouyeFragment);
        //fragmentTransaction.commit();
    }

    private void getData() {
        mData=new ArrayList<>();
        mData.add(shouyeFragment);
        mData.add(zixunFragment);
        mData.add(wodeFragment);
        mData.add(shequFragment);
    }
    class MyFragmentAdapter extends FragmentPagerAdapter{

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }
}
