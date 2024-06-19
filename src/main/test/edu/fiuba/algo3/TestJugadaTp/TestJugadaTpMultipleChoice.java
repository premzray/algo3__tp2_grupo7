package edu.fiuba.algo3.TestJugadaTp;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadaTpMultipleChoice {

    @Test
    public void test01JugadorNoJuegaPowerUpYRespondeCorrectoMultipleChoiceClasico(){
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
        rCorrectas.add(r3);
        rCorrectas.add(r5);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta pregunta = new MultipleChoice(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test02JugadorNoJuegaPowerUpYRespondeCorrectoMultipleChoicePenalidad(){
        int puntajeEsperado = 2;
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
        rCorrectas.add(r3);
        rCorrectas.add(r5);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta pregunta = new MultipleChoice(rCorrectas, rPosibles, new Penalidad(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test03JugadorNoJuegaPowerUpYRespondeCorrectoTotalMultipleChoiceParcial(){
        int puntajeEsperado = 3;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r3);
        rJugador.add(r4);
        rJugador.add(r5);
        rCorrectas.add(r3);
        rCorrectas.add(r4);
        rCorrectas.add(r5);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta pregunta = new MultipleChoice(rCorrectas, rPosibles, new Parcial(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test04JugadorNoJuegaPowerUpYRespondeCorrectoParcialMultipleChoiceParcial(){
        int puntajeEsperado = 2;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();

        String r1 = "1";
        String r2 = "2";
        String r3 = "3";
        String r4 = "4";
        String r5 = "5";

        rJugador.add(r3);
        rJugador.add(r4);
        rCorrectas.add(r3);
        rCorrectas.add(r4);
        rCorrectas.add(r5);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta pregunta = new MultipleChoice(rCorrectas, rPosibles, new Parcial(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test05JugadorNoJuegaPowerUpYRespondeIncorrectoMultipleChoiceClasico(){
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
        rCorrectas.add(r5);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta pregunta = new MultipleChoice(rCorrectas, rPosibles, new Clasico(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test06JugadorNoJuegaPowerUpYRespondeIncorrectoMultipleChoicePenalidad(){
        int puntajeEsperado = -2;
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
        rCorrectas.add(r3);
        rCorrectas.add(r5);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta pregunta = new MultipleChoice(rCorrectas, rPosibles, new Penalidad(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test07JugadorNoJuegaPowerUpYRespondeIncorrectoTotalMultipleChoiceParcial(){
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
        rCorrectas.add(r3);
        rCorrectas.add(r4);
        rCorrectas.add(r5);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta pregunta = new MultipleChoice(rCorrectas, rPosibles, new Parcial(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);

    }

    @Test
    public void test08JugadorNoJuegaPowerUpYRespondeIncorrectoParcialMultipleChoiceParcial(){
        int puntajeEsperado = 2;
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
        rCorrectas.add(r3);
        rCorrectas.add(r4);
        rCorrectas.add(r5);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta pregunta = new MultipleChoice(rCorrectas, rPosibles, new Parcial(), "Tematica de prueba");
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);

    }
}
