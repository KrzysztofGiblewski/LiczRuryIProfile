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

        Integer iloscZCalejRury;// ile wychodzi odcinków z całej rury
        Integer dlugoscOdpaduZJednejRury;// ile zostaje z rurki po odcieciu calych odcinków
        Integer iloscCalychRur;// ile potrzeba całych rur
        Integer dlugoscOdpaduOstatniej;// pozostała długość z ostatniej rury

        Integer dlugoscOdcinka = Integer.valueOf(DlugoscOdcinka.getText().toString());
        Integer dlugoscRury = Integer.valueOf(DlugoscRury.getText().toString());
        Integer potrzebnaIlosc = Integer.valueOf(IloscPotrzebna.getText().toString());

        if (dlugoscOdcinka <= dlugoscRury) { //zeby rura byla na pewno dluzsza od pozadanego odcinka

            iloscZCalejRury = dlugoscRury / dlugoscOdcinka; //tyle odcinków otzrymam z całej rury
            iloscCalychRur = potrzebnaIlosc / iloscZCalejRury;
            dlugoscOdpaduZJednejRury = dlugoscRury - (dlugoscOdcinka * iloscZCalejRury);

            if (iloscZCalejRury > potrzebnaIlosc) {      //jak mniej odcinków potrzeba niż mieści się w jednej rurze
                dlugoscOdpaduOstatniej = dlugoscRury - (dlugoscOdcinka * potrzebnaIlosc);
            }
            if (iloscZCalejRury < potrzebnaIlosc) {     //jak z jednej rury nie starcza
                int temp = potrzebnaIlosc / iloscZCalejRury;
                int temp2 = temp * iloscZCalejRury;
                int temp3 = potrzebnaIlosc - temp2;
                int temp4 = temp3 * dlugoscOdcinka;
                dlugoscOdpaduOstatniej = dlugoscRury - temp4;
                //   iloscCalychRur++; //dodaje rure tą którą musze napocząć

            } else { //gdy jest rowne to i odpad na zero
                dlugoscOdpaduZJednejRury = 0;
                dlugoscOdpaduOstatniej = 0;
            }
            ;


            textView4.setText("Całych rur potrzeba " + iloscCalychRur.toString());
            textView5.setText("z rury " + iloscZCalejRury.toString() + " odcinków i zostaje " + dlugoscOdpaduZJednejRury.toString() + " odpadu z karzdej rury");
            textView6.setText("z ostatniej zostaje " + dlugoscOdpaduOstatniej.toString());
        } else {
            textView4.setText("Cała rura musi być wieksza");
            textView5.setText("bo taki kawałek sie nie zmiesci");
            textView6.setText(":)");
        }
    }

}
