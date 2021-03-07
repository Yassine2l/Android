package com.example.tp3_exercice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calandrier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calandrier);
        ListView listView = (ListView)findViewById(R.id.list);
        PlanningModel data = ViewModelProviders.of(this).get(PlanningModel.class);
        ArrayList<String> plan = data.getCalandar();
        Log.i("Plan size",plan.size()+"");
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , plan);
        listView.setAdapter(arrayAdapter);
    }
}