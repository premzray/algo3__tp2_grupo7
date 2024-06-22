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
        String nombre = "VERDADERO FALSO";
        String nombrePuntaje = "CLASICO";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        String id = "ID PRUEBAS";
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

        String r1 = "V";
        String r2 = "F";
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rJugador.add(r1);

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
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
        String nombre = "VERDADERO FALSO";
        String nombrePuntaje = "PENALIDAD";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        String id = "ID PRUEBAS";
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

        String r1 = "V";
        String r2 = "F";
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rJugador.add(r1);

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
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
        String nombre = "VERDADERO FALSO";
        String nombrePuntaje = "CLASICO";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        String id = "ID PRUEBAS";
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

        String r1 = "V";
        String r2 = "F";
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rJugador.add(r2);

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
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
        String nombre = "VERDADERO FALSO";
        String nombrePuntaje = "PENALIDAD";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        String id = "ID PRUEBAS";
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

        String r1 = "V";
        String r2 = "F";
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rJugador.add(r2);

        Pregunta pregunta = Pregunta.deTipo(nombre, rCorrectas, rPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
        Jugador jugador = new JugadorTp("nombre de pruebas");
        Jugada jugada = new JugadaTp(jugador);
        PowerUp base = new Base();

        jugada.actualizarJugada(pregunta);
        jugada.registrarJugada(rJugador, base);

        assertEquals(jugada.getPuntaje(), puntajeEsperado);

    }
}
