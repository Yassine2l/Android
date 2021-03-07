package com.example.tp3_exercice6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class Affichage extends AppCompatActivity {
    private TextView dataS;

    private  AppViewModel viewModel;
    private int nm, number;
    private String name, lastname, age, tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        dataS = (TextView) findViewById(R.id.affichage);
        Intent intent = getIntent();
        number = intent.getIntExtra("number",-1);
        Log.i("User id 3: ",""+number);
        viewModel = ViewModelProviders.of(Affichage.this).get(AppViewModel.class);
        LiveData<App> a = viewModel.getInfo(number);

        //dataS.setText("\nNombre des resumes ="+nm+"\nName : "+name+"\n"+"LastName : "+lastname+"\n"+"Tel : "+tel+"\n"+"Age : "+age+"\n");
        viewModel.getInfo(number).observe(this, new Observer<App>() {

            @Override
            public void onChanged(App app) {
                Log.i("User id : ",""+number+" id : "+app.getId());

                name = app.getName();
                lastname = app.getLastname();
                age = app.getAge();
                tel = app.getTelephone();
                nm = app.getNumber();
                dataS.setText("\nNombre des resumes ="+nm+"\nName : "+name+"\n"+"LastName : "+lastname+"\n"+"Tel : "+tel+"\n"+"Age : "+age+"\n");
            }
        });


    }


}
