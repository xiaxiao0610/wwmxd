package com.zhbit.wwmxd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class GameOne extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_one);
    }
    public void backGame(View view){
        finish();
    }
    public void hintGame(View view){
        final RelativeLayout hint = (RelativeLayout) getLayoutInflater().inflate(R.layout.hint,null);
        new AlertDialog.Builder(this).setTitle("提示").setView(hint)
                .setMessage("听话~")  //设置提示信息
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {  }
                }).show();
    }

    private Mydia mydia;
    public void clickMe(View view){
        Intent intent = new Intent(GameOne.this, WinmusicService.class);
        startService(intent);
        mydia=new Mydia(GameOne.this);
        mydia.setMessage("乖~");
        mydia.setYesOnclickListener("下一关", new Mydia.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                Intent intent = new Intent(GameOne.this,GameTwo.class);
                startActivity(intent);
                finish();
            }
        });
        mydia.show();

        /*
        final RelativeLayout next = (RelativeLayout) getLayoutInflater().inflate(R.layout.next,null);
        new AlertDialog.Builder(this).setTitle("恭喜你").setView(next).setMessage("乖~")
                .setPositiveButton("下一关", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        Intent intent = new Intent(GameOne.this,GameTwo.class);
                        startActivity(intent);
                        finish();
                    }
                }).show();
        */
    }

}

