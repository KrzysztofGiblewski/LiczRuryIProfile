package com_krzysztofgiblewski.github.myapplication;

public class Rury {
    int iloscCalychRur = 0;
    int dlugoscOdpaduOstatniej = 0;
    int iloscOdcinkowZCalejRury = 0;
    int dlugoscOdpaduZJednejRury = 0;
    int iloscKawalkowZOstatniej = 0;

    void liczRure(int całaRura, int potrzebnyKawalek, int iloscPotrzebnychKawalkow) {

        iloscOdcinkowZCalejRury = całaRura / potrzebnyKawalek; //tyle odcinków otzrymam z całej rury

        dlugoscOdpaduZJednejRury = całaRura - (iloscOdcinkowZCalejRury * potrzebnyKawalek); //reszta z jednej rury

        iloscCalychRur = iloscPotrzebnychKawalkow / iloscOdcinkowZCalejRury; //potrzebna ilosc rur

        if (iloscPotrzebnychKawalkow % iloscOdcinkowZCalejRury != 0) {
            iloscCalychRur++;
            iloscKawalkowZOstatniej = iloscPotrzebnychKawalkow % iloscOdcinkowZCalejRury;
            int temp4 = iloscKawalkowZOstatniej * potrzebnyKawalek;

            dlugoscOdpaduOstatniej = całaRura - temp4;

        } else dlugoscOdpaduOstatniej = dlugoscOdpaduZJednejRury;

    }
}
