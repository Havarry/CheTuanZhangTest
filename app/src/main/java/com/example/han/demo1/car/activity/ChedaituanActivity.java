package com.example.han.demo1.car.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.han.demo1.R;
import com.example.han.demo1.car.bean.ItemChedaituan;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15622 on 2017/3/10.
 */

public class ChedaituanActivity extends Activity {

    private List<ItemChedaituan> mData_car;
    private RecyclerView recyclerView_car;
    private RecyclerView.LayoutManager layoutManager_car;
    private MyRecyclerAdapter myRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chedaituan);
        recyclerView_car= (RecyclerView) findViewById(R.id.chedaituan_recycler);
        getItemData();
        myRecyclerAdapter=new MyRecyclerAdapter();
        recyclerView_car.setAdapter(myRecyclerAdapter);
        layoutManager_car=new LinearLayoutManager(getApplication());
        recyclerView_car.setLayoutManager(layoutManager_car);
    }

    private void getItemData() {
        mData_car=new ArrayList<>();
        ItemChedaituan item1=new ItemChedaituan(R.drawable.banner,"item1","item1","item1");
        mData_car.add(item1);
        ItemChedaituan item2=new ItemChedaituan(R.drawable.banner,"item2","item2","item2");
        mData_car.add(item2);
        ItemChedaituan item3=new ItemChedaituan(R.drawable.banner,"item3","item3","item3");
        mData_car.add(item3);
        ItemChedaituan item4=new ItemChedaituan(R.drawable.banner,"item4","item4","item4");
        mData_car.add(item4);
        ItemChedaituan item5=new ItemChedaituan(R.drawable.banner,"item5","item5","item5");
        mData_car.add(item5);
        ItemChedaituan item6=new ItemChedaituan(R.drawable.banner,"item6","item6","item6");
        mData_car.add(item6);
        ItemChedaituan item7=new ItemChedaituan(R.drawable.banner,"item7","item7","item7");
        mData_car.add(item7);
        ItemChedaituan item8=new ItemChedaituan(R.drawable.banner,"item8","item8","item8");
        mData_car.add(item8);
        ItemChedaituan item9=new ItemChedaituan(R.drawable.banner,"item9","item9","item9");
        mData_car.add(item9);
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolderCar>{
        @Override
        //创建item的View，被LayoutManager所调用
        public MyViewHolderCar onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(getApplication()).inflate(R.layout.chedaituan_item_layout,parent,false);
            MyViewHolderCar myViewHolderCar=new MyViewHolderCar(view);
            return myViewHolderCar;
        }
        //将数据与界面进行绑定的操作
        @Override
        public void onBindViewHolder(MyViewHolderCar holder, int position) {

            holder.imageView.setImageResource(mData_car.get(position).getImageId());
            holder.textView1.setText(mData_car.get(position).getTextView1());
            holder.textView2.setText(mData_car.get(position).getTextView2());
            holder.textView3.setText(mData_car.get(position).getTextView3());
        }
        //获取数据的数量
        @Override
        public int getItemCount() {
            return mData_car.size();
        }
        //自定义的ViewHolder，持有每个Item的的所有界面元素
        class MyViewHolderCar extends RecyclerView.ViewHolder{

            ImageView imageView;
            TextView textView1,textView2,textView3;
            public MyViewHolderCar(View itemView) {
                super(itemView);
                imageView= (ImageView) itemView.findViewById(R.id.chedaituan_image);
                textView1= (TextView) itemView.findViewById(R.id.text1);
                textView3= (TextView) itemView.findViewById(R.id.text3);
                textView2= (TextView) itemView.findViewById(R.id.text2);
            }
        }
    }


}
