package com.example.dell.m2_week02.home.presenter;

import com.example.dell.m2_week02.MainActivity;
import com.example.dell.m2_week02.api.Api;
import com.example.dell.m2_week02.fragment.ShouFragment;
import com.example.dell.m2_week02.home.model.Imodel;
import com.example.dell.m2_week02.home.model.ListModel;

public class ListPresenter implements Ipresenter
{
   ShouFragment shoufragment;
    private final ListModel listModel;

    public ListPresenter(ShouFragment shoufragment) {
        this.shoufragment = shoufragment;
        //初始化model
        listModel = new ListModel();
    }

    @Override
    public void getPdata()
    {
        listModel.getMdata(Api.SHOU, new Imodel.IlistCallBack() {
            @Override
            public void getSuccess(String data) {
                shoufragment.getVdata(data);
            }

            @Override
            public void getFaied() {
                shoufragment.getVdata("加载失败");

            }
        });

    }

    //右侧
    @Override
    public void getRpdata()
    {
        listModel.getRmdata(Api.Fen, new Imodel.IlistCallBack() {
            @Override
            public void getSuccess(String data) {
                shoufragment.getRvdata(data);
            }

            @Override
            public void getFaied() {
                shoufragment.getRvdata("加载失败");

            }
        });

    }
}
