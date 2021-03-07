package com.example.tp3_exercice6;

import android.os.AsyncTask;

public class InsertAsyncTask extends AsyncTask<App,Void,Void> {

    AppDao appDao;


    public InsertAsyncTask(AppDao app){
        this.appDao=app;
    }
    @Override
    protected Void doInBackground(App... apps) {
        appDao.insert(apps[0]);
        return null;
    }
}
