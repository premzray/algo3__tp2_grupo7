package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface TipoPuntaje {

    public abstract int puntuar(int respuestasCorrecta, int respuestasIncorrecta, int cantidadDeCorrectasTotales);

    public boolean powerUpValido(PowerUp powerUp);
}
