package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Turno {

    public static Turno conJugadores(ArrayList<Jugador> jugadores){
        return new TurnoTp(jugadores);
    }

    public void jugarTurno(Pregunta pregunta);
}
