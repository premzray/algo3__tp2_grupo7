package edu.fiuba.algo3.TestJugadaTp;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadaTpVerdaderoYFalso {

    @Test
    public void test01JugadorNoJuegaPowerUpYRespondeCorrectoVerdaderoYFalsoClasico(){
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

        Pregunta pregunta = new VerdaderoFalso(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador,base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test02JugadorNoJuegaPowerUpYRespondeCorrectoVerdaderoYFalsoPenalidad(){
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

        Pregunta pregunta = new VerdaderoFalso(rCorrectas, rPosibles, new Penalidad(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test03JugadorNoJuegaPowerUpYRespondeIncorrectoVerdaderoYFalsoClasico(){
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

        Pregunta pregunta = new VerdaderoFalso(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test04JugadorNoJuegaPowerUpYRespondeIncorrectoVerdaderoYFalsoPenalidad(){
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

        Pregunta pregunta = new VerdaderoFalso(rCorrectas, rPosibles, new Penalidad(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);

    }
}
