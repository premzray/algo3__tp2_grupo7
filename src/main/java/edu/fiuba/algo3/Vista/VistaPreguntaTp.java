package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.pregunta.Respuestas;

public abstract class VistaPreguntaTp implements VistaPregunta{

    Respuestas respuestasJugador;

    @Override
    public Respuestas respuestasJugador(){
        return this.respuestasJugador;
    }
}
