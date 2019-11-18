package com_krzysztofgiblewski.github.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonLiczIleRury);
        Button dodaj = (Button) findViewById(R.id.buttonDodaj);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView sumaCalychTekst = (TextView) findViewById(R.id.wynikSumaWszystkich);
                TextView ostatniWynikTekst = (TextView) findViewById(R.id.wynikSumyCalych);


                int dlugoscOdcinka = 0;
                int dlugoscRury = 0;
                int potrzebnaIloscOdcinkow = 0;
                EditText DlugoscOdcinka = (EditText) findViewById(R.id.editTextDlugoscRury);
                if (DlugoscOdcinka.getText() == null)
                    DlugoscOdcinka.setText("0");
                dlugoscOdcinka = Integer.valueOf(DlugoscOdcinka.getText().toString().trim());
                EditText DlugoscRury = (EditText) findViewById(R.id.editTextDlugoscCalejRury);
                if (DlugoscRury.getText() == null)
                    DlugoscRury.setText("0");
                dlugoscRury = Integer.valueOf(DlugoscRury.getText().toString().trim());
                EditText IloscPotrzebna = (EditText) findViewById(R.id.editTextIleSztukTrzeba);
                if (IloscPotrzebna.getText() == null)
                    IloscPotrzebna.setText("0");
                potrzebnaIloscOdcinkow = Integer.valueOf(IloscPotrzebna.getText().toString().trim());

                TextView textView4 = (TextView) findViewById(R.id.textView4);
                TextView textView5 = (TextView) findViewById(R.id.textView5);
                TextView textView6 = (TextView) findViewById(R.id.textView6);


                if (dlugoscOdcinka > 0 && dlugoscRury > 0 && potrzebnaIloscOdcinkow > 0)
                    if (dlugoscOdcinka < 99999 && dlugoscRury < 99999 && potrzebnaIloscOdcinkow < 9999) {

                        Rury rury = new Rury();
                        rury.liczRure(dlugoscRury, dlugoscOdcinka, potrzebnaIloscOdcinkow);

                        // ile potrzeba całych rur
                        int iloscCalychRur = rury.iloscCalychRur; //wynik liczenia całych rór
                        int iloscOdcinkowZCalejRury = rury.iloscOdcinkowZCalejRury;// ile wychodzi odcinków z całej rury
                        int dlugoscOdpaduZJednejRury = rury.dlugoscOdpaduZJednejRury;// ile zostaje z rurki po odcieciu calych odcinków
                        int dlugoscOdpaduOstatniej = rury.dlugoscOdpaduOstatniej;// pozostała długość z ostatniej rury


                        if (dlugoscOdcinka <= dlugoscRury) { //zeby rura byla na pewno dluzsza od pozadanego odcinka
                            textView4.setText("Całych rur o długości " + dlugoscRury + " cm potrzeba " + iloscCalychRur + " sztuk");
                            textView5.setText("z jednej rury wychodzi " + iloscOdcinkowZCalejRury + " kawałków o długości "
                                    + dlugoscOdcinka + "cm " + "i  " + dlugoscOdpaduZJednejRury + "cm odpadu z karzdej całej rury");
                            ostatniWynikTekst.setText(iloscCalychRur + "");


                            if (dlugoscOdpaduOstatniej < dlugoscRury) {
                                textView6.setText("z ostatniej rury dostajemy " + rury.iloscKawalkowZOstatniej + " kawałków a z napoczętej rury zostaje " + dlugoscOdpaduOstatniej + " cm");
                            }
                            if ((potrzebnaIloscOdcinkow * dlugoscOdcinka) <= dlugoscRury) {
                                textView6.setText(" :)");
                            }
                        } else {
                            textView4.setText("Cała rura musi być wieksza");
                            textView5.setText("bo taki kawałek sie nie zmiesci");
                            textView6.setText(":)");
                        }

                    }

            }


        });
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView sumaCalychTekst = (TextView) findViewById(R.id.wynikSumaWszystkich);
                TextView ostatniWynikTekst = (TextView) findViewById(R.id.wynikSumyCalych);

//                sumaCalychTekst.setText((ostatniWynikTekst.getText().toString())+(sumaCalychTekst.getText().toString()));

                int ostatniWynikInt = Integer.valueOf(ostatniWynikTekst.getText().toString().trim());
                int sumaCalychRur = Integer.valueOf(sumaCalychTekst.getText().toString().trim());
                sumaCalychRur += ostatniWynikInt;
                ostatniWynikTekst.setText(0 + "");
                sumaCalychTekst.setText(sumaCalychRur + "");

            }
        });
    }


}
