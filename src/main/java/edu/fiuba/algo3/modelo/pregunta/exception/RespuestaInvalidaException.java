package edu.fiuba.algo3.modelo.pregunta.exception;

public class RespuestaInvalidaException extends Exception{
    public RespuestaInvalidaException(){
        super("Las respuestas dada es invalida con el tipo de pregunta");
    }
}
