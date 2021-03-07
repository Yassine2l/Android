package com.example.tp3_exercice2;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class PlanningModel extends ViewModel {

    private ArrayList<String> calendrier= new ArrayList<>();

    public PlanningModel(){

        calendrier.add("8h-10h : faire les courses");
        calendrier.add("10h-12h : allez chez eduard");
        calendrier.add("14h-16h : Invitez chez camille");
        calendrier.add("16h-18h : Faire du sport");
    }
    public ArrayList getCalandar(){
        return calendrier;
    }
}
