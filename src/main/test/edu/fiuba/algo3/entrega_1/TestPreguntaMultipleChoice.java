package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaMultipleChoice {

    @Test
    public void Test01ClasicoRespondeBien(){

        int puntajeEsperado = 1;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();
        Respuesta r3 = new Respuesta();
        Respuesta r4 = new Respuesta();
        Respuesta r5 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

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

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Clasico());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void Test02ClasicoRespondeMalSeleccionIncorrecta(){

        int puntajeEsperado = 0;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();
        Respuesta r3 = new Respuesta();
        Respuesta r4 = new Respuesta();
        Respuesta r5 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

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

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Clasico());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }
    @Test
    public void Test03ClasicoRespondeMalPorOmision(){

        int puntajeEsperado = 0;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();
        Respuesta r3 = new Respuesta();
        Respuesta r4 = new Respuesta();
        Respuesta r5 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

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

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Clasico());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void Test04PenalidadRespondeBien(){

        int puntajeEsperado = 3;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();
        Respuesta r3 = new Respuesta();
        Respuesta r4 = new Respuesta();
        Respuesta r5 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

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

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Penalidad());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }

    @Test
    public void Test05PenalidadRespondeMalTotal(){

        int puntajeEsperado = -5;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();
        Respuesta r3 = new Respuesta();
        Respuesta r4 = new Respuesta();
        Respuesta r5 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

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

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Penalidad());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }
    @Test
    public void Test06PenalidadRespondeMalParcial(){

        int puntajeEsperado = 1;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();
        Respuesta r3 = new Respuesta();
        Respuesta r4 = new Respuesta();
        Respuesta r5 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

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

        Pregunta p = new MultipleChoice(rCorrectas, rPosibles, new Penalidad());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }
}



