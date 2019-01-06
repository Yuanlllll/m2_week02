package com.example.dell.m2_week02.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.m2_week02.R;
import com.example.dell.m2_week02.adapter.LeftAdapter;
import com.example.dell.m2_week02.adapter.RightAdapter;
import com.example.dell.m2_week02.bean.ListBean;
import com.example.dell.m2_week02.bean.RightBean;
import com.example.dell.m2_week02.home.presenter.ListPresenter;
import com.example.dell.m2_week02.home.view.Iview;
import com.google.gson.Gson;

import java.util.List;

public class ShouFragment extends Fragment implements Iview
{
    private RecyclerView lrecy_view;
    private List<ListBean.DataBean> list;
    private List<RightBean.DataBean> rlist;
    private RecyclerView rrecy_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.shou_layout, null);
        lrecy_view = view.findViewById(R.id.lrecy_view);
        rrecy_view = view.findViewById(R.id.rrecy_view);

        //初始化presenter
        ListPresenter listpre = new ListPresenter(this);
        listpre.getPdata();
        listpre.getRpdata();
        return view;
    }

    @Override
    public void getVdata(final String data)
    {


        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson=new Gson();
                ListBean listBean = gson.fromJson(data, ListBean.class);
                list = listBean.getData();

                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                lrecy_view.setLayoutManager(manager);
                lrecy_view.setAdapter(new LeftAdapter(getActivity(),list));
            }
        });

    }

    //右侧网络请求数据
    @Override
    public void getRvdata(final String data)
    {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson=new Gson();
                RightBean rightBean = gson.fromJson(data, RightBean.class);
                rlist = rightBean.getData();

                GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
                rrecy_view.setLayoutManager(manager);
                rrecy_view.setAdapter(new RightAdapter(getActivity(),rlist));
            }
        });


    }
}
