package com.zhbit.wwmxd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }
    public void backGame(View view){
        Intent intent = new Intent(SelectActivity.this, MusicService.class);
        stopService(intent);
        finish();
    }

    public void musicService(View view){
        Intent intent = new Intent(SelectActivity.this, MusicService.class);
        startService(intent);
    }

    public void gameOne(View view){
        Intent intent = new Intent(this,GameOne.class);
        startActivity(intent);
    }
    public void gameTwo(View view){
        Intent intent = new Intent(this,GameTwo.class);
        startActivity(intent);
    }
    public void gameThree(View view){
        Intent intent = new Intent(this,GameThree.class);
        startActivity(intent);
    }
    public void gameFour(View view){
        Intent intent = new Intent(this,GameFour.class);
        startActivity(intent);
    }
    public void gameFive(View view){
        Intent intent = new Intent(this,GameFive.class);
        startActivity(intent);
    }
    public void gameSix(View view){
        Intent intent = new Intent(this,GameSix.class);
        startActivity(intent);
    }
    public void gameSeven(View view){
        Intent intent = new Intent(this,GameSeven.class);
        startActivity(intent);
    }
    public void gameEight(View view){
        Intent intent = new Intent(this,GameEight.class);
        startActivity(intent);
    }
    public void gameNine(View view){
        Intent intent = new Intent(this,GameNine.class);
        startActivity(intent);
    }

}
