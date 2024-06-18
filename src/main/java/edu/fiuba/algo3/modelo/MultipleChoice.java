package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoice extends Pregunta{

    public MultipleChoice(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje, String tematica){
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica);
    }

    @Override
    public int puntuarRespuesta(Respuestas respuestaJugador) {
        if(respuestaJugador.esMayorQue(respuestasPosibles)){
            //exepcion
        }

        return tipoPuntaje.puntuar(respuestaJugador.cuantasContiene(respuestaCorrecta), respuestaJugador.cuantasNoContiene(respuestaCorrecta), respuestaCorrecta.size());
    }
}
