package edu.fiuba.algo3.modelo.pregunta;

public class OrderedChoice extends PreguntaTp {


    public OrderedChoice(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, String tipoPuntaje, String tematica, String textoRespuesta, int id, String textoPregunta) {
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
    }

    @Override
    public int puntuarRespuesta(Respuestas respuestaJugador) {
        if(!respuestaJugador.equalSize(respuestaCorrecta)){
            //exepcion
        }

        return tipoPuntaje.puntuar(respuestaJugador.cuantasIguales(respuestaCorrecta), respuestaJugador.cuantasDiferentes(respuestaCorrecta), respuestaCorrecta.size());
    }
}