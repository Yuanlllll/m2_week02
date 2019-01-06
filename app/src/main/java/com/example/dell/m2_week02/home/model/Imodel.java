package com.example.dell.m2_week02.home.model;

public interface Imodel
{
    void getMdata(String url,IlistCallBack listCallBack);
    void getRmdata(String url,IlistCallBack listCallBack);
    interface IlistCallBack
    {
        void getSuccess(String data);
        void getFaied();
    }
}


