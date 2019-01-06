package com.example.dell.m2_week02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.m2_week02.R;
import com.example.dell.m2_week02.bean.ListBean;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ListBean.DataBean> list;
    private ViewHolder holder;

    public LeftAdapter(Context context, List<ListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.left_layout, null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        holder.left_text.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        private final TextView left_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            left_text = itemView.findViewById(R.id.left_text);

        }
    }
}
