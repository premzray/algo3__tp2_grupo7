package edu.fiuba.algo3.TestPreguntas;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Respuestas;
import edu.fiuba.algo3.modelo.*;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVerdaderoFalso {

    @Test
    public void Test01ClasicoRespondeBien(){

        int puntajeEsperado = 1;
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        Respuestas rJugador = new Respuestas();

        String r1 = "V";
        String r2 = "F";

        rCorrectas.add(r1);

        rPosibles.add(r1);
        rPosibles.add(r2);

        rJugador.add(r1);

        Pregunta p = new VerdaderoFalso(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void Test02ClasicoRespondeMal(){

        int puntajeEsperado = 0;
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        Respuestas rJugador = new Respuestas();

        String r1 = "V";
        String r2 = "F";

        rCorrectas.add(r1);

        rPosibles.add(r1);
        rPosibles.add(r2);

        rJugador.add(r2);

        Pregunta p = new VerdaderoFalso(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void Test03PenalidadRespondeBien(){

        int puntajeEsperado = 1;
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        Respuestas rJugador = new Respuestas();

        String r1 = "V";
        String r2 = "F";

        rCorrectas.add(r1);

        rPosibles.add(r1);
        rPosibles.add(r2);

        rJugador.add(r1);

        Pregunta p = new VerdaderoFalso(rCorrectas, rPosibles, new Penalidad(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }

    @Test
    public void Test04PenalidadRespondeMal(){

        int puntajeEsperado = -1;
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        Respuestas rJugador = new Respuestas();

        String r1 = "V";
        String r2 = "F";

        rCorrectas.add(r1);

        rPosibles.add(r1);
        rPosibles.add(r2);

        rJugador.add(r2);

        Pregunta p = new VerdaderoFalso(rCorrectas, rPosibles, new Penalidad(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }
}
