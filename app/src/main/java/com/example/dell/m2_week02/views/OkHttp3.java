package com.example.dell.m2_week02.views;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttp3
{

    private static OkHttpClient okHttpClient;
    private static Request request;
    private static RequestBody builder;
    private  OkHttpClient client;
    private Interceptor interceptor;
    private static volatile OkHttp3 instance;

    private Interceptor getInterceptor()
    {
        interceptor = new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.e("+++++","拦截前");

                Response response = chain.proceed(request);
                Log.e("+++++","拦截后");

                return response;

            }
        };
        return interceptor;
    }

    private OkHttp3()
    {
        client = new OkHttpClient().newBuilder()
                .readTimeout(3000,TimeUnit.SECONDS)
                .connectTimeout(3000,TimeUnit.SECONDS)
                .addInterceptor(getInterceptor())
                .build();
    }

    //单例okhttp
    public static OkHttp3 getInstance()
    {
        if (instance==null)
        {
            synchronized (OkHttp3.class)
            {
                if (instance==null)
                {
                    instance=new OkHttp3();
                }
            }
        }
        return instance;
    }

    //get请求
    public static void  OkHttpget(String url, Callback call){
        //创建okHttpClient
        okHttpClient = new OkHttpClient();
        //创建request
        request = new Request.Builder().url(url).method("GET",null).build();
        //
        okHttpClient.newCall(request).enqueue(call);

    }







}
