package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Multiplicador implements PowerUp{
    int indiceMult;

    public Multiplicador(){
        this.indiceMult = 1;
    }

    public Multiplicador(int indice){
        this.indiceMult = indice;
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
        if(Objects.equals(powerUpComparado, this)){
            return (this.getIndiceMult() == ((Multiplicador) powerUpComparado).getIndiceMult());
        }
        return false;
    }
}
