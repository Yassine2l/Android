package com.example.tp2_exercice3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private Sensor sensor;
    private TextView xText, yText, zText;
    private SensorManager sensorManager;
    private int x,y,z;
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        xText = (TextView)findViewById(R.id.textView);
        yText = (TextView)findViewById(R.id.textView2);
        zText = (TextView)findViewById(R.id.textView3);
        layout=(ConstraintLayout)findViewById(R.id.layout);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);
        x=(int)event.values[0];
        y=(int)event.values[1];
        z=(int)event.values[2];

        if(x<0){
            layout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if(y<0){
            layout.setBackgroundColor(Color.BLACK);
        }
        if(z<0){
            layout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }
}