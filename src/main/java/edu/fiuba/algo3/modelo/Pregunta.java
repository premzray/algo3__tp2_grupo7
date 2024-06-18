package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Pregunta{

    public final Respuestas respuestasPosibles;
    public final Respuestas respuestaCorrecta;
    public final TipoPuntaje tipoPuntaje;
    public final String tematica;

    public Pregunta(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje, String tematica){
        this.tipoPuntaje = tipoPuntaje;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestasPosibles = respuestasPosibles;
        this.tematica = tematica;
    }

    public Respuestas getRespuestasPosibles() {
        return respuestasPosibles;
    }

    public boolean powerUpValido(PowerUp powerUp) {
        return this.tipoPuntaje.powerUpValido(powerUp);
    } //le pregunta a su tipoDePuntaje si se puede usar x powerUp

    public abstract int puntuarRespuesta(Respuestas respuestaJugador);
}
