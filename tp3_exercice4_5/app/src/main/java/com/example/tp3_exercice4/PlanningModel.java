package com.example.tp3_exercice4;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PlanningModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> data = new MutableLiveData<>();
    private ArrayList<String> calendrier = new ArrayList<>();

    public MutableLiveData<ArrayList<String>> getCalandar() {
        FileInputStream is;
        BufferedReader reader;
         File file = new File("calandrier");
   try {
       if (file.exists()) {
           is = new FileInputStream("calandrier");
           reader = new BufferedReader(new InputStreamReader(is));
           String line = reader.readLine();
           while(line != null){

               line = reader.readLine();
               this.add(line);
           }
       }else{
           file.createNewFile();
       }
   }catch (Exception e){
       e.printStackTrace();
   }

        data.setValue(calendrier);
        return data;
    }
    public void add(String s){
        this.calendrier.add(s);
    }
}
