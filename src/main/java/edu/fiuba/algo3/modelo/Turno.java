package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Turno {
    ArrayList<Jugada> jugadas;
    AdministradorPowerUp administradorPowerUp;

    public Turno(ArrayList<Jugador> jugadores){
        this.administradorPowerUp = new AdministradorPowerUp();
        this.jugadas = new ArrayList<Jugada>();

        for(Jugador jugador: jugadores){
            this.jugadas.add(new Jugada(jugador));
        }
    }

    private ArrayList<Integer> listaPuntos(){
        ArrayList<Integer> puntos = new ArrayList<Integer>();

        for(Jugada jugada: jugadas){
            puntos.add(jugada.getPuntaje());
        }

        return puntos;
    }

    private ArrayList<PowerUp> listaPowerUps(){
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();

        for(Jugada jugada: jugadas){
            powerUps.add(jugada.getPowerUp());
        }

        return powerUps;
    }

    public void jugarTurno(Pregunta pregunta) {

        for (Jugada jugada : jugadas) {
            jugada.actualizarJugada(pregunta);
        } // se encarga de otorgar powerUp y puntos base segun respuesta de jugador

        ArrayList<Integer> puntosActualizados = this.administradorPowerUp.resolverPowerUps(this.listaPuntos(), this.listaPowerUps());
        // se encarga de modificar los puntos base con los powerUps jugados

        int i = 0;
        for (Jugada jugada : jugadas) {
            jugada.actualizarPuntos(puntosActualizados.get(i));
            jugada.otorgarPuntos();
            i++;
        } // se encarga de otorgar los puntos finales a cada jugador

        //notificar fin de turno a observadores
    }
}
