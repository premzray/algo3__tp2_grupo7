package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Base implements PowerUp{
    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {
        return puntos;
    }

    @Override
    public boolean equals(PowerUp powerUpComparado) {
        return (this.getClass() == powerUpComparado.getClass());
    }
}
