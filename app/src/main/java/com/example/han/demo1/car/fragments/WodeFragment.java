package com.example.han.demo1.car.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.han.demo1.R;
import com.example.han.demo1.car.bean.MineItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15622 on 2017/3/7.
 */

public class WodeFragment extends Fragment {
    private List<MineItem> mData;
    private RecyclerView recyclerView_mine;
    private RecyclerView.LayoutManager layoutManager;
    private MyRecyclerAdapter_Mine myRecyclerAdapter_mine;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_wode_layout,container,false);
        recyclerView_mine= (RecyclerView) view.findViewById(R.id.mine_recycler);
        getDataItem();
        myRecyclerAdapter_mine=new MyRecyclerAdapter_Mine();
        recyclerView_mine.setAdapter(myRecyclerAdapter_mine);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView_mine.setLayoutManager(layoutManager);
        return view;
    }

    private void getDataItem() {
        mData=new ArrayList<>();
        MineItem item1=new MineItem(R.drawable.mine_quick,"约团车型");
        mData.add(item1);
        MineItem item2=new MineItem(R.drawable.mine_voucher,"我的礼包");
        mData.add(item2);
        MineItem item3=new MineItem(R.drawable.mine_mate,"我的话题");
        mData.add(item3);
        MineItem item4=new MineItem(R.drawable.mine_quick,"我的动态");
        mData.add(item4);
        MineItem item5=new MineItem(R.drawable.mine_comment,"我的评价");
        mData.add(item5);
        MineItem item6=new MineItem(R.drawable.mine_invite,"邀请好友");
        mData.add(item6);
        MineItem item7=new MineItem(R.drawable.mine_enter,"走进车团长");
        mData.add(item7);
    }

    class  MyRecyclerAdapter_Mine extends RecyclerView.Adapter<MyRecyclerAdapter_Mine.MyViewHolder>{
        @Override
        public MyRecyclerAdapter_Mine.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v=   LayoutInflater.from(getActivity()).inflate(R.layout.mine_list_item,parent,false);
            MyRecyclerAdapter_Mine.MyViewHolder holder=new MyRecyclerAdapter_Mine.MyViewHolder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyRecyclerAdapter_Mine.MyViewHolder holder, int position) {
            holder.imageView.setImageResource(mData.get(position).getImageId());
            holder.textView.setText(mData.get(position).getDetails());
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView textView;
            public MyViewHolder(View itemView) {
                super(itemView);
                imageView= (ImageView) itemView.findViewById(R.id.mine_image);
                textView= (TextView) itemView.findViewById(R.id.mine_text);
            }
        }
    }
}
