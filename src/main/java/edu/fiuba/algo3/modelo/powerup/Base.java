package edu.fiuba.algo3.modelo.powerup;

import java.util.ArrayList;


public class Base extends PowerUpTp{

    public Base() {
        this.nombre = "BASE";
    }

    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {
        return puntos;
    }
}
