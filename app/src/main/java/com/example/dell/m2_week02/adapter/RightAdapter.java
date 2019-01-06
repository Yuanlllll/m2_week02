package com.example.dell.m2_week02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.m2_week02.R;
import com.example.dell.m2_week02.bean.RightBean;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<RightBean.DataBean> rlist;
    private ViewHolder holder;

    public RightAdapter(Context context, List<RightBean.DataBean> rlist) {
        this.context = context;
        this.rlist = rlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.right_layout, null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        holder.right_text.setText(rlist.get(i).getList().get(i).getName());
        Glide.with(context).load(rlist.get(i).getList().get(i).getIcon()).into(holder.right_img);


    }

    @Override
    public int getItemCount() {
        return rlist.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder
    {

        private final ImageView right_img;
        private final TextView right_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            right_img = itemView.findViewById(R.id.right_img);
            right_text = itemView.findViewById(R.id.right_text);

        }
    }
}
