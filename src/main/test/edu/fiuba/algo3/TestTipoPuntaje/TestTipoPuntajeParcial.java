package edu.fiuba.algo3.TestTipoPuntaje;

import edu.fiuba.algo3.modelo.powerup.Anulador;
import edu.fiuba.algo3.modelo.powerup.Exclusividad;
import edu.fiuba.algo3.modelo.powerup.Multiplicador;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.puntaje.Parcial;
import edu.fiuba.algo3.modelo.pregunta.puntaje.TipoPuntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTipoPuntajeParcial {

    @Test
    public void test01EvaluarSiUnAnularEsValido(){
        boolean respuestaEsperada = true;
        TipoPuntaje tipoPuntaje = new Parcial();
        PowerUp powerUp = new Anulador();

        assertEquals(tipoPuntaje.powerUpValido(powerUp), respuestaEsperada);
    }

    @Test
    public void test02EvaluarSiUnMultiplicadorEsValido(){
        boolean respuestaEsperada = false;
        TipoPuntaje tipoPuntaje = new Parcial();
        PowerUp powerUp = new Multiplicador(2);

        assertEquals(tipoPuntaje.powerUpValido(powerUp), respuestaEsperada);
    }

    @Test
    public void test03EvaluarSiUnExclusividadEsValido(){
        boolean respuestaEsperada = true;
        TipoPuntaje tipoPuntaje = new Parcial();
        PowerUp powerUp = new Exclusividad();

        assertEquals(tipoPuntaje.powerUpValido(powerUp), respuestaEsperada);
    }
}
