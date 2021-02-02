package com.example.tp1_exercice8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button b;
    private ListView liste;
    private EditText arr,dep;
    private ArrayList<String> allDestination= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllDestination();
        b=(Button) findViewById(R.id.button);
        liste = (ListView) findViewById(R.id.listv);
        dep=(EditText) findViewById(R.id.dep);
        arr=(EditText) findViewById(R.id.arr);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dep.getText() != null && dep.getText()!=null){
                    ArrayList a = find(dep.getText().toString(),arr.getText().toString());
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,a);
                    liste.setAdapter(adapter);
                }else{
                    Toast.makeText(getApplicationContext(),"Veuillez remplir les zones de saisies",Toast.LENGTH_LONG);
                }
            }
        });

    }

    public void getAllDestination(){
        allDestination.add("Depart:Paris:Arriver:Montpellier:6h");
        allDestination.add("Depart:Toulouse:Arriver:Marseille:12h");
        allDestination.add("Depart:Montpellier:Arriver:Toulouse:1h");
        allDestination.add("Depart:Montpellier:Arriver:Toulouse:11h");
        allDestination.add("Depart:Montpellier:Arriver:Toulouse:13h");
        allDestination.add("Depart:Montpellier:Arriver:Toulouse:14h");
        allDestination.add("Depart:Montpellier:Arriver:Toulouse:15h");
        allDestination.add("Depart:Paris:Arriver:Pau:16h");

    }

    public ArrayList<String> find(String depart,String arriver){
        ArrayList<String> values= new ArrayList<>();
        for(String dest:allDestination){
            String[] data= dest.split(":");
            if(data[1].equals(depart) && data[3].equals(arriver)){
                values.add("De "+data[1]+" a "+ data[3] + " vers " + data[4]+"\n");
            }
        }
        return values;
    }
}