package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Penalidad extends TipoPuntajeConRestriccion{

    public Penalidad(){
        this.powerUpsValidos.add(new Multiplicador("MULTIPLICADORX2",2));
        this.powerUpsValidos.add(new Multiplicador("MULTIPLICADORX3",3));
        this.powerUpsValidos.add(new Anulador("ANULADOR"));
        this.powerUpsValidos.add(new Base("BASE"));
    }

    @Override
    public int puntuar(int respuestaCorrecta,int respuestaIncorrecta, int cantidadDeCorrectasTotales){
      return respuestaCorrecta - respuestaIncorrecta;
    }

}
