package edu.fiuba.algo3.modelo.juego;

import java.util.Comparator;

public class ComparatorJugador implements Comparator<Jugador> {

    @Override
    public int compare(Jugador jugador1, Jugador jugador2) {
        return Integer.compare(jugador2.getPuntaje(), jugador1.getPuntaje());
    }
}