package edu.fiuba.algo3.TestAdministradorPowerUp;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdministradorPowerUp {

    @Test
    public void test01SeUsaUnSoloAnulador() {
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(3);
        puntajesOriginales.add(2);
        puntajesOriginales.add(1);

        puntajesEsperados.add(0);
        puntajesEsperados.add(3);
        puntajesEsperados.add(0);
        puntajesEsperados.add(0);

        ArrayList<PowerUp> powerUpsUsados = new ArrayList<PowerUp>();
        PowerUp powerUp1 = new Base();
        PowerUp powerUp2 = new Anulador();
        PowerUp powerUp3 = new Base();
        PowerUp powerUp4 = new Base();

        powerUpsUsados.add(powerUp1);
        powerUpsUsados.add(powerUp2);
        powerUpsUsados.add(powerUp3);
        powerUpsUsados.add(powerUp4);

        AdministradorPowerUp administradorPowerUp = new AdministradorPowerUp();

        assertEquals(administradorPowerUp.resolverPowerUps(puntajesOriginales, powerUpsUsados), puntajesEsperados);
    }

    @Test
    public void test02SeUsaUnSoloMultiplicadorX2(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(3);
        puntajesOriginales.add(2);
        puntajesOriginales.add(1);

        puntajesEsperados.add(0);
        puntajesEsperados.add(6);
        puntajesEsperados.add(2);
        puntajesEsperados.add(1);

        ArrayList<PowerUp> powerUpsUsados = new ArrayList<PowerUp>();
        PowerUp powerUp1 = new Base();
        PowerUp powerUp2 = new Multiplicador(2);
        PowerUp powerUp3 = new Base();
        PowerUp powerUp4 = new Base();

        powerUpsUsados.add(powerUp1);
        powerUpsUsados.add(powerUp2);
        powerUpsUsados.add(powerUp3);
        powerUpsUsados.add(powerUp4);

        AdministradorPowerUp administradorPowerUp = new AdministradorPowerUp();

        assertEquals(administradorPowerUp.resolverPowerUps(puntajesOriginales, powerUpsUsados), puntajesEsperados);

    }

    @Test
    public void test03SeUsaUnaSolaExclusividad(){
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

        ArrayList<PowerUp> powerUpsUsados = new ArrayList<PowerUp>();
        PowerUp powerUp1 = new Base();
        PowerUp powerUp2 = new Exclusividad();
        PowerUp powerUp3 = new Base();
        PowerUp powerUp4 = new Base();

        powerUpsUsados.add(powerUp1);
        powerUpsUsados.add(powerUp2);
        powerUpsUsados.add(powerUp3);
        powerUpsUsados.add(powerUp4);

        AdministradorPowerUp administradorPowerUp = new AdministradorPowerUp();

        assertEquals(administradorPowerUp.resolverPowerUps(puntajesOriginales, powerUpsUsados), puntajesEsperados);

    }

    @Test
    public void test04SeUsanDosAnuladores(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(3);
        puntajesOriginales.add(2);
        puntajesOriginales.add(1);

        puntajesEsperados.add(0);
        puntajesEsperados.add(0);
        puntajesEsperados.add(0);
        puntajesEsperados.add(0);

        ArrayList<PowerUp> powerUpsUsados = new ArrayList<PowerUp>();
        PowerUp powerUp1 = new Base();
        PowerUp powerUp2 = new Anulador();
        PowerUp powerUp3 = new Anulador();
        PowerUp powerUp4 = new Base();

        powerUpsUsados.add(powerUp1);
        powerUpsUsados.add(powerUp2);
        powerUpsUsados.add(powerUp3);
        powerUpsUsados.add(powerUp4);

        AdministradorPowerUp administradorPowerUp = new AdministradorPowerUp();

        assertEquals(administradorPowerUp.resolverPowerUps(puntajesOriginales, powerUpsUsados), puntajesEsperados);


    }

    @Test
    public void test05SeUsanDosMultiplicadores(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(3);
        puntajesOriginales.add(2);
        puntajesOriginales.add(-1);

        puntajesEsperados.add(0);
        puntajesEsperados.add(6);
        puntajesEsperados.add(2);
        puntajesEsperados.add(-3);

        ArrayList<PowerUp> powerUpsUsados = new ArrayList<PowerUp>();
        PowerUp powerUp1 = new Base();
        PowerUp powerUp2 = new Multiplicador(2);
        PowerUp powerUp3 = new Base();
        PowerUp powerUp4 = new Multiplicador(3);

        powerUpsUsados.add(powerUp1);
        powerUpsUsados.add(powerUp2);
        powerUpsUsados.add(powerUp3);
        powerUpsUsados.add(powerUp4);

        AdministradorPowerUp administradorPowerUp = new AdministradorPowerUp();

        assertEquals(administradorPowerUp.resolverPowerUps(puntajesOriginales, powerUpsUsados), puntajesEsperados);


    }

    @Test
    public void test06SeUsanDosExclusividad(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(3);
        puntajesOriginales.add(0);
        puntajesOriginales.add(0);

        puntajesEsperados.add(0);
        puntajesEsperados.add(12);
        puntajesEsperados.add(0);
        puntajesEsperados.add(0);

        ArrayList<PowerUp> powerUpsUsados = new ArrayList<PowerUp>();
        PowerUp powerUp1 = new Exclusividad();
        PowerUp powerUp2 = new Exclusividad();
        PowerUp powerUp3 = new Base();
        PowerUp powerUp4 = new Base();

        powerUpsUsados.add(powerUp1);
        powerUpsUsados.add(powerUp2);
        powerUpsUsados.add(powerUp3);
        powerUpsUsados.add(powerUp4);

        AdministradorPowerUp administradorPowerUp = new AdministradorPowerUp();

        assertEquals(administradorPowerUp.resolverPowerUps(puntajesOriginales, powerUpsUsados), puntajesEsperados);


    }

    @Test
    public void test07SeUsanUnAnuldaorYUnMultiplicador(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(2);
        puntajesOriginales.add(4);
        puntajesOriginales.add(3);

        puntajesEsperados.add(0);
        puntajesEsperados.add(0);
        puntajesEsperados.add(4);
        puntajesEsperados.add(0);

        ArrayList<PowerUp> powerUpsUsados = new ArrayList<PowerUp>();
        PowerUp powerUp1 = new Base();
        PowerUp powerUp2 = new Multiplicador(2);
        PowerUp powerUp3 = new Anulador();
        PowerUp powerUp4 = new Base();

        powerUpsUsados.add(powerUp1);
        powerUpsUsados.add(powerUp2);
        powerUpsUsados.add(powerUp3);
        powerUpsUsados.add(powerUp4);

        AdministradorPowerUp administradorPowerUp = new AdministradorPowerUp();

        assertEquals(administradorPowerUp.resolverPowerUps(puntajesOriginales, powerUpsUsados), puntajesEsperados);

    }

    @Test
    public void test08SeUsanUnAnuldaorYUnaExclusividad(){
        ArrayList<Integer> puntajesEsperados = new ArrayList<Integer>();
        ArrayList<Integer> puntajesOriginales = new ArrayList<Integer>();

        puntajesOriginales.add(0);
        puntajesOriginales.add(3);
        puntajesOriginales.add(2);
        puntajesOriginales.add(1);

        puntajesEsperados.add(0);
        puntajesEsperados.add(6);
        puntajesEsperados.add(0);
        puntajesEsperados.add(0);

        ArrayList<PowerUp> powerUpsUsados = new ArrayList<PowerUp>();
        PowerUp powerUp1 = new Base();
        PowerUp powerUp2 = new Anulador();
        PowerUp powerUp3 = new Base();
        PowerUp powerUp4 = new Exclusividad();

        powerUpsUsados.add(powerUp1);
        powerUpsUsados.add(powerUp2);
        powerUpsUsados.add(powerUp3);
        powerUpsUsados.add(powerUp4);

        AdministradorPowerUp administradorPowerUp = new AdministradorPowerUp();

        assertEquals(administradorPowerUp.resolverPowerUps(puntajesOriginales, powerUpsUsados), puntajesEsperados);

    }
}
