package edu.fiuba.algo3.modelo;

public interface Pregunta {

    public Respuestas getRespuestasPosibles();

    public boolean powerUpValido(PowerUp powerUp);

    public abstract int puntuarRespuesta(Respuestas respuestaJugador);
}
