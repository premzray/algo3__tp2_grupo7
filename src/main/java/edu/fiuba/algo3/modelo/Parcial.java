package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Parcial extends TipoPuntaje{

    public Parcial(){
        this.powerUpsValidos.add(new Exclusividad());
        this.powerUpsValidos.add(new Anulador());
        this.powerUpsValidos.add(new Base());
    }

    @Override
    public int puntuar(int respuestaCorrecta,int respuestaIncorrecta){
        return respuestaCorrecta;
    }
}
