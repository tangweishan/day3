package com.example.day3.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.day3.R;
import com.example.day3.bean.AllData;

import java.util.ArrayList;
import java.util.List;

public class VpAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<AllData.ResultsBean> list =new ArrayList<>();

    public VpAdapter(Context context) {
        this.context = context;
    }
    public void initData(ArrayList<AllData.ResultsBean> list1){
        this.list.clear();
        this.list.addAll(list1);
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return list.size() ;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        AllData.ResultsBean bean = list.get(position);
        View view = View.inflate(context, R.layout.vp_it, null);
        TextView desc=view.findViewById(R.id.tv_desc);
        TextView page=view.findViewById(R.id.tv_page);
        ImageView img=view.findViewById(R.id.img_pager);
        desc.setText("图片信息"+bean.getDesc());
        page.setText("图片位置"+list.get(position)+1);
        Glide.with(context).load(bean.getUrl()).into(img);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
