package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class exo5 extends AppCompatActivity {
    private CheckBox linux, macos, windows;
    private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo5);
        addListenerOnChkWindows();
        addListenerOnButton();
    }
    public void addListenerOnChkWindows() {
        windows = (CheckBox) findViewById(R.id.windows_option);
        windows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(exo5.this,"Bro, try Linux :)", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void addListenerOnButton() {
        linux = (CheckBox) findViewById(R.id.linux_option);
        macos = (CheckBox) findViewById(R.id.macos_option);
        windows = (CheckBox) findViewById(R.id.windows_option);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("Linux check : ").append(linux.isChecked());
                result.append("\nMac OS check : ").append(macos.isChecked());
                result.append("\nWindows check :").append(windows.isChecked());
                Toast.makeText(exo5.this, result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}