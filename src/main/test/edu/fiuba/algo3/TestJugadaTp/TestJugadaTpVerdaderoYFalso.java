package edu.fiuba.algo3.TestJugadaTp;

import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import edu.fiuba.algo3.modelo.juego.Jugada.JugadaTp;
import edu.fiuba.algo3.modelo.juego.Jugada.exceptions.PowerUpInvalido;
import edu.fiuba.algo3.modelo.juego.jugador.Jugador;
import edu.fiuba.algo3.modelo.juego.jugador.JugadorTp;
import edu.fiuba.algo3.modelo.powerup.Base;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import edu.fiuba.algo3.modelo.pregunta.exception.RespuestaInvalidaException;
import edu.fiuba.algo3.modelo.pregunta.puntaje.TipoPuntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadaTpVerdaderoYFalso {

    @Test
    public void test01JugadorNoJuegaPowerUpYRespondeCorrectoVerdaderoYFalsoClasico() throws RespuestaInvalidaException, PowerUpInvalido {
        int puntajeEsperado = 1;
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        Respuestas rJugador = new Respuestas();
        String nombre = "VERDADERO FALSO";
        String nombrePuntaje = "CLASICO";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

        String r1 = "V";
        String r2 = "F";
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rJugador.add(r1);

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
    public void test02JugadorNoJuegaPowerUpYRespondeCorrectoVerdaderoYFalsoPenalidad() throws RespuestaInvalidaException, PowerUpInvalido {
        int puntajeEsperado = 1;
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        Respuestas rJugador = new Respuestas();
        String nombre = "VERDADERO FALSO";
        String nombrePuntaje = "PENALIDAD";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

        String r1 = "V";
        String r2 = "F";
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rJugador.add(r1);

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
    public void test03JugadorNoJuegaPowerUpYRespondeIncorrectoVerdaderoYFalsoClasico() throws PowerUpInvalido, RespuestaInvalidaException {
        int puntajeEsperado = 0;
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        Respuestas rJugador = new Respuestas();
        String nombre = "VERDADERO FALSO";
        String nombrePuntaje = "CLASICO";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

        String r1 = "V";
        String r2 = "F";
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rJugador.add(r2);

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
    public void test04JugadorNoJuegaPowerUpYRespondeIncorrectoVerdaderoYFalsoPenalidad() throws RespuestaInvalidaException, PowerUpInvalido {
        int puntajeEsperado = -1;
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        Respuestas rJugador = new Respuestas();
        String nombre = "VERDADERO FALSO";
        String nombrePuntaje = "PENALIDAD";
        TipoPuntaje tipoPuntaje = TipoPuntaje.conTipo(nombrePuntaje);
        String tematica = "TEMATICA DE PRUEBAS";
        String textoRespuesta = "TEXTO RESPUESTA PRUEBAS";
        int id = 1;
        String textoPregunta = "TEXTO PREGUNTA PRUEBAS";

        String r1 = "V";
        String r2 = "F";
        rCorrectas.add(r1);
        rPosibles.add(r1);
        rPosibles.add(r2);
        rJugador.add(r2);

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
