package edu.fiuba.algo3.TestPowerUps;

import edu.fiuba.algo3.modelo.powerup.Multiplicador;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPowerUpMultiplicador {

    @Test
    public void test01MultiplicadorX2PuntajePositivo(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(1);
        puntajesOriginales.add(3);
        puntajesOriginales.add(0);
        puntajesOriginales.add(1);

        puntajesEsperados.add(1);
        puntajesEsperados.add(3);
        puntajesEsperados.add(0);
        puntajesEsperados.add(2);

        PowerUp powerUp = new Multiplicador(2);

        assertEquals(powerUp.usar(puntajesOriginales,3), puntajesEsperados);
    }

    @Test
    public void test02MultiplicadorX3PuntajePositivo(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(1);
        puntajesOriginales.add(3);
        puntajesOriginales.add(0);
        puntajesOriginales.add(1);

        puntajesEsperados.add(1);
        puntajesEsperados.add(9);
        puntajesEsperados.add(0);
        puntajesEsperados.add(1);

        PowerUp powerUp = new Multiplicador(3);

        assertEquals(powerUp.usar(puntajesOriginales,1), puntajesEsperados);
    }

    @Test
    public void test03MultiplicadorX2PuntajeNegativo(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(-1);
        puntajesOriginales.add(3);
        puntajesOriginales.add(0);
        puntajesOriginales.add(1);

        puntajesEsperados.add(-2);
        puntajesEsperados.add(3);
        puntajesEsperados.add(0);
        puntajesEsperados.add(1);

        PowerUp powerUp = new Multiplicador(2);

        assertEquals(powerUp.usar(puntajesOriginales,0), puntajesEsperados);
    }

    @Test
    public void test04MultiplicadorX3PuntajeNegativo(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(1);
        puntajesOriginales.add(-3);
        puntajesOriginales.add(0);
        puntajesOriginales.add(1);

        puntajesEsperados.add(1);
        puntajesEsperados.add(-9);
        puntajesEsperados.add(0);
        puntajesEsperados.add(1);

        PowerUp powerUp = new Multiplicador(3);

        assertEquals(powerUp.usar(puntajesOriginales,1), puntajesEsperados);
    }
}
