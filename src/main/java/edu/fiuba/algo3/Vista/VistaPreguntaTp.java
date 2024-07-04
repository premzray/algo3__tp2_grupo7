package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.pregunta.Respuestas;

public abstract class VistaPreguntaTp extends Shapes implements VistaPregunta{

    public Respuestas respuestasJugador = new Respuestas();

    @Override
    public Respuestas respuestasJugador(){
        return this.respuestasJugador;
    }
}
