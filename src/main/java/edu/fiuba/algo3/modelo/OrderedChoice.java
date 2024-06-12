package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{

    public OrderedChoice(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje){
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje);
    }

    @Override
    public int puntuarRespuesta(Respuestas respuestaJugador) {
        if(!respuestaJugador.equalSize(respuestaCorrecta)){
            //exepcion
        }

        return tipoPuntaje.puntuar(respuestaJugador.cuantasIguales(respuestaCorrecta), respuestaJugador.cuantasDiferentes(respuestaCorrecta));
    }
}
