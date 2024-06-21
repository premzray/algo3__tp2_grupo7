package edu.fiuba.algo3.modelo;

public abstract class PreguntaTp implements Pregunta {

    public final String textoPregunta;
    public final String id;
    public final String textoRespuesta;
    public final Respuestas respuestasPosibles;
    public final Respuestas respuestaCorrecta;
    public final TipoPuntaje tipoPuntaje;
    public final String tematica;

    public PreguntaTp(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, TipoPuntaje tipoPuntaje, String tematica, String textoRespuesta, String id, String textoPregunta){
        this.tipoPuntaje = tipoPuntaje;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestasPosibles = respuestasPosibles;
        this.tematica = tematica;
        this.id = id;
        this.textoRespuesta = textoRespuesta;
        this.textoPregunta = textoPregunta;
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
