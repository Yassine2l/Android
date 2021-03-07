package com.example.tp3_exercice6;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = App.class, version = 1)
public abstract  class AppRoomDataBase extends RoomDatabase {
    public abstract AppDao appDao();
    private static volatile AppRoomDataBase appRoomInstance;
    static AppRoomDataBase getDatabase(final Context context){
        if(appRoomInstance == null){
            synchronized (AppRoomDataBase.class){
                if(appRoomInstance == null){
                    appRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppRoomDataBase.class,"application_database").build();
                }
            }
        }
        return appRoomInstance;
    }
}
