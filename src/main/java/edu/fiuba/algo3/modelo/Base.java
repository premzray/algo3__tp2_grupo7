package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Base extends PowerUpTp{

    public Base(String nombre) {
        super(nombre);
    }

    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {
        return puntos;
    }

    @Override
    public boolean equals(PowerUp powerUpComparado) {
        return (Objects.equals(powerUpComparado, this));
    }
}
