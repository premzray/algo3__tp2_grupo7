package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.*;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaVerdaderoFalso {

    @Test
    public void Test01ClasicoRespondeBien(){

        int puntajeEsperado = 1;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

        rJugador.add(r1);
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);

        Pregunta p = new VerdaderoFalso(rCorrectas, rPosibles, new Clasico());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void Test02ClasicoRespondeMal(){

        int puntajeEsperado = 0;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

        rJugador.add(r2);
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);

        Pregunta p = new VerdaderoFalso(rCorrectas, rPosibles, new Clasico());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void Test03PenalidadRespondeBien(){

        int puntajeEsperado = 1;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

        rJugador.add(r1);
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);

        Pregunta p = new VerdaderoFalso(rCorrectas, rPosibles, new Penalidad());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }

    @Test
    public void Test04PenalidadRespondeMal(){

        int puntajeEsperado = -1;
        Respuesta r1 = new Respuesta();
        Respuesta r2 = new Respuesta();

        ArrayList<Respuesta> rJugador = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rCorrectas = new ArrayList<Respuesta>();
        ArrayList<Respuesta> rPosibles = new ArrayList<Respuesta>();

        rJugador.add(r2);
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);

        Pregunta p = new VerdaderoFalso(rCorrectas, rPosibles, new Penalidad());

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);
    }
}
