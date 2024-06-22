package edu.fiuba.algo3.modelo;

public class MultipleChoice extends PreguntaTp {

    public MultipleChoice(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje, String tematica, String textoRespuesta, String id, String textoPregunta) {
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
