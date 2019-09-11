package com.zhbit.wwmxd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GameThree extends Activity {

    private Button btn_hide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_three);
    }
    public void backGame(View view){
        finish();
    }
    public void hintGame(View view){
        final RelativeLayout hint = (RelativeLayout) getLayoutInflater().inflate(R.layout.hint,null);
        new AlertDialog.Builder(this).setTitle("提示").setView(hint)
                .setMessage("倒过来翻译一下。")  //设置提示信息
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {  }
                }).show();
    }
    public void hide(View view){
        btn_hide = (Button) findViewById(R.id.btn_hide);
        view.setVisibility(View.GONE);
    }
    private Mydia mydia;
    public void clickMe(View view){
        EditText editText =(EditText) findViewById (R.id.et_i);
        String str=editText.getText().toString();
        if(str.equals("我爱你")){
            Intent intent = new Intent(GameThree.this, WinmusicService.class);
            startService(intent);
            mydia=new Mydia(GameThree.this);
            mydia.setMessage("爱你爱你！感谢你游玩这个游戏！");
            mydia.setYesOnclickListener("下一关", new Mydia.onYesOnclickListener() {
                @Override
                public void onYesClick() {
                    Intent intent = new Intent(GameThree.this,GameFour.class);
                    startActivity(intent);
                    finish();
                }
            });
            mydia.show();
        }else{
            Toast toast = Toast.makeText(GameThree.this
                    , "再想一下"
                    // 设置该Toast提示信息的持续时间
                    , Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}
