package edu.fiuba.algo3.modelo;

public abstract class PreguntaTp implements Pregunta {

    public final Respuestas respuestasPosibles;
    public final Respuestas respuestaCorrecta;
    public final TipoPuntaje tipoPuntaje;
    public final String tematica;

    public PreguntaTp(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje, String tematica){
        this.tipoPuntaje = tipoPuntaje;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestasPosibles = respuestasPosibles;
        this.tematica = tematica;
    }

    @Override
    public Respuestas getRespuestasPosibles() {
        return respuestasPosibles;
    }

    @Override
    public boolean powerUpValido(PowerUp powerUp) {
        return this.tipoPuntaje.powerUpValido(powerUp);
    } //le pregunta a su tipoDePuntaje si se puede usar x powerUp

    @Override
    public abstract int puntuarRespuesta(Respuestas respuestaJugador);
}
