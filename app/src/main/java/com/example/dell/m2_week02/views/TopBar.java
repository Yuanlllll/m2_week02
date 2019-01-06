package com.example.dell.m2_week02.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.m2_week02.R;

public class TopBar extends RelativeLayout {
    private final Button leftButton;
    private final Button rightButton;
    private final TextView titleTextView;
    public  OnLeftAndRightClickListener listener;

    //设置监听器
    public void setOnLeftAndRightClickListener(OnLeftAndRightClickListener listener) {
        this.listener = listener;
    }

    //按钮点击接口
    public interface OnLeftAndRightClickListener {
        void OnLeftButtonClick();

        void OnRightButtonClick();
    }
    //设置右边按钮的可见性
    public void setRightButtonVisibility(boolean flag){
        if (flag)
            rightButton.setVisibility(View.VISIBLE);
        else
            rightButton.setVisibility(View.GONE);
    }



    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_topbar,this);
        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        titleTextView = findViewById(R.id.titleText);

        //获取自定义属性,赋值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        int leftBackground = typedArray.getResourceId(R.styleable.TopBar_leftBackground, 0);
        int rightBtnBackground = typedArray.getResourceId(R.styleable.TopBar_rightBackground, 0);
        String titleText = typedArray.getString(R.styleable.TopBar_titleText);
        float titleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 0);
        int titleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0x38ad5a);

        //释放资源
        typedArray.recycle();
        leftButton.setBackgroundResource(leftBackground);
        rightButton.setBackgroundResource(rightBtnBackground);
        titleTextView.setText(titleText);
        titleTextView.setTextSize(titleTextSize);
        titleTextView.setTextColor(titleTextColor);


        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnRightButtonClick();
            }
        });

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnLeftButtonClick();
            }
        });

    }
}
