package com.example.tp2_exercice5_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private boolean flashON = false;
    private TextView view;
    private long lastUpdate;
    private CameraManager mCameraManager;
    private String mCameraId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.textView);
        view.setText("Flash status :OFF");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mCameraId = mCameraManager.getCameraIdList()[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }

    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

        long actualTime = System.currentTimeMillis();
        if (accelationSquareRoot >= 2)
        {

            if (actualTime - lastUpdate < 3000) { //3 secondes
                return;
            }
            lastUpdate = actualTime;
            flashON = !flashON;
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mCameraManager.setTorchMode(mCameraId, flashON);
                }
                view.setText("Flash status : "+String.valueOf(flashON?"ON":"OFF"));
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {

        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
