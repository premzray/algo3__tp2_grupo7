package edu.fiuba.algo3.modelo;

public class VerdaderoFalso extends PreguntaTp {

    public VerdaderoFalso(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje, String tematica){
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica);
    }

    @Override
    public int puntuarRespuesta(Respuestas respuestaJugador) {
        if(!respuestaJugador.equalSize(respuestaCorrecta)){
            //exepcion
        }
        return tipoPuntaje.puntuar(respuestaJugador.cuantasIguales(respuestaCorrecta), respuestaJugador.cuantasDiferentes(respuestaCorrecta), respuestaCorrecta.size());
    }
}
