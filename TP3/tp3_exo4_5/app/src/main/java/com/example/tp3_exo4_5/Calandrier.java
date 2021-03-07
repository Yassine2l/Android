package com.example.tp3_exo4_5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileObserver;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Calandrier extends AppCompatActivity {
private PlanningModel data;
private ListView listView;
private FileObserver fileObserver;
private InputStream is;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calandrier);
         listView = (ListView)findViewById(R.id.list);
         data = ViewModelProviders.of(this).get(PlanningModel.class);

        try {

            String path = getFileStreamPath("Calendrier").getAbsolutePath();
            Log.i("file",getResources().getAssets().open("Calandrier")+"");
            is = new FileInputStream("data/user/0/com.example.tp3_exo4_5/files/Calendrier");
            fileObserver = new FileObserver("tp3_exo4_5/app/src/main/assets/Calandrier") {
                @Override
                public void onEvent(int event, String path) {
                    // The file has changed, so let’s reload the data
                    loadData();
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadData();
        data.add("20h-23h : regarder un film");
    }

    private void loadData() {

        try {


            LiveData<ArrayList<String>> plan = data.getCalandar(getResources().getAssets().open("Calandrier"));

            plan.observe(this, new Observer<ArrayList<String>>() {
                @Override
                public void onChanged(ArrayList<String> strings) {
                    ArrayAdapter<String> arrayAdapter
                            = new ArrayAdapter<String>(Calandrier.this, android.R.layout.simple_list_item_1 , strings);
                    listView.setAdapter(arrayAdapter);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}