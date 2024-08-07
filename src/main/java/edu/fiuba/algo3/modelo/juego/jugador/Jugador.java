package edu.fiuba.algo3.modelo.juego.jugador;

import edu.fiuba.algo3.modelo.juego.jugador.exceptions.JugadorNoTienePowerUpABorrarException;
import edu.fiuba.algo3.modelo.powerup.PowerUp;

import java.util.ArrayList;

public interface Jugador {

    public static Jugador conNombre(String nombre){
        return new JugadorTp(nombre);
    }

    public boolean puntajeEsMayor(int otroPuntaje);

    public ArrayList<PowerUp> getPowerUps();

    public int getPuntaje();

    public String getName();

    public void usastePowerUp(PowerUp powerUpUsado) throws JugadorNoTienePowerUpABorrarException;

    public boolean tenesPowerUp(PowerUp powerUpAValidar);

    public void actualizarPuntaje(int puntajeNuevo);
}
