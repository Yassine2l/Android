package com.example.tp2_exercice1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.se.omapi.Session;
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
        List<Sensor> liste =  sensorManager.getSensorList(Sensor.TYPE_ALL);;
        dliste.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1,liste));


    }

}