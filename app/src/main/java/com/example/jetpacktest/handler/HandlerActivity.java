package com.example.jetpacktest.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;

import com.example.jetpacktest.R;

public class HandlerActivity extends AppCompatActivity {

    public static final String TAG = "HandlerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        HandlerThread handlerThread = new MyThread("test xu");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Handler handler = new Handler(looper);
//        for (int i = 0; i < 100; i++) {
//            int num = i;
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    Log.d(TAG, "run: " + num);
//                }
//            });
//        }
        for (int i = 0; i < 2; i++) {
            int num = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG, "run: HandlerThread " + num);
                }
            }, 1000 * i);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            looper.getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                @Override
                public boolean queueIdle() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "queueIdle: ");
                    return false;
                }
            });
        }

        for (int i = 0; i < 2; i++) {
            int num = i + 2;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG, "run: HandlerThread " + num);
                }
            }, 1000 * (i + 2));
        }

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.removeCallbacksAndMessages(null);
            }
        }, 6000);

        new View(this).post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    class MyThread extends HandlerThread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Log.d(TAG, "run: start");
            super.run();
            Log.d(TAG, "run: end");
        }
    }


}