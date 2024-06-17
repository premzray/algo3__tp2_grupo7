package edu.fiuba.algo3.TestPowerUps;

import edu.fiuba.algo3.modelo.Anulador;
import edu.fiuba.algo3.modelo.PowerUp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPowerUpAnulador {

    @Test
    public void test01AnuladorTodosPositivos(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(3);
        puntajesOriginales.add(1);
        puntajesOriginales.add(2);

        puntajesEsperados.add(0);
        puntajesEsperados.add(0);
        puntajesEsperados.add(0);
        puntajesEsperados.add(2);

        PowerUp powerUp = new Anulador();

        assertEquals(powerUp.usar(puntajesOriginales,3), puntajesEsperados);
    }

    @Test
    public void test02AnuladorConNegativosYPositivos(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(-3);
        puntajesOriginales.add(1);
        puntajesOriginales.add(2);

        puntajesEsperados.add(0);
        puntajesEsperados.add(-3);
        puntajesEsperados.add(0);
        puntajesEsperados.add(0);

        PowerUp powerUp = new Anulador();

        assertEquals(powerUp.usar(puntajesOriginales,1), puntajesEsperados);
    }
}
