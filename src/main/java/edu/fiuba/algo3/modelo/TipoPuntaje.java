package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface TipoPuntaje {
    public abstract int puntuar(ArrayList<Respuesta> respuestaCorrecta, ArrayList<Respuesta> respuestaJugador);
}
