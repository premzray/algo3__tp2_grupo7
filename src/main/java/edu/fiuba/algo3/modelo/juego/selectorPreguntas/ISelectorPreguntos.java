package edu.fiuba.algo3.modelo.juego.selectorPreguntas;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.List;

public interface ISelectorPreguntos {
    List<Pregunta> OrdenarPreguntas(List<Pregunta> preguntas);
}
