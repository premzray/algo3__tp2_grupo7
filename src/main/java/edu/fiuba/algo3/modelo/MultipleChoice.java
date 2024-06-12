package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoice extends Pregunta{

    public MultipleChoice(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje){
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje);
    }

    @Override
    public int puntuarRespuesta(Respuestas respuestaJugador) {
        if(respuestaJugador.esMayorQue(respuestasPosibles)){
            //exepcion
        }

        return tipoPuntaje.puntuar(respuestaJugador.cuantasContiene(respuestaCorrecta), (respuestaJugador.cuantasNoContiene(respuestaCorrecta) + respuestaCorrecta.cuantasNoContiene(respuestaJugador)));
    }
}
