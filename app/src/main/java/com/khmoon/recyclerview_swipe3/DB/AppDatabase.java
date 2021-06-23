package com.khmoon.recyclerview_swipe3.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DB_Device.class, DB_Order.class, DB_Call.class, DB_Store.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    private static final Object sLock = new Object();

    public abstract DaoDevice daoDevice();
    public abstract DaoOrder daoOrder();
    public abstract DaoCall daoCall();
    public abstract DaoStore daoStore();

    private static final String DB_NAME = "DIDk";

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
            return INSTANCE;
        }
    }
}

