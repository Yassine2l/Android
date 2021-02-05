package com.example.tp1_ex5_ex6_ex7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class exo5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // LinearLayout layout = new LinearLayout(this);
        TableLayout layout = new TableLayout(this);
        //Declaration des labels
        TextView writeName = new TextView(this);
        writeName.setText(R.string.writeName);
        TextView writeLastName = new TextView(this);
        writeLastName.setText(R.string.writelastName);
        TextView writeAge = new TextView(this);
        writeAge.setText(R.string.writeAge);
        TextView writeCompetance = new TextView(this);
        writeCompetance.setText(R.string.writeCompetance);
        TextView writePhone = new TextView(this);
        writePhone.setText(R.string.writePhone);
        TextView labelLastName = new TextView(this);
        labelLastName.setPadding(10,10,30,10);
        labelLastName.setText(R.string.lastName);
        //labelLastName.setTextColor(getResources().getColor(R.color.text));
        TextView labelName = new TextView(this);
        labelName.setPadding(10,10,30,10);
        labelName.setText(R.string.name);
        TextView labelAge = new TextView(this);
        labelAge.setPadding(10,10,30,10);
        labelAge.setText(R.string.Age);
        TextView labelCompetance = new TextView(this);
        labelCompetance.setPadding(10,10,30,10);
        labelCompetance.setText(R.string.competance);
        TextView labelPhone = new TextView(this);
        labelPhone.setPadding(10,10,30,10);
        labelPhone.setText(R.string.phone);
        //Declaration des EditText
        EditText textLastName = new EditText(this);
        textLastName.setPadding(5,10,15,10);
        TableLayout.LayoutParams p = new TableLayout.LayoutParams();
        p.weight= TableLayout.LayoutParams.MATCH_PARENT;
        textLastName.setLayoutParams(p);
        EditText textFirstName = new EditText(this);
        textFirstName.setPadding(5,10,15,10);
        textFirstName.setLayoutParams(p);
        EditText textAge = new EditText(this);
        textAge.setPadding(5,10,15,10);
        textAge.setLayoutParams(p);
        EditText textCompetance = new EditText(this);
        textCompetance.setPadding(5,10,15,10);
        textCompetance.setLayoutParams(p);
        EditText textPhone = new EditText(this);
        textPhone.setPadding(5,10,15,10);
        textPhone.setLayoutParams(p);
        //declaration Layout
        LinearLayout lyLastName = new LinearLayout(this);
        lyLastName.addView(labelLastName);
        lyLastName.addView(textLastName);
        layout.addView(writeLastName);
        layout.addView(lyLastName);
        LinearLayout lyName = new LinearLayout(this);
        lyName.addView(labelName);
        lyName.addView(textFirstName);
        layout.addView(writeName);
        layout.addView(lyName);
        LinearLayout lyAge = new LinearLayout(this);
        lyAge.addView(labelAge);
        lyAge.addView(textAge);
        layout.addView(writeAge);
        layout.addView(lyAge);
        LinearLayout lyCompetance = new LinearLayout(this);
        lyCompetance.addView(labelCompetance);
        lyCompetance.addView(textCompetance);
        layout.addView(writeCompetance);
        layout.addView(lyCompetance);

        LinearLayout lyPhone = new LinearLayout(this);
        lyPhone.addView(labelPhone);
        lyPhone.addView(textPhone);
        layout.addView(writePhone);
        layout.addView(lyPhone);
        //Button submit + action
        Button submit = new Button(this);
        submit.setText(R.string.validate);
        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(exo5.this).create();
                alertDialog.setTitle(R.string.confirmation);

                alertDialog.setCancelable(true);

                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,getResources().getText(R.string.confirmation), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), getResources().getText(R.string.confirmation), Toast.LENGTH_SHORT).show();
                        textAge.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                        textCompetance.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                        textFirstName.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                        textLastName.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                        textPhone.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));

                    }
                });

                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,getResources().getText(android.R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), getResources().getText(android.R.string.cancel), Toast.LENGTH_SHORT).show();
                        textAge.setBackgroundColor(getResources().getColor(android.R.color.white));
                        textCompetance.setBackgroundColor(getResources().getColor(android.R.color.white));
                        textFirstName.setBackgroundColor(getResources().getColor(android.R.color.white));
                        textLastName.setBackgroundColor(getResources().getColor(android.R.color.white));
                        textPhone.setBackgroundColor(getResources().getColor(android.R.color.white));
                    }
                });
                alertDialog.show();
            }
        });
        layout.addView(submit);
        setContentView(layout);
    }
}