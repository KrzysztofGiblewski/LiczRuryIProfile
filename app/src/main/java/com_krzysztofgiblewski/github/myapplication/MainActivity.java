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
                licz();
            }
        });
    }

    private void licz() {

        EditText DlugoscOdcinka = (EditText) findViewById(R.id.editTextDlugoscRury);
        EditText DlugoscRury = (EditText) findViewById(R.id.editTextDlugoscCalejRury);
        EditText IloscPotrzebna = (EditText) findViewById(R.id.editTextIleSztukTrzeba);

        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);

        Integer iloscZCalej;// ile wychodzi odcinków z całej rury
        Integer dlugoscOdpadu;// ile zostaje z rurki po odcieciu calych odcinków
        Integer iloscCalychRur;// ile potrzeba całych rur
        Integer dlugoscOdpaduOstatniej;// pozostała długość z ostatniej rury

        Integer dlugoscOdcinka = Integer.valueOf(DlugoscOdcinka.getText().toString());
        Integer dlugoscRury = Integer.valueOf(DlugoscRury.getText().toString());
        Integer potrzebnaIlosc = Integer.valueOf(IloscPotrzebna.getText().toString());

        if (dlugoscOdcinka <= dlugoscRury) { //zeby rura byla na pewno dluzsza od pozadanego odcinka

            iloscZCalej = dlugoscRury / dlugoscOdcinka; //tyle odcinków otzrymam z całej rury
            //jak ilosc porzadanych odcinkow jest wieksza od jednej rury jak mniej i z jednej zostaje wiecej odpadu to else
            if ((iloscZCalej * potrzebnaIlosc) < dlugoscRury) {
                dlugoscOdpadu = dlugoscRury - dlugoscOdcinka;
            } else {
                dlugoscOdpadu = dlugoscRury - (dlugoscOdcinka * iloscZCalej);
            }
            iloscCalychRur = potrzebnaIlosc / iloscZCalej;
            //gdy trzeba zaczać kolejną rurę (pozostałość z dzielenia większa od zera)
            if ((potrzebnaIlosc % iloscZCalej) > 0) {
                int temp = potrzebnaIlosc % iloscCalychRur;
                int temp2 = (temp) * dlugoscOdcinka;
                dlugoscOdpaduOstatniej = temp2 - dlugoscRury;
                iloscCalychRur++; //dodaje rure tą którą musze napocząć
            } else dlugoscOdpaduOstatniej = dlugoscOdpadu;

            textView4.setText("Całych rur potrzeba " + iloscCalychRur.toString());
            textView5.setText("z rury " + iloscZCalej.toString() + " odcinków i zostaje " + dlugoscOdpadu.toString() + " odpadu z karzdej rury");
            textView6.setText("z ostatniej zostaje " + dlugoscOdpaduOstatniej.toString());
        } else {
            textView4.setText("Cała rura musi być wieksza");
            textView5.setText("bo taki kawałek sie nie zmiesci");
            textView6.setText(":)");
        }
    }

}
