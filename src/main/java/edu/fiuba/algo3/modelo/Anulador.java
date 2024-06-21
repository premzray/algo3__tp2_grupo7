package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Anulador extends PowerUpTp{

    public Anulador(String nombre) {
        super(nombre);
    }

    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {
        for(int i=0; i<= puntos.size()-1; i++){
            if(i != indiceUso){
                puntos.set(i, 0);
            }
        }
        return puntos;
    }

    @Override
    public boolean equals(PowerUp powerUpComparado) {
        return (Objects.equals(powerUpComparado, this));
    }
}
