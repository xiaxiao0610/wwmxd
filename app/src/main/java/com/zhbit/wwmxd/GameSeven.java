package com.zhbit.wwmxd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GameSeven extends Activity {

    private List<Fruit> fruitList=new ArrayList<>();//初始化一个新的list
    private Mydia mydia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_seven);
        initFruits();//初始化水果类
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.re1);//初始化响应的RecyclerView
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        FruitAdapter adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    public class Fruit{//定义一个水果类
        private String name;//水果的名字
        private int imageId;//水果的图片
        public  Fruit(String name,int imageId){
            this.name=name;
            this.imageId=imageId;
        }

        public String getName() {
            return name;
        }

        public int getImageId() {
            return imageId;
        }
    }
    public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{
        private List <Fruit>myFruitList;
        class ViewHolder extends RecyclerView.ViewHolder{
            View fruitView;
            ImageView fruitImage;
            TextView fruitName;
            public ViewHolder(View view){
                super(view);
                fruitView=view;
                fruitImage=(ImageView)view.findViewById(R.id.fruit_image);
                fruitName=(TextView)view.findViewById(R.id.fruit_name);
            }
        }
        public FruitAdapter(List<Fruit>fruitList){
            myFruitList=fruitList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit,parent,false);
            final ViewHolder holder=new ViewHolder(view);
            holder.fruitView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=holder.getAdapterPosition();
                    Fruit fruit=myFruitList.get(position);
                    String str=fruit.getName();
                    if(str.equals("花")){
                        Intent intent = new Intent(GameSeven.this, WinmusicService.class);
                        startService(intent);
                        mydia=new Mydia(GameSeven.this);
                        mydia.setMessage("找呀找呀找花花~");
                        mydia.setYesOnclickListener("下一关", new Mydia.onYesOnclickListener() {
                            @Override
                            public void onYesClick() {
                                Intent intent = new Intent(GameSeven.this,GameEight.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        mydia.show();

                    }else{
                        Toast toast = Toast.makeText(GameSeven.this
                                , "我说的是花哦"
                                // 设置该Toast提示信息的持续时间
                                , Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            });
            return holder;
        }
        public void onBindViewHolder(ViewHolder holder,int position){
            Fruit fruit=myFruitList.get(position);
            holder.fruitImage.setImageResource(fruit.getImageId());
            holder.fruitName.setText(fruit.getName());
        }
        public int getItemCount(){
            return myFruitList.size();
        }
    }

    private void initFruits(){
        for(int i=0;i<2;i++){
            Fruit pingguo=new Fruit("苹果",R.drawable.pingguo);
            fruitList.add(pingguo);
            Fruit xiangjiao=new Fruit("香蕉",R.drawable.banana);
            fruitList.add(xiangjiao);
            Fruit lizhi=new Fruit("荔枝",R.drawable.lizhi);
            fruitList.add(lizhi);
            Fruit lizi=new Fruit("梨子",R.drawable.lizi);
            fruitList.add(lizi);
            Fruit putao=new Fruit("葡萄",R.drawable.putao);
            fruitList.add(putao);
            Fruit taozi=new Fruit("桃子",R.drawable.taozi);
            fruitList.add(taozi);
            Fruit hua=new Fruit("花",R.drawable.hua);
            fruitList.add(hua);
        }
    }
    public void backGame(View view){
        finish();
    }
    public void hintGame(View view){
        final RelativeLayout hint = (RelativeLayout) getLayoutInflater().inflate(R.layout.hint,null);
        new AlertDialog.Builder(this).setTitle("提示").setView(hint)
                .setMessage("滑一下。")  //设置提示信息
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {  }
                }).show();
    }

}
