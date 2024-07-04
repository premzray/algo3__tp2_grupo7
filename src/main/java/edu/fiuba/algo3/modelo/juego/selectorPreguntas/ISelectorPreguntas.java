package edu.fiuba.algo3.modelo.juego.selectorPreguntas;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.List;

public interface ISelectorPreguntas {

    public static ISelectorPreguntas crear(){
        return new SelectorPreguntas();
    }

    List<Pregunta> OrdenarPreguntas(List<Pregunta> preguntas);
}
