package com.example.dolortagebuch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Registrieren2 extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //mindestens eine Zahl
                    //"(?=.*[a-z])" +         //mindestens ein Kleinbuchstabe
                    //"(?=.*[A-Z])" +         //mindestens ein Großbuchstabe
                    "(?=.*[a-zA-Z])" +        //jeder Buchstabe
                    "(?=.*[!@#$%^&+=])" +     //mindestens ein Sonderzeichen
                    "(?=\\S+$)" +             //keine Leerzeichen
                    ".{4,}" +                 //mindestens 4 Zeichen
                    "$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren2);

        Intent text = getIntent();
        Bundle namen = text.getExtras();

        if(namen != null) {
            String benutzer = "Hallo " + namen.getString("Vorname");
            TextView name = findViewById(R.id.benutzername);
            name.setText(benutzer);
        }

    }

    public void registrieren(View view) {
        Intent text = getIntent();
        Bundle namen = text.getExtras();
        String name = namen.getString("Name");
        String vorname = namen.getString("Vorname");

        RatingBar stars = (RatingBar) findViewById(R.id.sternpw);
        float starvalue = stars.getRating();


        EditText Passwort = findViewById(R.id.passwort);
        EditText Kontrollpw = findViewById(R.id.pwwiederholen);

        //Diese Variablen müssen in der Datenbank abgespeichert werden
        String passwort = Passwort.getText().toString();
        String pwwiederholen = Kontrollpw.getText().toString();


        if (Passwort.length() == 0 || Kontrollpw.length() == 0 || starvalue == 0) {

            Toast.makeText(this, "Alle Felder mit * müssen ausgefüllt werden!", Toast.LENGTH_LONG).show();
        }else if(!PASSWORD_PATTERN.matcher(passwort).matches()) {
            Toast.makeText(this, "Das Passwort ist zu schwach!", Toast.LENGTH_LONG).show();
        }else if (passwort.equals(pwwiederholen)) {
            Toast.makeText(this, "Zum Namen:" + "\n" + name + "\n" + "wurde folgendes abgespeichert:" + "\n" + passwort + "\n" + starvalue, Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), Einloggen.class);
            i.putExtra("VornameReg", vorname);
            i.putExtra("Passwort", passwort);
            i.putExtra("Sterne", starvalue);
            startActivity(i);
        }else {
            Toast.makeText(this, "Passwörter stimmen nicht überein!", Toast.LENGTH_LONG).show();

        }
    }
    public void zurück(View view) {
        Intent i = new Intent(getApplicationContext(), Registrieren.class);
        startActivity(i);
    }
}
