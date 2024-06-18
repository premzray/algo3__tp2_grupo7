package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface PowerUp {
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso);

    public boolean equals(PowerUp powerUpComparado);
}
