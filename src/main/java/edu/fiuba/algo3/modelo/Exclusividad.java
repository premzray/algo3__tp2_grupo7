package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Exclusividad implements PowerUp{

    private boolean cumpleExclusividad(ArrayList<Integer> puntos){
        int cantAcertadas = 0;
        for(int i=0; i<=puntos.size()-1;i++){
            if(puntos.get(i) > 0){
                cantAcertadas++;
            }
        }

        return (cantAcertadas == 1);
    }

    @Override
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso) {

        if(cumpleExclusividad(puntos)){
            for(int i=0; i<= puntos.size()-1; i++){
                puntos.set(i, puntos.get(i) * 2);
            }
        }

        return puntos;
    }

    @Override
    public boolean equals(PowerUp powerUpComparado) {
        return (Objects.equals(powerUpComparado, this));
    }
}
