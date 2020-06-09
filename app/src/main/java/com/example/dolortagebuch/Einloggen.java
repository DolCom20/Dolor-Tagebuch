package com.example.dolortagebuch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Einloggen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einloggen);

        //String benutzername = Aus Datenbank auslesen (Vorname des ausgewählten Kontos)
        String benutzername = "Name";

        TextView name = findViewById(R.id. Benutzername);
        name.setText(benutzername);
    }


    public void login(View view) {

        // String passWord = Aus Datenbank auslesen
        // float starpassword = Aus Datenbank auslesen
        String passWord = "dolor";
        float starpassword = (float) 3.5;

        EditText password = findViewById(R.id.PasswortEingeben);
        RatingBar stars = (RatingBar) findViewById(R.id.ratingBar);

        float starvalue = stars.getRating();
        String kontrollePw = password.getText().toString();

        if (passWord.equals(kontrollePw) && starpassword == starvalue) {
            Toast.makeText(this, "Sie haben sich erfolgreich angemeldet!", Toast.LENGTH_LONG).show();
            //Weiterleitung auf nächste Activity
            Intent j = new Intent(getApplicationContext(), Schmerzvorne.class); //Hier muss der Klassenname der Starteite eingegeben werden
            startActivity(j);
        }else if (kontrollePw.length() == 0 && starvalue == 0){
            Toast.makeText(this, "Es wurden keine Eingaben gemacht.", Toast.LENGTH_LONG).show();
        } else if (kontrollePw.length() == 0)
        {
            Toast.makeText(this, "Es wurde kein Passwort eingegeben.", Toast.LENGTH_LONG).show();
        }else if (starvalue == 0)
        {
            Toast.makeText(this, "Das Sternpasswort wurde nicht eingegeben.", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this, "Eine oder mehrere Ihrer Eingaben sind falsch.", Toast.LENGTH_LONG).show();
        }
    }

    public void back(View view){
        Intent x = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(x);

    }
}
