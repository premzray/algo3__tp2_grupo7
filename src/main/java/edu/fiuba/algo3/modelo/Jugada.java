package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugada {
    private final Jugador jugador;
    private PowerUp powerUp;
    private int puntaje;

    public Jugada(Jugador jugador){
        this.jugador = jugador;
        this.powerUp = new Base();
        this.puntaje = 0;
    }

    private void setPowerUp(PowerUp nuevoPowerUp){
        this.powerUp = nuevoPowerUp;
    }

    private void setPuntaje(int nuevoPuntaje){
        this.puntaje = nuevoPuntaje;
    }

    public PowerUp getPowerUp(){
        return this.powerUp;
    }

    public int getPuntaje(){
        return this.puntaje;
    }

    public void actualizarJugada(Pregunta pregunta){

        Respuestas respuestasJugador = jugador.responder(pregunta); // recibe las respuestas del jugador
        this.setPuntaje(pregunta.puntuarRespuesta(respuestasJugador)); // actualiza el puntaje base

        PowerUp powerUpJugador = jugador.elegirPowerUp(pregunta); // recibe el powerUp usado
        this.setPowerUp(powerUpJugador); // actualiza el powerUp usado

        //notificar fin de jugada a observadores
    }

    public void actualizarPuntos(int puntosNuevos){
        this.puntaje = puntosNuevos;
    }

    public void otorgarPuntos(){
        jugador.actualizarPuntaje(puntaje);
    }

}
