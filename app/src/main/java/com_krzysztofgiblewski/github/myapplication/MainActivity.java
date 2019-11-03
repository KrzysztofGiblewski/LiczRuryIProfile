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

        Integer iloscOdcinkowZCalejRury;// ile wychodzi odcinków z całej rury
        Integer dlugoscOdpaduZJednejRury;// ile zostaje z rurki po odcieciu calych odcinków
        Integer iloscCalychRur;// ile potrzeba całych rur
        Integer dlugoscOdpaduOstatniej;// pozostała długość z ostatniej rury

        Integer dlugoscOdcinka = Integer.valueOf(DlugoscOdcinka.getText().toString());
        Integer dlugoscRury = Integer.valueOf(DlugoscRury.getText().toString());
        Integer potrzebnaIloscOdcinkow = Integer.valueOf(IloscPotrzebna.getText().toString());

        if (dlugoscOdcinka <= dlugoscRury) { //zeby rura byla na pewno dluzsza od pozadanego odcinka

            iloscOdcinkowZCalejRury = dlugoscRury / dlugoscOdcinka; //tyle odcinków otzrymam z całej rury
            dlugoscOdpaduZJednejRury = dlugoscRury - (dlugoscOdcinka * iloscOdcinkowZCalejRury);
            if (dlugoscOdpaduZJednejRury > 0) {
                Integer temp = potrzebnaIloscOdcinkow / iloscOdcinkowZCalejRury; //24 : 10 = 2
                Integer temp2 = temp * iloscOdcinkowZCalejRury; //2 * 10 = 20
                Integer temp3 = potrzebnaIloscOdcinkow - temp2; //24 - 20 =4
                Integer temp4 = temp3 * dlugoscOdcinka; //4 * 100 = 400
                dlugoscOdpaduOstatniej = dlugoscRury - temp4; //1000 - 400 = 600
            } else dlugoscOdpaduOstatniej = 0;
            if (dlugoscOdpaduOstatniej == dlugoscRury) {
                dlugoscOdpaduOstatniej = 0;
            }
            iloscCalychRur = potrzebnaIloscOdcinkow / iloscOdcinkowZCalejRury;
            if (potrzebnaIloscOdcinkow % iloscOdcinkowZCalejRury != 0) //jak reszta z dzielenia to znaczy że jeszce trzeba rurę napocząć
            {
                iloscCalychRur++;
            }

//            if (iloscOdcinkowZCalejRury > potrzebnaIloscOdcinkow) {      //jak mniej odcinków potrzeba niż mieści się w jednej rurze
//                dlugoscOdpaduOstatniej = dlugoscRury - (dlugoscOdcinka * potrzebnaIloscOdcinkow);
//                dlugoscOdpaduZJednejRury = dlugoscRury - (dlugoscOdcinka * potrzebnaIloscOdcinkow);
//                iloscCalychRur = 1;
//
//            }
//            if (iloscOdcinkowZCalejRury < potrzebnaIloscOdcinkow) {     //jak z jednej rury nie starcza
//                Integer temp = potrzebnaIloscOdcinkow / iloscOdcinkowZCalejRury; //24 : 10 = 2
//                Integer temp2 = temp * iloscOdcinkowZCalejRury; //2 * 10 = 20
//                Integer temp3 = potrzebnaIloscOdcinkow - temp2; //24 - 20 =4
//                Integer temp4 = temp3 * dlugoscOdcinka; //4 * 100 = 400
//                dlugoscOdpaduOstatniej = dlugoscRury - temp4; //1000 - 400 = 600
//                iloscCalychRur = (iloscOdcinkowZCalejRury / potrzebnaIloscOdcinkow) + 1;
//                dlugoscOdpaduZJednejRury = dlugoscRury - (dlugoscOdcinka * iloscOdcinkowZCalejRury);
//
//            } else { //gdy jest rowne to i odpad na zero
//                dlugoscOdpaduZJednejRury = 999;
//                dlugoscOdpaduOstatniej = 999;
//                iloscCalychRur =999;
//            }
            ;


            textView4.setText("Całych rur potrzeba " + iloscCalychRur.toString());
            textView5.setText("z rury " + iloscOdcinkowZCalejRury.toString() + " odcinków i zostaje " + dlugoscOdpaduZJednejRury.toString() + " odpadu z karzdej rury");
            if ((potrzebnaIloscOdcinkow * dlugoscOdcinka) > dlugoscRury)
            textView6.setText("z ostatniej zostaje " + dlugoscOdpaduOstatniej.toString());
            if ((potrzebnaIloscOdcinkow * dlugoscOdcinka) <= dlugoscRury)
                textView6.setText(" :)");
        } else {
            textView4.setText("Cała rura musi być wieksza");
            textView5.setText("bo taki kawałek sie nie zmiesci");
            textView6.setText(":)");
        }
    }

}
