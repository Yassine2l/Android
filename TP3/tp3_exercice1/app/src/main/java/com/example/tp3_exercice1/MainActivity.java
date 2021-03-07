package com.example.tp3_exercice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int userId=-1;
    private EditText name;
    private EditText lastname;
    private EditText tel;
    private EditText age;
    private String Data="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editTextTextPersonName);
        lastname = (EditText) findViewById(R.id.editTextTextPersonName2);
        tel = (EditText) findViewById(R.id.tel);
        age = (EditText) findViewById(R.id.age);

        if(savedInstanceState != null ){
            name.setText(savedInstanceState.getInt("name"));
            age.setText(savedInstanceState.getInt("age"));
            tel.setText(savedInstanceState.getInt("tel"));
            lastname.setText(savedInstanceState.getInt("lastname"));
            userId = savedInstanceState.getInt("key");
            Toast.makeText(this," "+userId,Toast.LENGTH_LONG).show();
        }else{
            makeKey();
            Toast.makeText(this,"Nouveau enregistrement ! "+this.userId,Toast.LENGTH_LONG).show();

        }


    }

    private void makeKey() {
        this.userId = (int) Math.abs(Math.random()*300000000);

    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("key", userId);
        savedInstanceState.putString("tel", tel.getText().toString());
        savedInstanceState.putString("age", age.getText().toString());
        savedInstanceState.putString("name", name.getText().toString());
        savedInstanceState.putString("lastname", lastname.getText().toString());
        Toast.makeText(this, "onSaveInstanceState",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        userId= savedInstanceState.getInt("key");

    }
}