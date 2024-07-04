package edu.fiuba.algo3.TestPreguntas;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import edu.fiuba.algo3.modelo.pregunta.exception.RespuestaInvalidaException;
import edu.fiuba.algo3.modelo.pregunta.puntaje.TipoPuntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntaTpOrderedChoice {
    @Test
    public void test01ClasicoRespondeBien() throws RespuestaInvalidaException {

        int puntajeEsperado = 1;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "ORDERED CHOICE";
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
        rJugador.add(r1);
        rJugador.add(r2);
        rJugador.add(r4);

        rCorrectas.add(r3);
        rCorrectas.add(r5);
        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r4);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

    @Test
    public void test02ClasicoRespondeMal() throws RespuestaInvalidaException {

        int puntajeEsperado = 0;
        Respuestas rJugador = new Respuestas();
        Respuestas rCorrectas = new Respuestas();
        Respuestas rPosibles = new Respuestas();
        String nombre = "ORDERED CHOICE";
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
        rJugador.add(r1);
        rJugador.add(r5);
        rJugador.add(r2);
        rJugador.add(r4);

        rCorrectas.add(r3);
        rCorrectas.add(r5);
        rCorrectas.add(r1);
        rCorrectas.add(r2);
        rCorrectas.add(r4);

        rPosibles.add(r1);
        rPosibles.add(r2);
        rPosibles.add(r3);
        rPosibles.add(r4);
        rPosibles.add(r5);

        Pregunta p = Pregunta.deTipo(nombre, rCorrectas, rPosibles, nombrePuntaje, tematica, textoRespuesta, id, textoPregunta);

        assertEquals(p.puntuarRespuesta(rJugador), puntajeEsperado);

    }

}
