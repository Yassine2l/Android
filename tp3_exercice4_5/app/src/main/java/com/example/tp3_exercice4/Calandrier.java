package com.example.tp3_exercice4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Calandrier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calandrier);
        ListView listView = (ListView)findViewById(R.id.list);
        PlanningModel data = ViewModelProviders.of(this).get(PlanningModel.class);

        LiveData<ArrayList<String>> plan = data.getCalandar();
        plan.observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                ArrayAdapter<String> arrayAdapter
                        = new ArrayAdapter<String>(Calandrier.this, android.R.layout.simple_list_item_1 , strings);
                listView.setAdapter(arrayAdapter);
            }
        });

        data.add("20h-23h : regarder un film");
    }
}