package edu.fiuba.algo3.modelo.powerup;

import java.util.ArrayList;

public class Multiplicador extends PowerUpTp{
    int indiceMult;

    public Multiplicador(int indiceMult){
        this.nombre = "MULTIPLICADOR";
        this.indiceMult = indiceMult;
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
        if(this.getNombre().equals(powerUpComparado.getNombre())){
            return (this.getIndiceMult() == ((Multiplicador) powerUpComparado).getIndiceMult());
        }
        return false;
    }
}
