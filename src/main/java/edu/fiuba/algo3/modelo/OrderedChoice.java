package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{

    public OrderedChoice(ArrayList<Respuesta> respuestaCorrecta, ArrayList<Respuesta> respuestasPosibles, TipoPuntaje tipoPuntaje){
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje);
    }

    @Override
    public int puntuarRespuesta(ArrayList<Respuesta> respuestaJugador) {
        int correcto = 1;
        int incorrecto = 0;
        if(respuestaJugador.size()!=respuestaCorrecta.size()){
            //exepcion
        }
        for(int i = 0 ;i < respuestaJugador.size(); i++){
            if(respuestaJugador.get(i)!=respuestaCorrecta.get(i)){
                correcto = 0;
                incorrecto = 1;
            }
        }

        return tipoPuntaje.puntuar(correcto,incorrecto);
    }
}
