package com.example.dell.m2_week02;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.m2_week02.bean.ListBean;
import com.example.dell.m2_week02.fragment.FenFragment;
import com.example.dell.m2_week02.fragment.MiFragment;
import com.example.dell.m2_week02.fragment.MyFragment;
import com.example.dell.m2_week02.fragment.ShopFragment;
import com.example.dell.m2_week02.fragment.ShouFragment;
import com.example.dell.m2_week02.home.presenter.ListPresenter;
import com.example.dell.m2_week02.home.view.Iview;
import com.example.dell.m2_week02.views.TopBar;
import com.google.gson.Gson;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.List;

public class MainActivity extends AppCompatActivity  {


    private BottomTabBar bottom_tabar;
    private TopBar topbar;
    private TextView titleText;
    private ListPresenter listpre;
    private List<ListBean.DataBean> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        topbar = findViewById(R.id.topbar);
        bottom_tabar = findViewById(R.id.bottom_tabar);
        titleText = findViewById(R.id.titleText);


        bottom_tabar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(10)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.a,ShouFragment.class)
                .addTabItem("分类",R.drawable.b,FenFragment.class)
                .addTabItem("Mi觅",R.drawable.c,MiFragment.class)
                .addTabItem("购物",R.drawable.d,ShopFragment.class)
                .addTabItem("我的",R.drawable.e,MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                        if (name.equals("首页"))
                        {
                            titleText.setText("首页");
                        }
                        if (name.equals("分类"))
                        {
                            titleText.setText("分类");
                        }
                        if (name.equals("Mi觅"))
                        {
                            titleText.setText("Mi觅");
                        }
                        if (name.equals("购物"))
                        {
                            titleText.setText("购物");
                        }
                        if (name.equals("我的"))
                        {
                            titleText.setText("我的");
                        }

                    }
                });



        topbar.setOnLeftAndRightClickListener(new TopBar.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftButtonClick() {
                //左边按钮实现的功能逻辑
                finish();
            }
            @Override
            public void OnRightButtonClick() {

                //右边按钮实现的功能逻辑
                Toast.makeText(MainActivity.this, "提交", Toast.LENGTH_SHORT).show();
            }
        });

    }



}
