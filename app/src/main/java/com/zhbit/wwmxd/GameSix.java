package com.zhbit.wwmxd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameSix extends Activity {

    private TextView textView1;
    int num1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_six);
    }
    public void backGame(View view){
        finish();
    }
    public void hintGame(View view){
        final RelativeLayout hint = (RelativeLayout) getLayoutInflater().inflate(R.layout.hint,null);
        new AlertDialog.Builder(this).setTitle("提示").setView(hint)
                .setMessage("是找到X哦")  //设置提示信息
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {  }
                }).show();

    }
    public void iv_1(View view){

        textView1=(TextView)findViewById(R.id.textView1);
        num1=Integer.parseInt(textView1.getText().toString());
        if(num1>1){
            num1-=1;
        }
        textView1.setText(Integer.toString(num1));
        Toast toast=Toast.makeText(GameSix.this,"不对哦",Toast.LENGTH_SHORT);
        toast.show();
    }
    public void iv_2(View view){

        textView1=(TextView)findViewById(R.id.textView1);
        num1=Integer.parseInt(textView1.getText().toString());
        if(num1<999){
            num1+=1;
        }
        textView1.setText(Integer.toString(num1));
        Toast toast=Toast.makeText(GameSix.this,"不对哦",Toast.LENGTH_SHORT);
        toast.show();
    }
    private Mydia mydia;
    public void zdx(View view){
        // final RelativeLayout next = (RelativeLayout) getLayoutInflater().inflate(R.layout.my_dialog,null);

        Intent intent = new Intent(GameSix.this, WinmusicService.class);
        startService(intent);
        mydia=new Mydia(GameSix.this);
        mydia.setMessage("腻害腻害");
        mydia.setYesOnclickListener("下一关", new Mydia.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                Intent intent = new Intent(GameSix.this,GameSeven.class);
                startActivity(intent);
                finish();
            }
        });
        mydia.show();


      /* new AlertDialog.Builder(this).setTitle("是找到x哦").setView(next).setMessage("嘻嘻")
                .setPositiveButton("下一关", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        Intent intent = new Intent(Gamesix.this,GameSevent.class);
                        startActivity(intent);
                        finish();
                    }
                }).show();*/


    }
}
