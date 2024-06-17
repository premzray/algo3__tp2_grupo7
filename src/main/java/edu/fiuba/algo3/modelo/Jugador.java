package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private int puntaje;
    private ArrayList<PowerUp> powerUps;

    public Jugador(){
        this.puntaje = 0;
        this.powerUps = new ArrayList<PowerUp>();

        this.powerUps.add(new Multiplicador(2));
        this.powerUps.add(new Multiplicador(3));
        this.powerUps.add(new Exclusividad());
        this.powerUps.add(new Exclusividad());
        this.powerUps.add(new Anulador());
    }

    public int getPuntaje(){
        return this.puntaje;
    }

    public Respuestas responder(Pregunta pregunta){

        //notificar eleccion de respuesta
        return (new Respuestas());
    }

    public PowerUp elegirPowerUp(Pregunta pregunta){
        //notificar eleccion de powerUp
        return (new Base());
    }

    public void actualizarPuntaje(int puntajeNuevo){
        this.puntaje += puntajeNuevo;
    }
}
