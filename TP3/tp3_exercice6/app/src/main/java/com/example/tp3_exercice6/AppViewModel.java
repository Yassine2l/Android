package com.example.tp3_exercice6;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AppViewModel extends AndroidViewModel {
    private AppDao appDao;
    private AppRoomDataBase appDB;
    private LiveData<App> liveData;
    private LiveData<String> cal;
    public AppViewModel(@NonNull Application application) {
        super(application);
        appDB=AppRoomDataBase.getDatabase(application);
        appDao = appDB.appDao();

    }
    public LiveData<App> getInfo(int number){
        liveData=appDao.get(number);
       return  liveData;
    }

    public LiveData<String> getCalandar(int number){
        cal = appDao.getCalandrier(number);
        return cal;
    }
    public void insert(App app){
        new InsertAsyncTask(appDao).execute(app);
    }
    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
