package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Pregunta{

    public ArrayList<Respuesta> respuestasPosibles;
    public ArrayList<Respuesta> respuestaCorrecta;
    public TipoPuntaje tipoPuntaje;

    public Pregunta(ArrayList<Respuesta> respuestaCorrecta, ArrayList<Respuesta> respuestasPosibles, TipoPuntaje tipoPuntaje){
        this.tipoPuntaje = tipoPuntaje;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestasPosibles = respuestasPosibles;
    }


    public abstract int puntuarRespuesta(ArrayList<Respuesta> respuestaJugador);
}
