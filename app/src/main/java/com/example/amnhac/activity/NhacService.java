package com.example.amnhac.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class NhacService extends Service {
    private static final String TAG = "NhacService";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");

        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }

                    if(isRunning){
                        Log.i(TAG, "Service running");
                    }
                }

                stopSelf();
            }
        }).start();

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {

        isRunning = false;

        Log.i(TAG, "Service onDestroy");
    }
}
