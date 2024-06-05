package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalso extends Pregunta{

    public VerdaderoFalso(ArrayList<Respuesta> respuestaCorrecta, ArrayList<Respuesta> respuestasPosibles, TipoPuntaje tipoPuntaje){
        this.tipoPuntaje = tipoPuntaje;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestasPosibles = respuestasPosibles;
    }

    @Override
    public int puntuarRespuesta(ArrayList<Respuesta> respuestaJugador) {
        return this.tipoPuntaje.puntuar(this.respuestaCorrecta, respuestaJugador);
    }
}
