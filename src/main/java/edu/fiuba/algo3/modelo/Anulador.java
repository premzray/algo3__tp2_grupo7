package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Anulador implements PowerUp{
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
