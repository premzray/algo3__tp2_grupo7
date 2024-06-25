package edu.fiuba.algo3.TestJugadaTp;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.juego.JugadaTp;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.JugadorTp;
import edu.fiuba.algo3.modelo.powerup.Base;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import edu.fiuba.algo3.modelo.pregunta.puntaje.TipoPuntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadaTpMultipleChoice {

    @Test
    public void test01JugadorNoJuegaPowerUpYRespondeCorrectoMultipleChoiceClasico(){
        int puntajeEsperado = 1;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "MULTIPLE CHOICE";
        String nombrePuntaje = "CLASICO";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

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

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarRespuesta(rJugador);
        jugada.registrarPowerUp(base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test02JugadorNoJuegaPowerUpYRespondeCorrectoMultipleChoicePenalidad(){
        int puntajeEsperado = 2;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "MULTIPLE CHOICE";
        String nombrePuntaje = "PENALIDAD";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";


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

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarRespuesta(rJugador);
        jugada.registrarPowerUp(base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test03JugadorNoJuegaPowerUpYRespondeCorrectoTotalMultipleChoiceParcial(){
        int puntajeEsperado = 3;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "MULTIPLE CHOICE";
        String nombrePuntaje = "PARCIAL";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

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

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarRespuesta(rJugador);
        jugada.registrarPowerUp(base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test04JugadorNoJuegaPowerUpYRespondeCorrectoParcialMultipleChoiceParcial(){
        int puntajeEsperado = 2;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "MULTIPLE CHOICE";
        String nombrePuntaje = "PARCIAL";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

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

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarRespuesta(rJugador);
        jugada.registrarPowerUp(base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test05JugadorNoJuegaPowerUpYRespondeIncorrectoMultipleChoiceClasico(){
        int puntajeEsperado = 0;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "MULTIPLE CHOICE";
        String nombrePuntaje = "CLASICO";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

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

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarRespuesta(rJugador);
        jugada.registrarPowerUp(base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test06JugadorNoJuegaPowerUpYRespondeIncorrectoMultipleChoicePenalidad(){
        int puntajeEsperado = -2;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "MULTIPLE CHOICE";
        String nombrePuntaje = "PENALIDAD";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

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

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarRespuesta(rJugador);
        jugada.registrarPowerUp(base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test07JugadorNoJuegaPowerUpYRespondeIncorrectoTotalMultipleChoiceParcial(){
        int puntajeEsperado = 0;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "MULTIPLE CHOICE";
        String nombrePuntaje = "PARCIAL";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

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

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarRespuesta(rJugador);
        jugada.registrarPowerUp(base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);

    }

    @Test
    public void test08JugadorNoJuegaPowerUpYRespondeIncorrectoParcialMultipleChoiceParcial(){
        int puntajeEsperado = 2;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "MULTIPLE CHOICE";
        String nombrePuntaje = "PARCIAL";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

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

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarRespuesta(rJugador);
        jugada.registrarPowerUp(base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);

    }
}
