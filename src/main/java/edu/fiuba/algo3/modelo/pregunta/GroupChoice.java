package edu.fiuba.algo3.modelo.pregunta;

public class GroupChoice extends PreguntaTp {

    public GroupChoice(Respuestas respuestaCorrecta, Respuestas respuestasPosibles, String tipoPuntaje, String tematica, String textoRespuesta, int id, String textoPregunta) {
        super(respuestaCorrecta, respuestasPosibles, tipoPuntaje, tematica, textoRespuesta, id, textoPregunta);
        this.tipoPregunta = "GROUP CHOICE";
    }

    @Override
    public int puntuarRespuesta(Respuestas respuestaJugador){
        if(!respuestaJugador.equalSize(respuestaCorrecta)){
            //exepcion
        }

        return tipoPuntaje.puntuar(respuestaJugador.cuantasIguales(respuestaCorrecta),respuestaJugador.cuantasDiferentes(respuestaCorrecta), respuestaCorrecta.size());

    }
}
