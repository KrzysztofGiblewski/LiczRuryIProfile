package com_krzysztofgiblewski.github.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double pierwsza;
    String wynik = "jakiś tekst";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonLiczIleRury);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licz();
                //    Toast.makeText(getApplicationContext(), wynik, Toast.LENGTH_LONG).show();
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

        Integer dlugoscOdcinka = Integer.valueOf(DlugoscOdcinka.getText().toString());
        Integer dlugoscRury = Integer.valueOf(DlugoscRury.getText().toString());
        Integer potrzebnaIlosc = Integer.valueOf(IloscPotrzebna.getText().toString());

        Integer iloscZCalej, dlugoscOdpadu, iloscCalychRur;

        iloscZCalej = dlugoscRury / dlugoscOdcinka;
        dlugoscOdpadu = dlugoscRury % dlugoscOdcinka;
        iloscCalychRur = potrzebnaIlosc / iloscZCalej;
        if (potrzebnaIlosc % iloscZCalej > 0)
            iloscCalychRur++;
        textView4.setText("Całych rur potrzeba " + iloscCalychRur.toString());
        textView5.setText("z rury " + iloscZCalej.toString() + " odcinki i zostaje " + dlugoscOdpadu.toString() + " odpadu z kmarzdej rury");
        textView6.setText("z ostatniej zostaje " + dlugoscOdpadu.toString());
        //   wynik = String.valueOf(iloscZCalej);

    }

}
