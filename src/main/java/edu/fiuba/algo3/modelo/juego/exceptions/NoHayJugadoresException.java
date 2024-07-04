package edu.fiuba.algo3.modelo.juego.exceptions;

public class NoHayJugadoresException extends Exception{
    public NoHayJugadoresException(){
        super("No se ha proporcionado ningun jugador");
    }
}
