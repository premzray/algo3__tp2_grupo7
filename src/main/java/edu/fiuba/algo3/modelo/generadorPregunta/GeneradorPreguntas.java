package edu.fiuba.algo3.modelo.generadorPregunta;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public interface GeneradorPreguntas {
    public static GeneradorPreguntas crear(){
        return new GeneradorPreguntasTp(Lector.crear());
    }

    public ArrayList<Pregunta> generarPreguntas(String archivo);
}
