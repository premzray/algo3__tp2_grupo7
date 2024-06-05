package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVerdaderoFalso {

    @Test
    public void Test01ClasicoRespondeBien(){

        int puntajeEsperado = 1;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();

        List<Respuestas> rJugador = new List<Respuestas>();
        List<Respuestas> rCorrectas = new List<Respuestas>();
        List<Respuestas> rPosibles = new List<Respuestas>();

        rJugador.add(r1);
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);

        Pregunta p = new VerdaderoFalso(new Clasico(), rCorrectas, rPosibles);

        assertEquals(p.puntuar(rJugador), puntajeEsperado);

    }

    @Test
    public void Test02ClasicoRespondeMal(){

        int puntajeEsperado = 0;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();

        List<Respuestas> rJugador = new List<Respuestas>();
        List<Respuestas> rCorrectas = new List<Respuestas>();
        List<Respuestas> rPosibles = new List<Respuestas>();

        rJugador.add(r2);
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);

        Pregunta p = new VerdaderoFalso(new Clasico(), rCorrectas, rPosibles);

        assertEquals(p.puntuar(rJugador), puntajeEsperado);

    }

    @Test
    public void Test03PenalidadRespondeBien(){

        int puntajeEsperado = 1;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();

        List<Respuestas> rJugador = new List<Respuestas>();
        List<Respuestas> rCorrectas = new List<Respuestas>();
        List<Respuestas> rPosibles = new List<Respuestas>();

        rJugador.add(r1);
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);

        Pregunta p = new VerdaderoFalso(new Penalidad(), rCorrectas, rPosibles);

        assertEquals(p.puntuar(rJugador), puntajeEsperado);
    }

    @Test
    public void Test04PenalidadRespondeMal(){

        int puntajeEsperado = -1;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();

        List<Respuestas> rJugador = new List<Respuestas>();
        List<Respuestas> rCorrectas = new List<Respuestas>();
        List<Respuestas> rPosibles = new List<Respuestas>();

        rJugador.add(r2);
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);

        Pregunta p = new VerdaderoFalso(new Penalidad(), rCorrectas, rPosibles);

        assertEquals(p.puntuar(rJugador), puntajeEsperado);
    }
}
