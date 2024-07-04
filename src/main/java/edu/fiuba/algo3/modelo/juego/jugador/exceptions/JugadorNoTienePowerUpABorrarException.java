package edu.fiuba.algo3.modelo.juego.jugador.exceptions;

public class JugadorNoTienePowerUpABorrarException extends Exception{
    public JugadorNoTienePowerUpABorrarException(){
        super("El jugador no tiene power up que se desea usar");
    }
}
