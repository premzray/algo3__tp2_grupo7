package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.juego.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.exception.RespuestaInvalidaException;

public class JugadaTp implements Jugada{
    private final Jugador jugador;
    private PowerUp powerUp;
    private int puntaje;
    private Pregunta pregunta;
    private boolean seJugo;

    public JugadaTp(Jugador jugador){
        this.jugador = jugador;
        this.powerUp = PowerUp.deTipo("BASE");
        this.puntaje = 0;
        this.seJugo = false;
    }

    @Override
    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public Pregunta getPregunta(){
        return this.pregunta;
    }

    @Override
    public boolean yaSeJugo(){
        return seJugo;
    } //devuelve si la jugada ya se hizo o se debe hacer

    @Override
    public void seJugo(){
        this.seJugo = true;
    } //marca la jugada como hecha

    private void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    } //setter de pregunta

    private boolean powerUpValido(PowerUp powerUpAValidar){
        return pregunta.powerUpValido(powerUpAValidar) && jugador.tenesPowerUp(powerUpAValidar);
    } //valida que el jugador tenga el powerUp y que la pregunta lo admita

    @Override
    public void seUsoPowerUp(){
        this.jugador.usastePowerUp(this.powerUp);
    } //le comunica al jugador que ya uso ese powerUp para que lo elimine

    @Override
    public void registrarRespuesta(Respuestas respuestaJugador){
        try {
            this.puntaje = this.pregunta.puntuarRespuesta(respuestaJugador);
        } catch (RespuestaInvalidaException e) {
            throw new RuntimeException(e); //Hay que decidir si se catchea aca o en el controlador
        }
    } //settea lo elegido por el jugador

    @Override
    public void registrarPowerUp(PowerUp powerUpJugador){
        if(this.powerUpValido(powerUpJugador)) {
            this.powerUp = powerUpJugador;
        } else {
            //excepcion
        }
    } //settea el powerup del jugador

    @Override
    public PowerUp getPowerUp(){
        return this.powerUp;
    } //devuelve el powerUp elegido

    @Override
    public int getPuntaje(){
        return this.puntaje;
    } //devuelve el puntaje del turno ganado o perdido

    @Override
    public void actualizarJugada(Pregunta pregunta){
        setPregunta(pregunta);
        this.seJugo = false;
    }//actualiza la pregunta actual y el estado a no jugado

    @Override
    public void actualizarPuntos(int puntosNuevos){
        this.puntaje = puntosNuevos;
    } //actualiza nuevos puntos

    @Override
    public void otorgarPuntos(){
        jugador.actualizarPuntaje(puntaje);
    } //actualiza los puntos del jugador
}
