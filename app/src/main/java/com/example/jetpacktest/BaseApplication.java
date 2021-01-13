package com.example.jetpacktest;

import android.app.Application;
import android.widget.Toast;

import androidx.room.Room;

import com.example.jetpacktest.error_handler.GolbalExceptionHandler;
import com.example.jetpacktest.livedata.AppDatabase;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import dagger.hilt.android.HiltAndroidApp;
import kotlin.jvm.functions.Function1;

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/2/27
 */
//@HiltAndroidApp
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(
                this,
                AppDatabase.class, "database-name"
        ).build();
        application = this;
        GolbalExceptionHandler.getInstance().init();


        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            //获取String类中静态方法valueOf对应的方法句柄
            MethodHandle valueOfMethodHandler = lookup.findStatic(String.class, "valueOf", MethodType.methodType(String.class, int.class));
            //执行方法句柄
            String result = (String) valueOfMethodHandler.invokeExact(12);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        Function1<String, String> function1 = s -> null;

        RefWatcher watcher = LeakCanary.install(this);

    }

    public static Application getApplication() {
        return application;
    }

    private static Application application;
    private static AppDatabase database;

    public static AppDatabase getDataBase() {
        return database;
    }
}
