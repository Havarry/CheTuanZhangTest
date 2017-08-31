package com.example.han.demo1.car.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.han.demo1.R;
import com.example.han.demo1.car.bean.ItemBean;
import java.util.List;

/**
 * Created by 15622 on 2017/3/23.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> implements View.OnClickListener{
    private List<ItemBean> mData;

    public MyRecyclerViewAdapter(List<ItemBean> mData) {
        this.mData = mData;
    }
//    声明一个该接口的变量
    private OnRecyclerViewItemListener mOnItemClickListener=null;
//   define interface
    public static interface OnRecyclerViewItemListener{
        void onClickItem(View view,String data);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=   LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_home_one,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
//        在onCreateViewHolder()中为每个item添加点击事件
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(mData.get(position).getImageId());
        holder.textView.setText(mData.get(position).getDetails());
        holder.itemView.setTag(mData.get(position).getDetails());
    }

    @Override
    public void onClick(View v){
        if (mOnItemClickListener!=null){
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onClickItem(v, (String) v.getTag());
        }
    }
    public void setmOnItemClickListener(OnRecyclerViewItemListener mOnItemClickListener){
        this.mOnItemClickListener=mOnItemClickListener;
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.image_item);
            textView= (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
