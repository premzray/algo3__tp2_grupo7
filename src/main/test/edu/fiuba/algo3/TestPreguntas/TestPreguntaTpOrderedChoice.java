package edu.fiuba.algo3.TestPreguntas;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaTpOrderedChoice {
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

        rJugador.add(r3);
        rJugador.add(r5);
        rJugador.add(r1);
        rJugador.add(r2);
        rJugador.add(r4);

        rCorrectas.add(r3);
        rCorrectas.add(r5);
        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r4);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        PreguntaTp p = new OrderedChoice(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void test02ClasicoRespondeMal(){

        int puntajeEsperado = 0;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r3);
        rJugador.add(r1);
        rJugador.add(r5);
        rJugador.add(r2);
        rJugador.add(r4);

        rCorrectas.add(r3);
        rCorrectas.add(r5);
        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r4);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        PreguntaTp p = new OrderedChoice(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

}
