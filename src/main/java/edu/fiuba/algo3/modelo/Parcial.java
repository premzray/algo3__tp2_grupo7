package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Parcial extends TipoPuntajeConRestriccion{

    public Parcial(){
        this.powerUpsValidos.add(new Exclusividad());
        this.powerUpsValidos.add(new Anulador());
        this.powerUpsValidos.add(new Base());
    }

    @Override
    public int puntuar(int respuestaCorrecta,int respuestaIncorrecta, int cantidadDeCorrectasTotales){
        if(respuestaIncorrecta  == 0) {
            return respuestaCorrecta;
        }
        return 0;
    }
}
