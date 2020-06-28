package com.example.dolortagebuch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Schmerzliste extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schmerzliste);


        Intent daten = getIntent();
        Bundle koerperschmerz = daten.getExtras();

        if(koerperschmerz != null) {
            CharSequence koerperteil = "" + koerperschmerz.get("Koerperteil");
            CharSequence schmerzstaerke = "" + koerperschmerz.get("Schmerzstaerke");
            String tester = koerperteil.toString();
            Toast.makeText(this, "Körperteil" + koerperteil, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Schmerzstärke" + schmerzstaerke, Toast.LENGTH_LONG).show();

            TextView name = findViewById(R.id.test);
            name.setText("Körperteil: " + tester);
        }

    }

}