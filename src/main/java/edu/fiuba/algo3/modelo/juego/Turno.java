package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public interface Turno {

    public static Turno conJugadores(ArrayList<Jugador> jugadores){
        return new TurnoTp(jugadores);
    }

    public void actualizarTurno(Pregunta pregunta);

    public void jugarTurno();

    public ArrayList<Jugada> jugadas();

    public boolean hayProximaJugada();

    public Jugada getSiguienteJugada();
}
