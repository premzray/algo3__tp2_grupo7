package edu.fiuba.algo3.modelo.juego.turno;

import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import edu.fiuba.algo3.modelo.juego.jugador.Jugador;
import edu.fiuba.algo3.modelo.juego.jugador.exceptions.JugadorNoTienePowerUpABorrarException;
import edu.fiuba.algo3.modelo.juego.turno.exceptions.FaltanRespuestasDeJugadoresException;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public interface Turno {

    public static Turno conJugadores(ArrayList<Jugador> jugadores){
        return new TurnoTp(jugadores);
    }

    public void actualizarTurno(Pregunta pregunta);

    public void jugarTurno() throws FaltanRespuestasDeJugadoresException, JugadorNoTienePowerUpABorrarException;

    public ArrayList<Jugada> jugadas();

    public boolean hayProximaJugada();

    public Jugada getSiguienteJugada();
}
