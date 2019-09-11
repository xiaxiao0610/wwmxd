package com.zhbit.wwmxd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    public void startGame(View view){
        Intent intent = new Intent(this,SelectActivity.class);
        startActivity(intent);
    }
    */
    public void startGame(View view) {
        Intent intent = new Intent(this, StartGame.class);
        startActivity(intent);
    }
    public void aboutActivity(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }


}
