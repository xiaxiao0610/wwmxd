package com.zhbit.wwmxd;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by asus on 2018/6/4.
 */

public class MusicService extends Service /*implements MediaPlayer.OnCompletionListener*/{
    MediaPlayer mediaPlayer;
   IBinder binder = new AudioBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
        // TODO: Return the communication channel to the service.

    }
    public void onCreate() {
        super.onCreate();
        // 从raw文件夹中获取一个应用自带的mp3文件
        mediaPlayer = MediaPlayer.create(this, R.raw.bgmusic);
        //mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setLooping(true);
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (!mediaPlayer.isPlaying()) {
            new MusicPlayThread().start();
        }
        else mediaPlayer.isPlaying();
        return START_STICKY;
    }
    /*public void onCompletion(MediaPlayer mp) {
        stopSelf();// 结束了，则结束Service

    }*/

  /*  public void onDestroy(){
        super.onDestroy();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }*/
   public class AudioBinder extends Binder {
        // 返回Service对象
        public MusicService getService() {
            return MusicService.this;
        }
    }

   private class MusicPlayThread extends Thread {
        public void run() {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        }
    }
}
