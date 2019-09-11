package com.zhbit.wwmxd;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameEight extends Activity implements SensorEventListener {

    private SensorManager sensorManager;  //定义传感器管理器
    private Vibrator vibrator;            //定义振动器
    private ImageView pic;
    private Mydia mydia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_eight);
        pic = (ImageView) findViewById(R.id.bg_eight);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);  // 获取传感器管理器
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);  //获取振动器服务
    }
    @Override
    protected void onResume() {
        super.onResume();
        //为加速度传感器注册监听器
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] values = event.values;  //获取传感器X、Y、Z三个轴的输出信息
        int sensorType = event.sensor.getType();  // 获取传感器类型
        if (sensorType == Sensor.TYPE_ACCELEROMETER) {  //如果是加速度传感器
            //X轴输出信息>15,Y轴输出信息>15,Z轴输出信息>20
            if (values[0] > 15 || values[1] > 15 || values[2] > 20) {
                pic.setImageDrawable(getResources().getDrawable(R.drawable.keleboom));
                Intent intent = new Intent(GameEight.this, WinmusicService.class);
                startService(intent);
                mydia=new Mydia(GameEight.this);
                mydia.setMessage("biu~boom");
                mydia.setYesOnclickListener("下一关", new Mydia.onYesOnclickListener() {
                    @Override
                    public void onYesClick() {
                        Intent intent = new Intent(GameEight.this,GameNine.class);
                        startActivity(intent);
                        finish();
                    }
                });
                mydia.show();
                vibrator.vibrate(500);                    //设置振动器频率
                sensorManager.unregisterListener(this);  //取消注册监听器
            }
        }

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void backGame(View view){
        finish();
    }
    public void hintGame(View view){
        final RelativeLayout hint = (RelativeLayout) getLayoutInflater().inflate(R.layout.hint,null);
        new AlertDialog.Builder(this).setTitle("提示").setView(hint)
                .setMessage("摇一摇")  //设置提示信息
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {  }
                }).show();
    }

}
