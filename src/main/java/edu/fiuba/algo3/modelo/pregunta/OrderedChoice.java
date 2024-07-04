package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.pregunta.exception.RespuestaInvalidaException;

public class OrderedChoice extends PreguntaTp {


    public OrderedChoice(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, String tipoPuntaje, String tematica, String textoRespuesta, int id, String textoPregunta) {
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
        this.tipoPregunta = "ORDERED CHOICE";
    }

    @Override
    public int puntuarRespuesta(Respuestas respuestaJugador) throws RespuestaInvalidaException {
        if(!respuestaJugador.equalSize(respuestaCorrecta)){
            throw new RespuestaInvalidaException();
        }

        return tipoPuntaje.puntuar(respuestaJugador.cuantasIguales(respuestaCorrecta), respuestaJugador.cuantasDiferentes(respuestaCorrecta), respuestaCorrecta.size());
    }
}
