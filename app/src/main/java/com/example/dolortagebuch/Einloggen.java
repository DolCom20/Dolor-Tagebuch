package com.example.dolortagebuch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;

public class Einloggen extends AppCompatActivity {
    String user1 = "Stefan";
    String user2 = "Bernhard";
    String user3;

    String pw1 = "Gw10#2019";
    String pw2 = "DMEA!2019";
    String pw3;

    float stern1 = 1;
    float stern2 = 2;
    float stern3;

    String benutzername = null;


    public String austauschname(){
        Intent text = getIntent();
        Bundle daten = text.getExtras();
        if (daten != null){
            if (daten.getString("Vorname") == null){
                benutzername = daten.getString("VornameReg");
                return benutzername;
            }else{
                benutzername = daten.getString("Vorname");
                return benutzername;
            }

        }
        return null;
    }
    public String getUser(){
        Intent text = getIntent();
        Bundle daten = text.getExtras();
        user3 = daten.getString("VornameReg");
        return user3;
    }

    public String getPw(){
        Intent text = getIntent();
        Bundle daten = text.getExtras();
        pw3 = daten.getString("Passwort");
        return pw3;
    }

    public float getStern(){
        Intent text = getIntent();
        Bundle daten = text.getExtras();
        stern3 = daten.getFloat("Sterne");
        return stern3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einloggen);


        TextView name = findViewById(R.id. Benutzername);
        name.setText(austauschname());

    }


    public void login(View view) {

        user3 = getUser();
        pw3 = getPw();
        stern3 = getStern();

        EditText password = findViewById(R.id.PasswortEingeben);
        RatingBar stars = (RatingBar) findViewById(R.id.ratingBar);

        float starvalue = stars.getRating();
        String kontrollePw = password.getText().toString();

        if((benutzername.equals(user1) && kontrollePw.equals(pw1)) ||(benutzername.equals(user2) && kontrollePw.equals(pw2)) || (kontrollePw.equals(pw3))){
            if((benutzername.equals(user1) && starvalue == stern1) ||(benutzername.equals(user2) && starvalue == stern2) || (starvalue == stern3)){
                Toast.makeText(this, "Sie haben sich erfolgreich angemeldet!", Toast.LENGTH_LONG).show();
                //Weiterleitung auf nächste Activity
                Intent j = new Intent(getApplicationContext(), Schmerzvorne.class);
                startActivity(j);
            }else if ((benutzername.equals(user1) && starvalue != stern1) ||(benutzername.equals(user2) && starvalue != stern2) || (user3.equals(user3) && starvalue != stern3)){
                Toast.makeText(this, "Sternpasswort stimmt nicht überein!", Toast.LENGTH_LONG).show();
            }
        }else if ((benutzername.equals(user1) && !kontrollePw.equals(pw1)) || (benutzername.equals(user2) && !kontrollePw.equals(pw2)) || (user3.equals(user3) && !kontrollePw.equals(pw3))){
            Toast.makeText(this, "Passwort stimmt nicht überein!", Toast.LENGTH_LONG).show();
        }else if (kontrollePw.length() == 0 && starvalue == 0){
            Toast.makeText(this, "Es wurden keine Eingaben gemacht.", Toast.LENGTH_LONG).show();
        }else if (kontrollePw.length() == 0){
            Toast.makeText(this, "Es wurde kein Passwort eingegeben.", Toast.LENGTH_LONG).show();
        }else if (starvalue == 0){
            Toast.makeText(this, "Das Sternpasswort wurde nicht eingegeben.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Eine oder mehrere Ihrer Eingaben sind falsch.", Toast.LENGTH_LONG).show();
        }
    }


    public void back(View view){
        Intent x = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(x);

    }
}
