package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface TipoPuntaje {

    public static TipoPuntaje conTipo(String tipo){
        switch (tipo){
            case "CLASICO":
                return new Clasico();
            case "PENALIDAD":
                return new Penalidad();
            case "PARCIAL":
                return new Parcial();

            default: return new Clasico();//excepcion
        }
    }

    public abstract int puntuar(int respuestasCorrecta, int respuestasIncorrecta, int cantidadDeCorrectasTotales);

    public boolean powerUpValido(PowerUp powerUp);
}
