package com.example.han.demo1.car.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.han.demo1.R;
import com.example.han.demo1.car.ui.MyFancyCoverFlow;

import at.technikum.mti.fancycoverflow.FancyCoverFlow;
import at.technikum.mti.fancycoverflow.FancyCoverFlowAdapter;

/**
 * Created by 15622 on 2017/3/13.
 */

public class GalleryActivity extends Activity {
    private MyFancyCoverFlow myFancyCoverFlow;
    private int[] imageId = {R.drawable.welcome_buy, R.drawable.welcome_change, R.drawable.welcome_guang, R.drawable.welcome_insurance, R.drawable.welcome_maintain, R.drawable.welcome_order};
    private MyAdapter adapter;
    private ImageView imge_title,image1,image2;
    private int [] imageDetails={R.drawable.font_buy,R.drawable.font_change,R.drawable.font_finace,R.drawable.font_insurance,R.drawable.font_maintain};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);
        imge_title= (ImageView) findViewById(R.id.gallery_image3);
        image1= (ImageView) findViewById(R.id.gallery_image1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GalleryActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        image2= (ImageView) findViewById(R.id.gallery_image2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GalleryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        myFancyCoverFlow= (MyFancyCoverFlow) findViewById(R.id.myfancyCoverFlow);
        adapter=new MyAdapter();
        myFancyCoverFlow.setAdapter(adapter);
        initFancyCoverFlow();
        myFancyCoverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imge_title.setImageResource(imageDetails[i%imageDetails.length]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initFancyCoverFlow() {
        //设置未选中的图的透明度
        this.myFancyCoverFlow.setUnselectedAlpha(1.0f);
        //设置未选中的图的色彩饱和度
        this.myFancyCoverFlow.setUnselectedSaturation(0.0f);
        //未被选中的图像的缩放比例
        this.myFancyCoverFlow.setUnselectedScale(0.8f);
        //设置两个图之间的比例
        this.myFancyCoverFlow.setSpacing(7);
        //设置未选中图像的最大旋转角度
        this.myFancyCoverFlow.setMaxRotation(0);
        //设置未被选中图像的下沉度
        this.myFancyCoverFlow.setScaleDownGravity(0.6f);
        this.myFancyCoverFlow
                .setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
    }

    private class MyAdapter extends FancyCoverFlowAdapter{
        @Override
        public View getCoverFlowItem(int position, View reusableView, ViewGroup parent) {
            ImageView imageView;
            if (reusableView != null) {
                imageView = (ImageView) reusableView;
            } else {
                imageView = new ImageView(GalleryActivity.this);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new FancyCoverFlow.LayoutParams(500, 700));
                imageView.setImageResource(imageId[position%imageId.length]);
            }
            return imageView;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object getItem(int i) {
            return imageId[i%imageId.length];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
    }
}
