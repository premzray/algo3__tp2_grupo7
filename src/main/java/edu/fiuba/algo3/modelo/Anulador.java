package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Anulador extends PowerUpTp{

    public Anulador() {
        this.nombre = "ANULADOR";
    }

    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {
        for(int i=0; i<= puntos.size()-1; i++){
            if(i != indiceUso){
                puntos.set(i, 0);
            }
        }
        return puntos;
    }
}
