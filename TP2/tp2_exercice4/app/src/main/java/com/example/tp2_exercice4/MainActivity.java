package com.example.tp2_exercice4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private Sensor sensor;
    private SensorManager sensorManager;
    private int lastX,lastY;
    private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
         t = (TextView) findViewById(R.id.textView);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = lastX - event.values[0];
        float y = lastY - event.values[1];

        lastX = (int) event.values[0];
        lastY = (int) event.values[1];

        if (x > 2){
            t.setText("Droit ");
        }
        else if (x < -2){
            t.setText("Gauche ");
        }

        if (y > 2){
            t.setText("Bas " );
        }
        else if (y < -2){
            t.setText("Haut ");

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }
}