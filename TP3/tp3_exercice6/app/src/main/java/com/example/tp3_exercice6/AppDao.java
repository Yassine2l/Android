package com.example.tp3_exercice6;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppDao {

    @Insert
    void insert(App app);

    @Query("SELECT * from Application where id = :userId")
    LiveData<App> get(int userId);

    @Query("SELECT cal from Application where id = :userId")
    LiveData<String> getCalandrier(int userId);
}
