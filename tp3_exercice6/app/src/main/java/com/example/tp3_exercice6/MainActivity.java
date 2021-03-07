package com.example.tp3_exercice6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private int userId=-1;
    private EditText name;
    private EditText lastname;
    private EditText tel;
    private EditText age;
    private EditText password;
    private Button save;
    private MainObservable MO;
    private Button cal;
    private int number ;
    private  AppViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MO=new MainObservable();
        getLifecycle().addObserver(MO);
        name = (EditText) findViewById(R.id.editTextTextPersonName);
        lastname = (EditText) findViewById(R.id.editTextTextPersonName2);
        tel = (EditText) findViewById(R.id.tel);
        age = (EditText) findViewById(R.id.age);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        makeKey();
        save = (Button) findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = MO.getNumber();
                String name = MainActivity.this.name.getText().toString();
                String lastname = MainActivity.this.lastname.getText().toString();
                String tel = MainActivity.this.tel.getText().toString();
                String age = MainActivity.this.age.getText().toString();
                String cal = "8h-10h : faire les courses\n10h-12h : allez chez eduard\n14h-16h : Invitez chez camille\n16h-18h : Faire du sport\"";
                viewModel = ViewModelProviders.of(MainActivity.this).get(AppViewModel.class);
                App app = new App(userId,number,name,lastname,age,tel,cal);
                Intent i = new Intent(MainActivity.this,Affichage.class);
                i.putExtra("number",userId);
                viewModel.insert(app);
                MainActivity.this.startActivity(i);
        }
        });
        cal= (Button) findViewById(R.id.button2);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,Calandrier.class);
                i.putExtra("number",userId);
                MainActivity.this.startActivity(i);

            }
        });
    }

    private void makeKey() {    this.userId = (int) Math.abs(Math.random()*300000000);
    }
}