package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.pregunta.exception.RespuestaInvalidaException;

public class MultipleChoice extends PreguntaTp {

    public MultipleChoice(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, String tipoPuntaje, String tematica, String textoRespuesta, int id, String textoPregunta) {
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
        this.tipoPregunta = "MULTIPLE CHOICE";
    }

    @Override
    public int puntuarRespuesta(Respuestas respuestaJugador) throws RespuestaInvalidaException {
        if(respuestaJugador.esMayorQue(respuestasPosibles)){
           throw new RespuestaInvalidaException();
        }

        return tipoPuntaje.puntuar(respuestaJugador.cuantasContiene(respuestaCorrecta), respuestaJugador.cuantasNoContiene(respuestaCorrecta), respuestaCorrecta.size());
    }
}
