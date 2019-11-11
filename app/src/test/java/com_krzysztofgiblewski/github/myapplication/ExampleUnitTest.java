package com_krzysztofgiblewski.github.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    private Rury rury;

    @Test
    public void intLiczbaRur() {
        rury.liczRure(100, 25, 5);
        int oczekiwanyWynik = 3;
        int wynik = rury.iloscCalychRur;
        assertEquals(oczekiwanyWynik, wynik);

    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

    }

}
