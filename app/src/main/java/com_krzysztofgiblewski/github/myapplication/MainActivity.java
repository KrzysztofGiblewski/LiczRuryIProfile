package com_krzysztofgiblewski.github.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                Toast.makeText(getApplicationContext(), wynik, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void licz() {
        EditText DlugoscOdcinka = (EditText) findViewById(R.id.editTextDlugoscOdcinka);
        pierwsza = Double.valueOf(DlugoscOdcinka.getText().toString());
        wynik = String.valueOf(pierwsza);
    }
}
