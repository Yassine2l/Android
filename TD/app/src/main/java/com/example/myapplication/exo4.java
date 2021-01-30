package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class exo4 extends AppCompatActivity {

    private Button button;
    private Button toast;
    private Button Long;
    private Button LongClick;
    private TextView t;
    private boolean visible = false;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo4);
        button = (Button) findViewById(R.id.mainbutton);
        t = (TextView) findViewById(R.id.lng);
        t.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(),"Message Bouton 1", Toast.LENGTH_LONG).show();
            }
        });
        toast = (Button) findViewById(R.id.toast);
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(exo4.this,"Exercice4",Toast.LENGTH_LONG).show();
            }
        });
        Long = (Button) findViewById(R.id.Long);
        Long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t.setText("Exercice 4");
                if(!visible){
                    t.setVisibility(View.VISIBLE);
                    visible=true;
                }else{
                    t.setVisibility(View.INVISIBLE);
                    visible=false;
                }
            }
        });
        LongClick = (Button) findViewById(R.id.LongButton);
        LongClick.setOnLongClickListener(new View.OnLongClickListener(){


            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(exo4.this,"Long click ",Toast.LENGTH_LONG).show();

                return true;
            }
        });
    }

}