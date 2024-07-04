package edu.fiuba.algo3.modelo.juego.selectorPreguntas;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.List;

public interface ISelectorPreguntas {

    public static ISelectorPreguntas crear(){
        return new SelectorPreguntas();
    }

    public Pregunta obtenerPregunta(List<Pregunta> preguntas);
}
