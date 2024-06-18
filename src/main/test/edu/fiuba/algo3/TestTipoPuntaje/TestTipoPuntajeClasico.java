package edu.fiuba.algo3.TestTipoPuntaje;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTipoPuntajeClasico {

    @Test
    public void test01EvaluarSiUnAnularEsValido(){
        boolean respuestaEsperada = true;
        TipoPuntaje tipoPuntaje = new Clasico();
        PowerUp powerUp = new Anulador();

        assertEquals(tipoPuntaje.powerUpValido(powerUp), respuestaEsperada);
    }

    @Test
    public void test02EvaluarSiUnMultiplicadorEsValido(){
        boolean respuestaEsperada = false;
        TipoPuntaje tipoPuntaje = new Clasico();
        PowerUp powerUp = new Multiplicador(2);

        assertEquals(tipoPuntaje.powerUpValido(powerUp), respuestaEsperada);
    }

    @Test
    public void test03EvaluarSiUnExclusividadEsValido(){
        boolean respuestaEsperada = true;
        TipoPuntaje tipoPuntaje = new Clasico();
        PowerUp powerUp = new Exclusividad();

        assertEquals(tipoPuntaje.powerUpValido(powerUp), respuestaEsperada);
    }
}
