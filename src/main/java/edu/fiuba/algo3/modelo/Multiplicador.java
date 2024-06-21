package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Multiplicador extends PowerUpTp{
    int indiceMult;

    public Multiplicador(String nombre, int indiceMult){
        super(nombre);
        this.indiceMult = 1;
    }

    public int getIndiceMult() {
        return indiceMult;
    }

    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {
        puntos.set(indiceUso, puntos.get(indiceUso) * indiceMult);
        return puntos;
    }

    @Override
    public boolean equals(PowerUp powerUpComparado) {
        if(Objects.equals(powerUpComparado.getNombre(), this.getNombre())){
            return (this.getIndiceMult() == ((Multiplicador) powerUpComparado).getIndiceMult());
        }
        return false;
    }
}
