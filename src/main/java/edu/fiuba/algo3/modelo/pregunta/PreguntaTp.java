package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.exception.RespuestaInvalidaException;
import edu.fiuba.algo3.modelo.pregunta.puntaje.TipoPuntaje;

public abstract class PreguntaTp implements Pregunta {

    public final String textoPregunta;
    public String tipoPregunta;
    public final int id;
    public final String textoRespuesta;
    public final Respuestas respuestasPosibles;
    public final Respuestas respuestaCorrecta;
    public final TipoPuntaje tipoPuntaje;
    public final String tematica;

    public PreguntaTp(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, String tipoPuntaje, String tematica, String textoRespuesta, int id, String textoPregunta){
        this.tipoPuntaje = TipoPuntaje.conTipo(tipoPuntaje);
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestasPosibles = respuestasPosibles;
        this.tematica = tematica;
        this.id = id;
        this.textoRespuesta = textoRespuesta;
        this.textoPregunta = textoPregunta;
    }

    @Override
    public String tipo(){
        return tipoPregunta;
    }

    @Override
    public String tematica(){
        return tematica;
    }

    @Override

    public String getEnunciado(){
        return this.textoPregunta;
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
    public abstract int puntuarRespuesta(Respuestas respuestaJugador) throws RespuestaInvalidaException;
}
