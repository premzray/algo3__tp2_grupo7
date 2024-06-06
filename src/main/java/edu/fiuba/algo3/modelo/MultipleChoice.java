package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoice extends Pregunta{
    private int cantidadRespuestasCorrectas;

    public MultipleChoice(ArrayList<Respuesta> respuestaCorrecta, ArrayList<Respuesta> respuestasPosibles, TipoPuntaje tipoPuntaje){
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje);
        cantidadRespuestasCorrectas = respuestaCorrecta.size();
    }

    @Override
    public int puntuarRespuesta(ArrayList<Respuesta> respuestaJugador) {
        int correctas = 0;
        int incorrectas = 0;
        int respuestasRestantes = cantidadRespuestasCorrectas;
        for (Respuesta respuesta : respuestaJugador) {
            if (respuestaCorrecta.contains(respuesta)) {
                correctas++;
                respuestasRestantes--;
            } else {
                incorrectas++;
            }
        }
        incorrectas += respuestasRestantes;
        return tipoPuntaje.puntuar(correctas,incorrectas);
    }
}
