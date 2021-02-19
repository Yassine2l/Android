package com.example.tp2_exercice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private ListView dliste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dliste = (ListView) findViewById(R.id.list);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> liste =  sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<String> ls = new ArrayList<String>();

        for(Sensor s : liste) {
           if (s.getType() == Sensor.TYPE_GAME_ROTATION_VECTOR || s.getType() == Sensor.TYPE_GRAVITY){
               ls.add(s.getName()+" existe");
           }

        }
        List l = ls;
        dliste.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1, l));

    }

}