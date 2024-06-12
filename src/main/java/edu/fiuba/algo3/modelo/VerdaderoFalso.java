package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso extends Pregunta{


    public VerdaderoFalso(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje){
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
