package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class exo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ly = new LinearLayout(this);

        TextView tv = new TextView(this);
        tv.setText("Hello, Android ! ");
        ly.addView(tv);

        //Ajout text
        EditText et = new EditText(this);
        et.setWidth(200);
        ly.addView(et);

        setContentView(ly);

    }
}