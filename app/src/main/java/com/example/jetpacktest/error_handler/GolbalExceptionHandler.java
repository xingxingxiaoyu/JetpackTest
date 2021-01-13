package com.example.jetpacktest.error_handler;

import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.jetpacktest.BaseApplication;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/4/16
 */
public class GolbalExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "GolbalExceptionHandler";
    //本类实例
    private static GolbalExceptionHandler mInstance;
    //系统默认的uncatchException
    private Thread.UncaughtExceptionHandler mDefaultException;

    //保证只有一个实例
    private GolbalExceptionHandler() {
    }

    //单例模式
    public static GolbalExceptionHandler getInstance() {
        if (mInstance == null) {
            mInstance = new GolbalExceptionHandler();
        }
        return mInstance;
    }

    //获取系统默认的异常处理器,并且设置本类为系统默认处理器
    public void init() {
        mDefaultException = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.d(TAG, "uncaughtException: " + thread.getName() + " " + ex);
        Log.d(TAG, "uncaughtException: " + Thread.currentThread().getName());
        if (!uncaughtExceptionSelf(thread, ex)) {
            if (mDefaultException != null) {
                // 如果用户没有处理则让系统默认的异常处理器来处理
                mDefaultException.uncaughtException(thread, ex);
            }
        }
    }

    public boolean uncaughtExceptionSelf(Thread thread, Throwable ex) {
        if (Looper.getMainLooper().getThread() == thread) {
            try {  //Sleep 来让线程停止一会是为了显示Toast信息给用户，然后Kill程序
                Toast.makeText(BaseApplication.getApplication(), "应用程序即将终止", Toast.LENGTH_LONG).show();
                Thread.sleep(20000);
            } catch (Exception e) {
                Log.d(TAG, "Exception: " + e.getMessage());
            }
//            //如果不关闭程序,会导致程序无法启动,需要完全结束进程才能重新启动
//            android.os.Process.killProcess(android.os.Process.myPid());
//            System.exit(1);
        } else {
            Log.e(TAG, "uncaughtExceptionSelf: ", ex);
        }
        return true;
    }
}
