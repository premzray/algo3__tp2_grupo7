package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface PowerUp {
    public ArrayList<Integer> usar(ArrayList<Integer> puntos, int indiceUso);

    public static PowerUp deTipo(String nombre,int indice){
        if (nombre.equals("MULTIPLICADOR")) {
            return new Multiplicador(indice);
        }
        return new Base();
        //excepcion
    }

    public static PowerUp deTipo(String nombre){
        switch (nombre) {
            case "BASE":
                return new Base();
            case "EXCLUSIVIDAD":
                return new Exclusividad();
            case "ANULADOR":
                return new Anulador();
            case "MULTIPLICADOR":
                return new Multiplicador(1);
            default:
                return new Base();
            //excepcion
        }
    }

    public boolean esBase();

    public boolean equals(PowerUp powerUpComparado);

    public String getNombre();
}
