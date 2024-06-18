package edu.fiuba.algo3.TestPreguntas;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaMultipleChoice {

    @Test
    public void Test01ClasicoRespondeBien(){

        int puntajeEsperado = 1;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r1);
        rJugador.add(r2);
        rJugador.add(r3);

        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r3);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void Test02ClasicoRespondeMalSeleccionIncorrecta(){

        int puntajeEsperado = 0;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r1);
        rJugador.add(r2);
        rJugador.add(r3);
        rJugador.add(r4);

        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r3);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }
    @Test
    public void Test03ClasicoRespondeMalPorOmision(){

        int puntajeEsperado = 0;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r1);
        rJugador.add(r2);

        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r3);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void Test04PenalidadRespondeBien(){

        int puntajeEsperado = 3;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r1);
        rJugador.add(r2);
        rJugador.add(r3);

        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r3);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Penalidad(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }

    @Test
    public void Test05PenalidadRespondeMalTotal(){

        int puntajeEsperado = -5;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r5);

        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r3);
        rCorrectas.add(r4);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Penalidad(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }
    @Test
    public void Test06PenalidadRespondeMalParcial(){

        int puntajeEsperado = 1;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r1);
        rJugador.add(r2);
        rJugador.add(r4);
        rJugador.add(r5);

        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r3);
        rCorrectas.add(r5);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Penalidad(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }

    @Test
    public void Test07ParcialRespondeBienTotal(){

        int puntajeEsperado = 3;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r2);
        rJugador.add(r4);
        rJugador.add(r5);

        rCorrectas.add(r2);
        rCorrectas.add(r4);
        rCorrectas.add(r5);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Parcial(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }

    @Test
    public void Test08ParcialRespondeBienParcial(){

        int puntajeEsperado = 3;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r2);
        rJugador.add(r4);
        rJugador.add(r5);

        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r4);
        rCorrectas.add(r5);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Parcial(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }

    @Test
    public void Test09ParcialRespondeMal(){

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
        rJugador.add(r5);

        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r4);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Parcial(), "Tematica de prueba");

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }
}



