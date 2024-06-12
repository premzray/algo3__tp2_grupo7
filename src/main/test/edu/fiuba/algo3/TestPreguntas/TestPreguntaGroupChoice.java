package edu.fiuba.algo3.TestPreguntas;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaGroupChoice {

    @Test
    public void test01ClasicoRespondeBien(){
        int puntajeEsperado = 1;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";
        String r6 = "6";
        String corte = "corte";

        rJugador.add(r1);
        rJugador.add(r3);
        rJugador.add(r5);
        rJugador.add(corte);
        rJugador.add(r2);
        rJugador.add(r4);
        rJugador.add(r6);

        rCorrectas.add(r1);
        rCorrectas.add(r3);
        rCorrectas.add(r5);
        rCorrectas.add(corte);
        rCorrectas.add(r2);
        rCorrectas.add(r4);
        rCorrectas.add(r6);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);
        rPosibles.add(r6);

        Pregunta p = new GroupChoice(rCorrectas, rPosibles, new Clasico());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void test02ClasicoRespondeMal() {
        int puntajeEsperado = 0;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";
        String r6 = "6";
        String corte = "corte";

        rJugador.add(r3);
        rJugador.add(r5);
        rJugador.add(corte);
        rJugador.add(r1);
        rJugador.add(r2);
        rJugador.add(r4);
        rJugador.add(r6);

        rCorrectas.add(r1);
        rCorrectas.add(r3);
        rCorrectas.add(r5);
        rCorrectas.add(corte);
        rCorrectas.add(r2);
        rCorrectas.add(r4);
        rCorrectas.add(r6);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);
        rPosibles.add(r6);

        Pregunta p = new GroupChoice(rCorrectas, rPosibles, new Clasico());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }
}
