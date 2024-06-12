package edu.fiuba.algo3.modelo;

public abstract class Pregunta{

    public Respuestas respuestasPosibles;
    public Respuestas respuestaCorrecta;
    public TipoPuntaje tipoPuntaje;

    public Pregunta(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje){
        this.tipoPuntaje = tipoPuntaje;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestasPosibles = respuestasPosibles;
    }


    public abstract int puntuarRespuesta(Respuestas respuestaJugador);
}
