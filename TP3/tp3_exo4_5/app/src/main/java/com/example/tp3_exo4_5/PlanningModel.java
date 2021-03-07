package com.example.tp3_exo4_5;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PlanningModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> data = new MutableLiveData<>();
    private ArrayList<String> calendrier = new ArrayList<>();
    public PlanningModel(){


    }
    public MutableLiveData<ArrayList<String>> getCalandar(InputStream f) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(f));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
       this.add(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        data.setValue(calendrier);
        return data;
    }
    public void add(String s){
        this.calendrier.add(s);
    }
}