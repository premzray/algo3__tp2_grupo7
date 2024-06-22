package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Base extends PowerUpTp{

    public Base() {
        this.nombre = "BASE";
    }

    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {
        return puntos;
    }
}
