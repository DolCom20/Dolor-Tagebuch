package com.example.dolortagebuch;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Schmerzhinten extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schmerzhinten);
    }

    public void checklinksrechts(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.links:
                if (checked) {
                    Intent i = new Intent(getApplicationContext(), Schmerzlinks.class);
                    startActivity(i);
                }
                break;
            case R.id.rechts:
                if (checked) {
                    Intent j = new Intent(getApplicationContext(), Schmerzrechts.class);
                    startActivity(j);
                }
                break;
        }
    }

    boolean geklickt = false;
    int idalt;
    int idneu;
    int radioid;

    public void körperteilClick(View view)
    {

        if ( !geklickt) {


            idalt = view.getId();
            //Farbe auf gelb
            view.setBackgroundColor(Color.parseColor("#FFFF00"));

            geklickt = true;

        }
        else{
            idneu = view.getId();
            if (idalt == idneu){
                //Das gleiche Körperteil wurde zweimal hintereinander gedrückt,
                //somit soll der ausgewählte Schmerz zu dem Körperteil abgespeichert

                //Hier muss die radioid und idneu(vom Körperteil) abgespeichert werden


                RadioButton geklickterRadio = findViewById(radioid);
                geklickterRadio.setChecked(false);
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                geklickt = false;
            }
            else{
                //Es wurde, nachdem ein Körperteil ausgewählt wurde ein Neues angeklickt.
                //Altes Körperteil soll deaktiviert werden und das neue aktiviert
                idalt = idneu;
                idneu = view.getId();

                //Hier muss die radioid und idneu(vom Körperteil) abgespeichert werden


                RadioButton geklickterRadio = findViewById(radioid);
                geklickterRadio.setChecked(false);
                view.setBackgroundColor(Color.parseColor("#FFFF00"));
                geklickt = true;
            }
        }
    }

    public void schmerzstärke(View view) {
        if (geklickt == true) {
            Button geklicktesKT = findViewById(idalt);
            boolean checked = ((RadioButton) view).isChecked();
            switch (view.getId()) {
                case R.id.eins:
                    if (checked) {
                        geklicktesKT.setBackgroundColor(Color.parseColor("#BAE8B3"));
                        radioid = view.getId();
                    }
                    break;

                case R.id.zwei:
                    if (checked) {
                        geklicktesKT.setBackgroundColor(Color.parseColor("#77B158"));
                        radioid = view.getId();
                    }
                    break;

                case R.id.drei:
                    if (checked) {
                        geklicktesKT.setBackgroundColor(Color.parseColor("#50751C"));
                        radioid = view.getId();
                    }
                    break;
                case R.id.vier:
                    if (checked) {
                        geklicktesKT.setBackgroundColor(Color.parseColor("#D67474"));
                        radioid = view.getId();
                    }
                    break;
                case R.id.funf:
                    if (checked) {
                        geklicktesKT.setBackgroundColor(Color.parseColor("#CA4141"));
                        radioid = view.getId();
                    }
                    break;
                case R.id.sechs:
                    if (checked) {
                        geklicktesKT.setBackgroundColor(Color.parseColor("#6E0909"));
                        radioid = view.getId();
                    }
                    break;
            }
        }
        else{

        }
    }


    public void checkvornehinten(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.vorne:
                if (checked){
                    Intent i = new Intent(getApplicationContext(), Schmerzvorne.class);
                    startActivity(i);
                }
                break;
            case R.id.hinten:
                if (checked) {
                    Intent j = new Intent(getApplicationContext(), Schmerzhinten.class);
                    startActivity(j);
                }
                break;

        }
    }

    public void zurück(View view) {
        //Wohin wird man mit dem zurück Button geleitet?
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void weiter(View view){
        //Wohin wird man mit dem weiter Button geleitet?
        //Intent i = new Intent(getApplicationContext(), _____.class);
        //startActivity(i);
    }
}
