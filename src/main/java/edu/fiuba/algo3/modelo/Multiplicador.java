package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Multiplicador implements PowerUp{
    int indiceMult;

    public Multiplicador(){
        this.indiceMult = 1;
    }

    public Multiplicador(int indice){
        this.indiceMult = indice;
    }

    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {
        puntos.set(indiceUso, puntos.get(indiceUso) * indiceMult);
        return puntos;
    }
}
