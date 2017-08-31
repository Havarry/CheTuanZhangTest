package com.example.han.demo1.car.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.han.demo1.R;
import com.example.han.demo1.car.activity.ChedaituanActivity;
import com.example.han.demo1.car.adapter.MyRecyclerViewAdapter;
import com.example.han.demo1.car.bean.ItemBean;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 15622
 * Timer 2017/3/7
 */

public class HomeFragment extends Fragment {
    private RollPagerView mRollViewPager;
    private RecyclerView recyclerView,pinpaiRecycler;
    private List<ItemBean> items1,items2;
    private MyRecyclerViewAdapter mAdapter1,mAdapter2;
    private RecyclerView.LayoutManager layoutManager,layoutManager2;
    private ViewFlipper mViewFlipper;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Handler handler;
    private FloatingActionButton floatingActionButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shouye_layout, container, false);

//       设置广告栏
        mRollViewPager = (RollPagerView) view.findViewById(R.id.rolls);
        mRollViewPager.setAnimationDurtion(500);    //设置切换时间
        mRollViewPager.setAdapter(new TestLoopAdapter(mRollViewPager)); //设置适配器
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(),Color.WHITE,Color.GRAY));// 设置圆点指示器颜色

//      设置第一个网格布局
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerview);
        getItemData1();
        mAdapter1=new MyRecyclerViewAdapter(items1);
        recyclerView.setAdapter(mAdapter1);
        layoutManager=new GridLayoutManager(getActivity(),5);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter1.setmOnItemClickListener(new MyRecyclerViewAdapter.OnRecyclerViewItemListener() {
            @Override
            public void onClickItem(View view, String data) {
                if (data==items1.get(2).getDetails()){
                    Intent intent=new Intent(getActivity(), ChedaituanActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"待完善",Toast.LENGTH_SHORT).show();
                }

            }
        });


//      设置车市头条
        mViewFlipper= (ViewFlipper) view.findViewById(R.id.viewFlipper);
        View flipper_1=LayoutInflater.from(getActivity()).inflate(R.layout.flipper_layout_one,null);
        View flipper_2=LayoutInflater.from(getActivity()).inflate(R.layout.flipper_layout_two,null);
        mViewFlipper.addView(flipper_1);
        mViewFlipper.addView(flipper_2);
        mViewFlipper.setFlipInterval(1000);
        mViewFlipper.setInAnimation(getActivity(),R.anim.viewfliper_in);
        mViewFlipper.setOutAnimation(getActivity(),R.anim.viewfliper_out);
        mViewFlipper.setAutoStart(true);

//        下拉刷新
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.colorPrimary,R.color.colorPrimaryDark);
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeRefreshLayout.setProgressBackgroundColor(R.color.colorWhite);
        swipeRefreshLayout.setDistanceToTriggerSync(100);//设置下拉的距离，开启刷新
        swipeRefreshLayout.setProgressViewEndTarget(true, 100);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(2000);
                            Message message=handler.obtainMessage();
                            message.what=1;
                            handler.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int str=msg.what;
                if (str==1){
                    swipeRefreshLayout.setRefreshing(false);
                    Toast toast=Toast.makeText(getActivity(),"刷新完成",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        };

//        第二个网格布局
        pinpaiRecycler= (RecyclerView) view.findViewById(R.id.pinpai_recycler);
        getItemData2();
        mAdapter2=new MyRecyclerViewAdapter(items2);
        pinpaiRecycler.setAdapter(mAdapter2);
        layoutManager2=new GridLayoutManager(getActivity(),5);
        pinpaiRecycler.setLayoutManager(layoutManager2);

        floatingActionButton= (FloatingActionButton) view.findViewById(R.id.float_btn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        return view;
    }

    private void getItemData2() {
        items2=new ArrayList<>();
        ItemBean item1=new ItemBean(R.drawable.dazhong,"大众");
        items2.add(item1);
        ItemBean item2=new ItemBean(R.drawable.biaozhi,"标致");
        items2.add(item2);
        ItemBean item3=new ItemBean(R.drawable.fute,"福特");
        items2.add(item3);
        ItemBean item4=new ItemBean(R.drawable.xiandai,"现代");
        items2.add(item4);
        ItemBean item5=new ItemBean(R.drawable.fengtian,"本田");
        items2.add(item5);
        ItemBean item6=new ItemBean(R.drawable.bieke,"别克");
        items2.add(item6);
        ItemBean item7=new ItemBean(R.drawable.sikeda,"斯柯达");
        items2.add(item7);
        ItemBean item8=new ItemBean(R.drawable.biyadi,"比亚迪");
        items2.add(item8);
        ItemBean item9=new ItemBean(R.drawable.mazida,"马自达");
        items2.add(item9);
        ItemBean item10=new ItemBean(R.drawable.jili,"吉利");
        items2.add(item10);
    }

    //获取网格布局数据
    public void getItemData1() {
        items1=new ArrayList<>();
        ItemBean item1=new ItemBean(R.drawable.quick_buycar,"一键约团");
        items1.add(item1);
        ItemBean item2=new ItemBean(R.drawable.insur_buycar,"车险抽奖");
        items1.add(item2);
        ItemBean item3=new ItemBean(R.drawable.home_finace,"车贷团");
        items1.add(item3);
        ItemBean item4=new ItemBean(R.drawable.home_change,"汽车置换");
        items1.add(item4);
        ItemBean item5=new ItemBean(R.drawable.contrast_homebg,"车型对比");
        items1.add(item5);
        ItemBean item6=new ItemBean(R.drawable.calculation_homebg,"购物计算");
        items1.add(item6);
        ItemBean item7=new ItemBean(R.drawable.merchants,"附近4s店");
        items1.add(item7);
        ItemBean item8=new ItemBean(R.drawable.teammates,"附近团友");
        items1.add(item8);
        ItemBean item9=new ItemBean(R.drawable.problems,"常见问题");
        items1.add(item9);
        ItemBean item10=new ItemBean(R.drawable.full_homebg,"全部");
        items1.add(item10);
    }
//     设置广告栏适配器
    private class TestLoopAdapter extends LoopPagerAdapter{
          private int imageId[]={R.drawable.banner1,R.drawable.banner3,R.drawable.banner4,R.drawable.banner2};
        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imageId[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imageId.length;
        }
    }

    //第一个Recycler的适配器
//    class  MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{
//        @Override
//        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//         View v=   LayoutInflater.from(getActivity()).inflate(R.layout.grid_home_one,parent,false);
//            MyViewHolder holder=new MyViewHolder(v);
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(MyViewHolder holder, int position) {
//            holder.imageView.setImageResource(items.get(position).getImageId());
//            holder.textView.setText(items.get(position).getDetails());
//        }
//
//        @Override
//        public int getItemCount() {
//            return items.size();
//        }
//
//        class MyViewHolder extends RecyclerView.ViewHolder{
//            ImageView imageView;
//            TextView textView;
//            public MyViewHolder(View itemView) {
//                super(itemView);
//                imageView= (ImageView) itemView.findViewById(R.id.image_item);
//                textView= (TextView) itemView.findViewById(R.id.tv_item);
//            }
//        }
//    }
    //第二个Recycler的适配器
//    class  MyRecyclerAdapter1 extends RecyclerView.Adapter<MyRecyclerAdapter1.MyViewHolder>{
//        @Override
//        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View v=   LayoutInflater.from(getActivity()).inflate(R.layout.grid_home_one,parent,false);
//            MyViewHolder holder=new MyViewHolder(v);
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(MyViewHolder holder, int position) {
//            holder.imageView.setImageResource(items2.get(position).getImageId());
//            holder.textView.setText(items2.get(position).getDetails());
//        }
//
//        @Override
//        public int getItemCount() {
//            return items2.size();
//        }
//
//        class MyViewHolder extends RecyclerView.ViewHolder{
//            ImageView imageView;
//            TextView textView;
//            public MyViewHolder(View itemView) {
//                super(itemView);
//                imageView= (ImageView) itemView.findViewById(R.id.image_item);
//                textView= (TextView) itemView.findViewById(R.id.tv_item);
//            }
//        }
//    }
}