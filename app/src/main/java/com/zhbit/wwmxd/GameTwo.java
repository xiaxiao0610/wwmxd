package com.zhbit.wwmxd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GameTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_two);
    }
    public void backGame(View view){
        finish();
    }
    public void hintGame(View view){
        final RelativeLayout hint = (RelativeLayout) getLayoutInflater().inflate(R.layout.hint,null);
        new AlertDialog.Builder(this).setTitle("提示").setView(hint)
                .setMessage("点 没 有用的！")  //设置提示信息
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {  }
                }).show();
    }

    public void clickMe(View view){
        Toast toast = Toast.makeText(GameTwo.this
                , "点没有用的！"
                // 设置该Toast提示信息的持续时间
                , Toast.LENGTH_SHORT);
        toast.show();
    }

    private Mydia mydia;
    public void clickNo(View view){
        Intent intent = new Intent(GameTwo.this, WinmusicService.class);
        startService(intent);
        mydia=new Mydia(GameTwo.this);
        mydia.setMessage("嘻嘻，骚套路~");
        mydia.setYesOnclickListener("下一关", new Mydia.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                Intent intent = new Intent(GameTwo.this,GameThree.class);
                startActivity(intent);
                finish();
            }
        });
        mydia.show();
    }
}
