package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Clasico extends TipoPuntaje{

    public Clasico(){
        this.powerUpsValidos.add(new Exclusividad());
        this.powerUpsValidos.add(new Anulador());
        this.powerUpsValidos.add(new Base());
    }

    @Override
    public int puntuar(int respuestaCorrecta, int respuestaIncorrecta){
        if(respuestaIncorrecta == 0){
            return 1;
        }
        return 0;
    }

}

