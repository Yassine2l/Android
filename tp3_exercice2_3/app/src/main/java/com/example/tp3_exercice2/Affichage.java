package com.example.tp3_exercice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Affichage extends AppCompatActivity {
    private TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        String name,lastname,age,password,tel;
        data = (TextView) findViewById(R.id.affichage);
        Intent intent = getIntent();
        String path = intent.getStringExtra("file");
        int number = intent.getIntExtra("number",0);
        try {


            FileInputStream fileIn = openFileInput(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Login person =(Login) objectIn.readObject();
            name = person.getName();
            lastname = person.getLastname();
            tel = person.getTel();
            age = person.getAge();
            password = person.getPassword();

            objectIn.close();
            data.setText("File name :"+path+"\nNombre des resumes ="+number+"\nName : "+name+"\n"+"LastName : "+lastname+"\n"+"Tel : "+tel+"\n"+"Age : "+age+"\n"+"Password : "+password);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}