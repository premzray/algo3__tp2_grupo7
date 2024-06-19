package edu.fiuba.algo3.TestJugador;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadorTp {

    @Test
    public void test01JugadorTieneMultiplicarX2(){
        boolean resultadoEsperado = true;
        PowerUp powerUp = new Multiplicador(2);
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(powerUp);

        Jugador jugador = new JugadorTp("nombre para test", powerUps, 0);

        assertEquals(jugador.tenesPowerUp(powerUp), resultadoEsperado );
    }

    @Test
    public void test02JugadorTieneMultiplicarX3(){
        boolean resultadoEsperado = true;
        PowerUp powerUp = new Multiplicador(3);
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(powerUp);

        Jugador jugador = new JugadorTp("nombre para test", powerUps, 0);

        assertEquals(jugador.tenesPowerUp(powerUp), resultadoEsperado );
    }

    @Test
    public void test03JugadorTieneAnulador(){
        boolean resultadoEsperado = true;
        PowerUp powerUp = new Anulador();
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(powerUp);

        Jugador jugador = new JugadorTp("nombre para test", powerUps, 0);

        assertEquals(jugador.tenesPowerUp(powerUp), resultadoEsperado );
    }

    @Test
    public void test04JugadorTieneExclusividad(){
        boolean resultadoEsperado = true;
        PowerUp powerUp = new Exclusividad();
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(powerUp);

        Jugador jugador = new JugadorTp("nombre para test", powerUps, 0);

        assertEquals(jugador.tenesPowerUp(powerUp), resultadoEsperado );
    }

    @Test
    public void test05JugadorNoTieneMultiplicarX2(){
        boolean resultadoEsperado = false;
        PowerUp powerUp1 = new Multiplicador(2);
        PowerUp powerUp2 = new Exclusividad();
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(powerUp2);


        Jugador jugador = new JugadorTp("nombre para test", powerUps, 0);

        assertEquals(jugador.tenesPowerUp(powerUp1), resultadoEsperado );
    }

    @Test
    public void test06JugadorNoTieneMultiplicarX3(){
        boolean resultadoEsperado = false;
        PowerUp powerUp1 = new Multiplicador(3);
        PowerUp powerUp2 = new Multiplicador(2);
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(powerUp2);

        Jugador jugador = new JugadorTp("nombre para test", powerUps, 0);

        assertEquals(jugador.tenesPowerUp(powerUp1), resultadoEsperado );
    }

    @Test
    public void test07JugadorNoTieneAnulador(){
        boolean resultadoEsperado = false;
        PowerUp powerUp1 = new Anulador();
        PowerUp powerUp2 = new Exclusividad();
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(powerUp2);

        Jugador jugador = new JugadorTp("nombre para test", powerUps, 0);

        assertEquals(jugador.tenesPowerUp(powerUp1), resultadoEsperado );
    }

    @Test
    public void test08JugadorNoTieneExclusividad(){
        boolean resultadoEsperado = false;
        PowerUp powerUp1 = new Exclusividad();
        PowerUp powerUp2 = new Multiplicador(3);
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(powerUp2);

        Jugador jugador = new JugadorTp("nombre para test", powerUps, 0);

        assertEquals(jugador.tenesPowerUp(powerUp1), resultadoEsperado );
    }

    @Test
    public void test09JugadorTieneSiempreBase(){
        boolean resultadoEsperado = true;
        PowerUp powerUp1 = new Base();
        PowerUp powerUp2 = new Exclusividad();
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(powerUp2);

        Jugador jugador = new JugadorTp("nombre para test", powerUps, 0);

        assertEquals(jugador.tenesPowerUp(powerUp1), resultadoEsperado );
    }

    @Test
    public void test10JugadorUsaMultiplicadorX2(){
        boolean resultadoEsperado = true;
        boolean resultadoDado = true;
        ArrayList<PowerUp> powerUpsEsperados = new ArrayList<PowerUp>();
        powerUpsEsperados.add(new Multiplicador(3));
        powerUpsEsperados.add(new Exclusividad());
        powerUpsEsperados.add(new Exclusividad());
        powerUpsEsperados.add(new Anulador());

        Jugador jugador = new JugadorTp("nombre para test");
        PowerUp powerUpUsado = new Multiplicador(2);

        jugador.usastePowerUp(powerUpUsado);

        for(int i=0; i<=powerUpsEsperados.size()-1; i++){
            if(!powerUpsEsperados.get(i).equals(jugador.getPowerUps().get(i))){
                resultadoDado  = false;
            }
        }

        assertEquals(resultadoDado, resultadoEsperado);

    }

    @Test
    public void test11JugadorUsaMultiplicadorX3(){
        boolean resultadoEsperado = true;
        boolean resultadoDado = true;
        ArrayList<PowerUp> powerUpsEsperados = new ArrayList<PowerUp>();
        powerUpsEsperados.add(new Multiplicador(2));
        powerUpsEsperados.add(new Exclusividad());
        powerUpsEsperados.add(new Exclusividad());
        powerUpsEsperados.add(new Anulador());

        Jugador jugador = new JugadorTp("nombre para test");
        PowerUp powerUpUsado = new Multiplicador(3);

        jugador.usastePowerUp(powerUpUsado);

        for(int i=0; i<=powerUpsEsperados.size()-1; i++){
            if(!powerUpsEsperados.get(i).equals(jugador.getPowerUps().get(i))){
                resultadoDado  = false;
            }
        }

        assertEquals(resultadoDado, resultadoEsperado);
    }

    @Test
    public void test12JugadorUsaExclusividad(){
        boolean resultadoEsperado = true;
        boolean resultadoDado = true;
        ArrayList<PowerUp> powerUpsEsperados = new ArrayList<PowerUp>();
        powerUpsEsperados.add(new Multiplicador(2));
        powerUpsEsperados.add(new Multiplicador(3));
        powerUpsEsperados.add(new Exclusividad());
        powerUpsEsperados.add(new Anulador());

        Jugador jugador = new JugadorTp("nombre para test");
        PowerUp powerUpUsado = new Exclusividad();

        jugador.usastePowerUp(powerUpUsado);

        for(int i=0; i<=powerUpsEsperados.size()-1; i++){
            if(!powerUpsEsperados.get(i).equals(jugador.getPowerUps().get(i))){
                resultadoDado  = false;
            }
        }

        assertEquals(resultadoDado, resultadoEsperado);
    }

    @Test
    public void test13JugadorUsaAnulador(){
        boolean resultadoEsperado = true;
        boolean resultadoDado = true;
        ArrayList<PowerUp> powerUpsEsperados = new ArrayList<PowerUp>();
        powerUpsEsperados.add(new Multiplicador(2));
        powerUpsEsperados.add(new Multiplicador(3));
        powerUpsEsperados.add(new Exclusividad());
        powerUpsEsperados.add(new Exclusividad());

        Jugador jugador = new JugadorTp("nombre para test");
        PowerUp powerUpUsado = new Anulador();

        jugador.usastePowerUp(powerUpUsado);


        for(int i=0; i<=powerUpsEsperados.size()-1; i++){
            if(!powerUpsEsperados.get(i).equals(jugador.getPowerUps().get(i))){
                resultadoDado  = false;
            }
        }

        assertEquals(resultadoDado, resultadoEsperado);
    }

    @Test
    public void test14JugadorActualizaSusPuntos(){
        int resultadoEsperado = 7;
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
        PowerUp powerUp = new Exclusividad();
        powerUps.add(powerUp);

        Jugador jugador = new JugadorTp("nombre para test", powerUps, 5);

        jugador.actualizarPuntaje(2);

        assertEquals(jugador.getPuntaje(), resultadoEsperado );
    }

}
