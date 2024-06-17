package edu.fiuba.algo3.modelo;

public abstract class Pregunta{

    public final Respuestas respuestasPosibles;
    public final Respuestas respuestaCorrecta;
    public final TipoPuntaje tipoPuntaje;

    public Pregunta(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje){
        this.tipoPuntaje = tipoPuntaje;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestasPosibles = respuestasPosibles;
    }


    public abstract int puntuarRespuesta(Respuestas respuestaJugador);
}
