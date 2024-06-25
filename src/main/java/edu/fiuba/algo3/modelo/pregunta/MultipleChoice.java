package edu.fiuba.algo3.modelo.pregunta;

public class MultipleChoice extends PreguntaTp {

    public MultipleChoice(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, String tipoPuntaje, String tematica, String textoRespuesta, int id, String textoPregunta) {
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
    }

    @Override
    public int puntuarRespuesta(Respuestas respuestaJugador) {
        if(respuestaJugador.esMayorQue(respuestasPosibles)){
            //exepcion
        }

        return tipoPuntaje.puntuar(respuestaJugador.cuantasContiene(respuestaCorrecta), respuestaJugador.cuantasNoContiene(respuestaCorrecta), respuestaCorrecta.size());
    }
}
