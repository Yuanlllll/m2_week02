package com.example.dell.m2_week02.home.model;

import com.example.dell.m2_week02.views.OkHttp3;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ListModel implements Imodel {
    @Override
    public void getMdata(String url, final IlistCallBack listCallBack)
    {


        //左侧数据请求
        OkHttp3.OkHttpget(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listCallBack.getFaied();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                listCallBack.getSuccess(response.body().string());
            }
        });


    }

    //右侧数据请求
    @Override
    public void getRmdata(String url, final IlistCallBack listCallBack)
    {
        OkHttp3.OkHttpget(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                listCallBack.getFaied();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                listCallBack.getSuccess(response.body().string());
            }
        });

    }
}
