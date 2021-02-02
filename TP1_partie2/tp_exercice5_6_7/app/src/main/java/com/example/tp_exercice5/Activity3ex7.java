package com.example.tp_exercice5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3ex7 extends AppCompatActivity {
    private TextView phone;
    private Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_ex6);
        String num=getIntent().getStringExtra("Phone");

        phone = (TextView) findViewById(R.id.textView2);
        phone.setText(num);

        call = (Button) findViewById(R.id.button3);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Intent.ACTION_CALL);
                c.setData(Uri.parse("tel:"+num));
                startActivity(c);
            }
        });

    }
}