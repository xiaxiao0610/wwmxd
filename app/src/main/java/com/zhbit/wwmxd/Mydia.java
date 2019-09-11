package com.zhbit.wwmxd;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asus on 2018/6/4.
 */

public class Mydia extends Dialog {
    private TextView T1;
    private TextView T2;
    private ImageView I1;
    private String messageStr;
   // private String yesStr, noStr;

    private onYesOnclickListener yesOnclickListener;


    public void setYesOnclickListener(String str,onYesOnclickListener onYesOnclickListener){
       /* if (str != null) {
            yesStr = str;
        }*/
        this.yesOnclickListener = onYesOnclickListener;
    }
    public Mydia(Context context){
        super(context,R.style.MyDialog);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);
        //按空白处取消动画
        setCanceledOnTouchOutside(true);

        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();

    }
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        T2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
            }
        });
    }
    private void initData() {
        if (messageStr != null) {
            T1.setText(messageStr);
        }
    }
    private void initView() {
        T2 = (TextView) findViewById(R.id.T2);
        T1 = (TextView) findViewById(R.id.T1);
    }
    public void setMessage(String message) {
        messageStr = message;
    }
    public interface onYesOnclickListener {
       public void onYesClick();
    }
}
