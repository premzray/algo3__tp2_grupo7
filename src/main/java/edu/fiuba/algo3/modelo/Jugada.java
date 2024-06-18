package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugada {
    private final Jugador jugador;
    private PowerUp powerUp;
    private int puntaje;
    private Pregunta pregunta;

    public Jugada(Jugador jugador){
        this.jugador = jugador;
        this.powerUp = new Base();
        this.puntaje = 0;
    }

    private void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public void seUsoPowerUp(){
        this.jugador.usastePowerUp(this.powerUp);
    } //le comunica al jugador que ya uso ese powerUp para que lo elimine

    public boolean powerUpValido(PowerUp powerUpAValidar){
        if (pregunta.powerUpValido(powerUpAValidar) && jugador.tenesPowerUp(powerUpAValidar)){
            return true;
        } else{
            return false;
        }
    } //valida que el jugador tenga el powerUp y que la pregunta lo admita

    public void registrarJugada(Respuestas respuestaJugador, PowerUp powerUpJugador/*/es importante que este powerUp se saque de los posibles del jugador y sea el mismo/*/){
        if(this.powerUpValido(powerUpJugador)) {
            this.powerUp = powerUpJugador;
            this.puntaje = this.pregunta.puntuarRespuesta(respuestaJugador);
        } else{
            //excepcion
        }
    } //metodo usado por el observador para settear lo elegido por el jugador

    public PowerUp getPowerUp(){
        return this.powerUp;
    }

    public int getPuntaje(){
        return this.puntaje;
    }

    public void actualizarJugada(Pregunta pregunta){
        setPregunta(pregunta);
        //notificar que un jugador debe responder una pregunta (esto settea el powerUp usado y la respuesta del jugador
        // usando registrarJugada)
    }

    public void actualizarPuntos(int puntosNuevos){
        this.puntaje = puntosNuevos;
    }

    public void otorgarPuntos(){
        jugador.actualizarPuntaje(puntaje);
    }

}
