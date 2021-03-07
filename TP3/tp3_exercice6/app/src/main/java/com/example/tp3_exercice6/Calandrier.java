package com.example.tp3_exercice6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Calandrier extends AppCompatActivity {
    private TextView dataS;

    private  AppViewModel viewModel;
    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calandrier);
        Intent intent = getIntent();
        number = intent.getIntExtra("number",-1);
        viewModel= ViewModelProviders.of(this).get(AppViewModel.class);
        dataS=(TextView) findViewById(R.id.textView3);
        LiveData<String> plan = viewModel.getCalandar(number);
        plan.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                dataS.setText(s);
            }
        });


    }
}