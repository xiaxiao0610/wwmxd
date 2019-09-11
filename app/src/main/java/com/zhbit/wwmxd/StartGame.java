package com.zhbit.wwmxd;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;
import java.util.Timer;
import java.util.TimerTask;

public class StartGame extends Activity {

    private ImageView imageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        imageView = (ImageView) findViewById(R.id.max);//实例化控件对象
        animationDrawable = (AnimationDrawable) imageView.getDrawable();//帧动画实现
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(StartGame.this,SelectActivity.class);
                startActivity(intent);
                StartGame.this.finish();
            }
        };
        timer.schedule(timerTask,1000*4);

    }
    @Override
    protected void onResume() {
        super.onResume();
        animationDrawable.start();//开启帧动画
    }

    @Override
    protected void onPause() {
        super.onPause();
        animationDrawable.stop();//关闭帧动画
    }

}
