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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText DlugoscOdcinka = (EditText) findViewById(R.id.editTextDlugoscRury);
                EditText DlugoscRury = (EditText) findViewById(R.id.editTextDlugoscCalejRury);
                EditText IloscPotrzebna = (EditText) findViewById(R.id.editTextIleSztukTrzeba);

                TextView textView4 = (TextView) findViewById(R.id.textView4);
                TextView textView5 = (TextView) findViewById(R.id.textView5);
                TextView textView6 = (TextView) findViewById(R.id.textView6);

                int dlugoscOdcinka = Integer.valueOf(DlugoscOdcinka.getText().toString().trim());
                int dlugoscRury = Integer.valueOf(DlugoscRury.getText().toString().trim());
                int potrzebnaIloscOdcinkow = Integer.valueOf(IloscPotrzebna.getText().toString().trim());

                Rury rury = new Rury();
                rury.liczRure(dlugoscRury, dlugoscOdcinka, potrzebnaIloscOdcinkow);
                // ile potrzeba całych rur
                int iloscCalychRur = rury.iloscCalychRur; //wynik liczenia całych rór
                int iloscOdcinkowZCalejRury = rury.iloscOdcinkowZCalejRury;// ile wychodzi odcinków z całej rury
                int dlugoscOdpaduZJednejRury = rury.dlugoscOdpaduZJednejRury;// ile zostaje z rurki po odcieciu calych odcinków
                int dlugoscOdpaduOstatniej = rury.dlugoscOdpaduOstatniej;// pozostała długość z ostatniej rury

                if (dlugoscOdcinka <= dlugoscRury) { //zeby rura byla na pewno dluzsza od pozadanego odcinka
                    textView4.setText("Całych rur potrzeba " + iloscCalychRur);
                    textView5.setText("z rury " + iloscOdcinkowZCalejRury + " odcinków i odpad z jednej rury to "
                            + dlugoscOdpaduZJednejRury + " odpadu z karzdej rury");
                    if (dlugoscOdpaduOstatniej < dlugoscRury)
                        textView6.setText("z ostatniej zostaje " + dlugoscOdpaduOstatniej);
                    if ((potrzebnaIloscOdcinkow * dlugoscOdcinka) <= dlugoscRury)
                        textView6.setText(" :)");
                } else {
                    textView4.setText("Cała rura musi być wieksza");
                    textView5.setText("bo taki kawałek sie nie zmiesci");
                    textView6.setText(":)");
                }
            }
        });
    }


//    private void licz() {

//        EditText DlugoscOdcinka = (EditText) findViewById(R.id.editTextDlugoscRury);
//        EditText DlugoscRury = (EditText) findViewById(R.id.editTextDlugoscCalejRury);
//        EditText IloscPotrzebna = (EditText) findViewById(R.id.editTextIleSztukTrzeba);
//
//        TextView textView4 = (TextView) findViewById(R.id.textView4);
//        TextView textView5 = (TextView) findViewById(R.id.textView5);
//        TextView textView6 = (TextView) findViewById(R.id.textView6);
//
//        int iloscOdcinkowZCalejRury;// ile wychodzi odcinków z całej rury
//        int dlugoscOdpaduZJednejRury;// ile zostaje z rurki po odcieciu calych odcinków
//        int iloscCalychRur = 0;// ile potrzeba całych rur
//        int dlugoscOdpaduOstatniej = 0;// pozostała długość z ostatniej rury
//
//        int dlugoscOdcinka = Integer.valueOf(DlugoscOdcinka.getText().toString().trim());
//        int dlugoscRury = Integer.valueOf(DlugoscRury.getText().toString().trim());
//        int potrzebnaIloscOdcinkow = Integer.valueOf(IloscPotrzebna.getText().toString().trim());

//        if (dlugoscOdcinka <= dlugoscRury) { //zeby rura byla na pewno dluzsza od pozadanego odcinka
//
//
//            iloscOdcinkowZCalejRury = dlugoscRury / dlugoscOdcinka; //tyle odcinków otzrymam z całej rury
//
//            dlugoscOdpaduZJednejRury = dlugoscRury - (iloscOdcinkowZCalejRury * dlugoscOdcinka); //reszta z jednej rury
//
//            iloscCalychRur = potrzebnaIloscOdcinkow / iloscOdcinkowZCalejRury; //potrzebna ilosc rur
//            if (potrzebnaIloscOdcinkow % iloscOdcinkowZCalejRury != 0) {
//                iloscCalychRur++;
//
//                int temp3 = potrzebnaIloscOdcinkow % iloscOdcinkowZCalejRury;
//                int temp4 = temp3 * dlugoscOdcinka;
//
//                dlugoscOdpaduOstatniej = dlugoscRury - temp4;
//
//            } else dlugoscOdpaduOstatniej = dlugoscOdpaduZJednejRury;


//            textView4.setText("Całych rur potrzeba " + iloscCalychRur);
//            textView5.setText("z rury " + iloscOdcinkowZCalejRury + " odcinków i odpad z jednej rury to "
//                    + dlugoscOdpaduZJednejRury + " odpadu z karzdej rury");
//            if (dlugoscOdpaduOstatniej < dlugoscRury)
//                textView6.setText("z ostatniej zostaje " + dlugoscOdpaduOstatniej);
//            if ((potrzebnaIloscOdcinkow * dlugoscOdcinka) <= dlugoscRury)
//                textView6.setText(" :)");
//        } else {
//            textView4.setText("Cała rura musi być wieksza");
//            textView5.setText("bo taki kawałek sie nie zmiesci");
//            textView6.setText(":)");
//        }
//    }
}
