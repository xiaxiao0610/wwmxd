package com.zhbit.wwmxd;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class GameNine extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_nine);
    }
    public void backGame(View view){
        finish();
    }
    public void hintGame(View view){
        final RelativeLayout hint = (RelativeLayout) getLayoutInflater().inflate(R.layout.hint,null);
        new AlertDialog.Builder(this).setTitle("提示").setView(hint)
                .setMessage("敬请期待")  //设置提示信息
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {  }
                }).show();
    }
}
