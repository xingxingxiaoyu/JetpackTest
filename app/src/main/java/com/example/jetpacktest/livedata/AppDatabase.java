package com.example.jetpacktest.livedata;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/2/27
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

