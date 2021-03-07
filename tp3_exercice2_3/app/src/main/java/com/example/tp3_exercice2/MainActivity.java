package com.example.tp3_exercice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    private int userId=-1;
    private EditText name;
    private EditText lastname;
    private EditText tel;
    private EditText age;
    private EditText password;
    private Button save;
    private Button cal;
    private int number ;
    private MainObservable MO;
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
                number=MO.getNumber();
                Login person = new Login(name.getText().toString(),lastname.getText().toString(),tel.getText().toString(),age.getText().toString(),password.getText().toString());
                String path = name.getText().toString()+userId;
                File file = new File(path);
                if(!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    FileOutputStream fileOut = openFileOutput(path,Context.MODE_PRIVATE);

                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(person);
                    objectOut.close();
                    Intent i = new Intent(MainActivity.this,Affichage.class);
                    i.putExtra("file",path);
                    i.putExtra("number",number);
                    MainActivity.this.startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        cal= (Button) findViewById(R.id.button2);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent i = new Intent(MainActivity.this,Calandrier.class);
            MainActivity.this.startActivity(i);

            }
        });

    }
    private void makeKey() {
        this.userId = (int) Math.abs(Math.random()*300000000);

    }
}