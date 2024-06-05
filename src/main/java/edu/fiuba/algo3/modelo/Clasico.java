package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Clasico implements TipoPuntaje{

    @Override
    public int puntuar(ArrayList<Respuesta> respuestaCorrecta, ArrayList<Respuesta> respuestaJugador){
        if (respuestaCorrecta.equals(respuestaJugador)){
            return 1;
        }
        return 0;
    }
}
