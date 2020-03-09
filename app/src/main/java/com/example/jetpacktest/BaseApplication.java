package com.example.jetpacktest;

import android.app.Application;
import androidx.room.Room;

import com.example.jetpacktest.livedata.AppDatabase;

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/2/27
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(
                this,
                AppDatabase.class, "database-name"
        ).build();
    }

    private static AppDatabase database;

    public static AppDatabase getDataBase() {
        return database;
    }
}
