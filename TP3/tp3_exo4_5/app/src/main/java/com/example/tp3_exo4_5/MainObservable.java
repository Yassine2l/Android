package com.example.tp3_exo4_5;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainObservable implements LifecycleObserver {

    private String className = this.getClass().getSimpleName();
    private int number=0;
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void increment(){
        this.number++;
        Log.i(className,"increment");
    }

    public int getNumber() {
        return number;
    }
}
