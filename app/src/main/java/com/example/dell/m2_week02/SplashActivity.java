package com.example.dell.m2_week02;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity {

    private ImageView img_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //初始化控件
        img_view = findViewById(R.id.img_view);

        //平移
        ObjectAnimator py = ObjectAnimator.ofFloat(img_view, "translationY", img_view.getTranslationY(), 800);
        ObjectAnimator rotation= ObjectAnimator.ofFloat(img_view,"rotation",0,360);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(img_view,"alpha",0,1,0,1);
        ObjectAnimator xz = ObjectAnimator.ofFloat(img_view, "scaleX", 0, 1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(py).with(rotation).with(alpha).with(xz);
        //设置时间
        animatorSet.setDuration(5000);
        animatorSet.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //动画结束进行跳转
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
              //  finish();
            }
        },5000);
    }
}
