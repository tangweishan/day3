package com.example.day3.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.day3.R;
import com.example.day3.bean.AllData;

import java.util.ArrayList;
import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<AllData.ResultsBean> list=new ArrayList<>();
    public RecAdapter(Context context) {
        this.context = context;
    }

    public void RecAdapter(List<AllData.ResultsBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public List<AllData.ResultsBean> getlist(){
        return list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1){
            View view = View.inflate(context, R.layout.list_item, null);
            return new VH1(view);
        }else {
            View view = View.inflate(context, R.layout.rec_item, null);
            return new VH2(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        //int type = getItemViewType(position);
        int type1 = holder.getItemViewType();
        if (type1==0){
            AllData.ResultsBean bean = list.get(position-1);
            VH2  vh2 = (VH2) holder;
            Glide.with(context).load(bean.getUrl()).into(vh2.img);
            vh2.tv.setText(bean.getDesc());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCilCkList!=null){
                    onCilCkList.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 1;
        }else {
            return 0;
        }
    }

    private class VH1 extends RecyclerView.ViewHolder {

        public VH1(View view) {
            super(view);
        }
    }

    private class VH2 extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;
        public VH2(View view) {
            super(view);
          img= view.findViewById(R.id.img_r);
            tv=view.findViewById(R.id.tv_r);
        }
    }
    private onCilCkList onCilCkList;

    public void setOnCilCkList(RecAdapter.onCilCkList onCilCkList) {
        this.onCilCkList = onCilCkList;
    }

    public interface onCilCkList{
        void onClick(int p);
    }
}
