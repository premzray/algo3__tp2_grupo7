package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Jugador {

    public boolean puntajeEsMayor(int otroPuntaje);

    public ArrayList<PowerUp> getPowerUps();

    public int getPuntaje();

    public void usastePowerUp(PowerUp powerUpUsado);

    public boolean tenesPowerUp(PowerUp powerUpAValidar);

    public void actualizarPuntaje(int puntajeNuevo);

    public void mostrarPowerUps();
}
