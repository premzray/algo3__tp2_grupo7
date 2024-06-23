package edu.fiuba.algo3.modelo;

public interface TipoPuntaje {

    public static TipoPuntaje conTipo(String tipo){
        switch (tipo){
            case "PENALIDAD":
                return new Penalidad();
            case "PARCIAL":
                return new Parcial();

            default: return new Clasico();
        }
    }

    public abstract int puntuar(int respuestasCorrecta, int respuestasIncorrecta, int cantidadDeCorrectasTotales);

    public boolean powerUpValido(PowerUp powerUp);
}
