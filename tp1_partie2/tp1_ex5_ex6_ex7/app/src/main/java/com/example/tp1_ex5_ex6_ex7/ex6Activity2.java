package com.example.tp1_ex5_ex6_ex7;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ex6Activity2 extends AppCompatActivity {
    private TextView text;
    private Button ok;
    private Button annuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex62);

        text = (TextView) findViewById(R.id.textView);
        Bundle b = getIntent().getExtras();
        StringBuffer data = new StringBuffer("");
        String firstName = b.getString("firstName");
        data.append(firstName+"\n");
        String lastName = b.getString("lastName");
        data.append(lastName+"\n");
        String Age = b.getString("Age");
        data.append(Age+"\n");
        String Competance = b.getString("Competance");
        data.append(Competance+"\n");
        String Phone = b.getString("Phone");
        data.append(Phone);
        text.setText(data.toString());

        ok = (Button) findViewById(R.id.button);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity3ex7.class);
                i.putExtra("Phone",Phone);
                startActivity(i);
            }
        });

        annuler = (Button) findViewById(R.id.button2);
        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retour = new Intent(getApplicationContext(),MainEx6Activity.class);
                startActivity(retour);
            }
        });
    }
}