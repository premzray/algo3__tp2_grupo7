package edu.fiuba.algo3.modelo.generadorPregunta;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.List;

public interface GeneradorPreguntas {
    public List<Pregunta> generarPreguntas(String archivo);
}
