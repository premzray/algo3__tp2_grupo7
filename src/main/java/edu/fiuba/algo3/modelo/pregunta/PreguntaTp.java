package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.puntaje.TipoPuntaje;
import edu.fiuba.algo3.Utilidades.ObservableConcreto;

public abstract class PreguntaTp extends ObservableConcreto implements Pregunta {

    public final String textoPregunta;
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
    public void mostrarPregunta(){
        notifyObservers(this);
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
