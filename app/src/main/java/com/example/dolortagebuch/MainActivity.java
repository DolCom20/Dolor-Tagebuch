package com.example.dolortagebuch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String user1 = "Stefan";
    String user2 = "Bernhard";
    String user3 = "Anna";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*final SQLiteDatabase dolorCommentarius = this.openOrCreateDatabase("patienten", MODE_PRIVATE,null);

        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.Vorname);
        e3=(EditText)findViewById(R.id.Name);
        e4=(EditText)findViewById(R.id.Geburtsdatum);
        e5=(EditText)findViewById(R.id.passwort);
        e6=(RatingBar)findViewById(R.id.sternpw);
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();
        String s3 = e3.getText().toString();
        String s4 = e4.getText().toString();
        //String s5 = e5.getText().toString();
        //float s6 = e6.getRating();
        //String s60 = String.valueOf(s6);

        View.OnClickListener b = new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try{
                    dolorCommentarius.execSQL("CREATE TABLE IF NOT EXISTS patienten " +
                            "(name varchar, vorname varchar, " +
                            "email varchar, gebdatum varchar)");

                    dolorCommentarius.execSQL("INSERT INTO patienten(name, vorname, email, gebdatum, passwort, sterne)"+
                            "VALUES ('"+s3+"','"+s2+"','"+s1+"','"+s4+"') ");

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        b1=(Button)findViewById(R.id.registrieren1);
        b1.setOnClickListener(b);
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }

            });*/

    }
    //Muss aus Datenbank ausgelesen werden

    public void registrieren(View view) {

        Intent i = new Intent(getApplicationContext(), Registrieren.class);
        startActivity(i);

    }

    public void einloggen(View view) {

        EditText name = findViewById(R.id.name);
        String benutzername = name.getText().toString();
        Intent i = new Intent(getApplicationContext(), Einloggen.class);
        if (benutzername != null && (benutzername.equals(user1) || benutzername.equals(user2) || benutzername.equals(user3))) {
            i.putExtra("Vorname", benutzername);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Benutzername ist nicht vorhanden!", Toast.LENGTH_LONG).show();
            Intent z = new Intent(getApplicationContext(), MainActivity.class); //Hier muss der Klassenname der Starteite eingegeben werden
            startActivity(z);
        }
    }
}