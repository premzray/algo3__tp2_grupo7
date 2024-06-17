package edu.fiuba.algo3.TestPowerUps;

import edu.fiuba.algo3.modelo.Exclusividad;
import edu.fiuba.algo3.modelo.PowerUp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPowerUpExclusividad {

    @Test
    public void test01ExclusividadEfectivaSobreUsuarioQueLaUsa(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(0);
        puntajesOriginales.add(0);
        puntajesOriginales.add(2);

        puntajesEsperados.add(0);
        puntajesEsperados.add(0);
        puntajesEsperados.add(0);
        puntajesEsperados.add(4);

        PowerUp powerUp = new Exclusividad();

        assertEquals(powerUp.usar(puntajesOriginales,3), puntajesEsperados);
    }

    @Test
    public void test02ExclusividadEfectivaSobreUsuarioQueNoLaUsa(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(0);
        puntajesOriginales.add(0);
        puntajesOriginales.add(2);

        puntajesEsperados.add(0);
        puntajesEsperados.add(0);
        puntajesEsperados.add(0);
        puntajesEsperados.add(4);

        PowerUp powerUp = new Exclusividad();

        assertEquals(powerUp.usar(puntajesOriginales,0), puntajesEsperados);
    }

    @Test
    public void test03ExclusividadNoAfectaPorqueNoAplicaCondiciones(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(1);
        puntajesOriginales.add(0);
        puntajesOriginales.add(2);

        puntajesEsperados.add(0);
        puntajesEsperados.add(1);
        puntajesEsperados.add(0);
        puntajesEsperados.add(2);

        PowerUp powerUp = new Exclusividad();

        assertEquals(powerUp.usar(puntajesOriginales,3), puntajesEsperados);
    }
}
