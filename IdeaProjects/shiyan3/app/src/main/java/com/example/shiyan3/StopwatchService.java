package com.example.shiyan3;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class StopwatchService extends Service {

    private boolean isRunning = false;
    private int seconds = 0;
    private Handler handler;

    public StopwatchService(Handler handler) {
        this.handler = handler;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startStopwatch();
        return START_STICKY;
    }

    public void startStopwatch() {
        isRunning = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        Thread.sleep(1000);
                        seconds++;
                        sendMessageToHandler(seconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void stopStopwatch() {
        isRunning = false;
        stopSelf();
    }

    public void fastForward() {
        seconds += 10;
        sendMessageToHandler(seconds);
    }

    private void sendMessageToHandler(int seconds) {
        Message message = new Message();
        message.arg1 = seconds;
        handler.sendMessage(message);
    }
}
