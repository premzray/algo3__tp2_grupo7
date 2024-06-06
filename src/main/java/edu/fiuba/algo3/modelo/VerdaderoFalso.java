package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso extends Pregunta{


    public VerdaderoFalso(ArrayList<Respuesta> respuestaCorrecta, ArrayList<Respuesta> respuestasPosibles, TipoPuntaje tipoPuntaje){
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje);
    }

    @Override
    public int puntuarRespuesta(ArrayList<Respuesta> respuestaJugador) {
        int incorrectas = 0;
        int correctas = 0;
        if(respuestaJugador.size()>1){
            //exepcion
        }

        if(respuestaJugador.get(0) == respuestaCorrecta.get(0)){
            correctas = 1;
        }
        else{
            incorrectas = 1;
        }
        return tipoPuntaje.puntuar(correctas,incorrectas);
    }
}
