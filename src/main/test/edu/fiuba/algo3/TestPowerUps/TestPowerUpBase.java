package edu.fiuba.algo3.TestPowerUps;

import edu.fiuba.algo3.modelo.powerup.Base;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPowerUpBase {
    @Test
    public void test01AplicaBaseYNoCambiaPuntaje(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(1);
        puntajesOriginales.add(3);
        puntajesOriginales.add(0);
        puntajesOriginales.add(1);

        puntajesEsperados.add(1);
        puntajesEsperados.add(3);
        puntajesEsperados.add(0);
        puntajesEsperados.add(1);

        PowerUp powerUp = new Base();

        assertEquals(powerUp.usar(puntajesOriginales,3), puntajesEsperados);
    }

}
