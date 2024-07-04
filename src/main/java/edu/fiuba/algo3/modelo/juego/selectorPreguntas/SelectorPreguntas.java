package edu.fiuba.algo3.modelo.juego.selectorPreguntas;
import java.util.Collections;


import edu.fiuba.algo3.modelo.pregunta.Pregunta;


import java.util.List;

public class SelectorPreguntas implements ISelectorPreguntos{
    @Override
    public List<Pregunta> OrdenarPreguntas(List<Pregunta> preguntas) {
        Collections.shuffle(preguntas);
        Pregunta pregunta;
        Pregunta preguntaAnterior;
        for (int i = 1; i < preguntas.size(); i++) {
            pregunta = preguntas.get(i);
            preguntaAnterior = preguntas.get(i - 1);
            if(pregunta.tematica().equals(preguntaAnterior.tematica())){
                int j = i + 1;
                boolean corte = false;
                while(j < preguntas.size()|| corte ){
                    if (!preguntas.get(j).tematica().equals(pregunta.tematica())){
                        corte = true;
                        Collections.swap(preguntas, i, j);
                    }
                }
            }
        }
        return preguntas;
    }
}
