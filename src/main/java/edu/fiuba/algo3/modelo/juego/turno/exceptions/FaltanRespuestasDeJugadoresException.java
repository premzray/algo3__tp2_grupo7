package edu.fiuba.algo3.modelo.juego.turno.exceptions;

public class FaltanRespuestasDeJugadoresException extends Exception{
    public FaltanRespuestasDeJugadoresException(){
        super("No se puede terminar la ronda cuando aun quedan jugadores por responder");
    }
}
