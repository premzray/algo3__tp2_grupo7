package edu.fiuba.algo3.modelo.generadorPregunta;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;


import java.util.ArrayList;
import java.util.List;

public interface GeneradorPreguntas {
    public static GeneradorPreguntas crear(){
        return new GeneradorPreguntasTp();
    }

    public ArrayList<Pregunta> generarPreguntas(String archivo);
}
