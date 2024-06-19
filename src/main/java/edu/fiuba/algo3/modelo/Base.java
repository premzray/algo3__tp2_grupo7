package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Base implements PowerUp{
    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {
        return puntos;
    }

    @Override
    public boolean equals(PowerUp powerUpComparado) {
        return (Objects.equals(powerUpComparado, this));
    }
}
