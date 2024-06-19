package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Penalidad extends TipoPuntajeConRestriccion{

    public Penalidad(){
        this.powerUpsValidos.add(new Multiplicador(2));
        this.powerUpsValidos.add(new Multiplicador(3));
        this.powerUpsValidos.add(new Anulador());
        this.powerUpsValidos.add(new Base());
    }

    @Override
    public int puntuar(int respuestaCorrecta,int respuestaIncorrecta, int cantidadDeCorrectasTotales){
      return respuestaCorrecta - respuestaIncorrecta;
    }

}
