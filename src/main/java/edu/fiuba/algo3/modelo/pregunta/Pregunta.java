package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.powerup.PowerUp;

public interface Pregunta {

    public static Pregunta deTipo(String nombre, Respuestas respuestaCorrecta, Respuestas respuestasPosibles, String tipoPuntaje, String tematica, String textoRespuesta, int id, String textoPregunta){
        switch (nombre){
            case "VERDADERO FALSO":
                return new VerdaderoFalso(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
            case "GROUP CHOICE":
                return new GroupChoice(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
            case "MULTIPLE CHOICE":
                return new MultipleChoice(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
            case "ORDERED CHOICE":
                return new OrderedChoice(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
            default:
                return new GroupChoice(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
                //excepcion
        }
    }

    public Respuestas getRespuestasPosibles();

    public void mostrarPregunta();

    public boolean powerUpValido(PowerUp powerUp);

    public abstract int puntuarRespuesta(Respuestas respuestaJugador);
}
