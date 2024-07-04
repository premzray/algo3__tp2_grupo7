package edu.fiuba.algo3.modelo.juego.selectorPreguntas;
import java.util.Collections;


import edu.fiuba.algo3.modelo.pregunta.Pregunta;


import java.util.List;

public class SelectorPreguntas implements ISelectorPreguntas {
    private String ultimaTematicaLanzada;

    public SelectorPreguntas(){
        ultimaTematicaLanzada = null;
    }

    public Pregunta obtenerPregunta(List<Pregunta> preguntas) {
        if(ultimaTematicaLanzada == null){
            Pregunta primerPregunta = preguntas.get(0);
            ultimaTematicaLanzada = primerPregunta.tematica();
            return primerPregunta;
        }

        int i = 0;
        Pregunta iterador = preguntas.get(0);
        while (ultimaTematicaLanzada.equals(iterador.tematica())) {
            i++;
            iterador = preguntas.get(i);
            if(i>preguntas.size()){
                return preguntas.get(0);
            }
        }

        ultimaTematicaLanzada = iterador.tematica();
        return iterador;
    }
}
