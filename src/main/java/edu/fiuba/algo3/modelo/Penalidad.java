package edu.fiuba.algo3.modelo;


public class Penalidad extends TipoPuntajeConRestriccion{

    public Penalidad(){
        this.powerUpsValidos.add(PowerUp.deTipo("MULTIPLICADOR", 2));
        this.powerUpsValidos.add(PowerUp.deTipo("MULTIPLICADOR", 3));
        this.powerUpsValidos.add(PowerUp.deTipo("ANULADOR"));
        this.powerUpsValidos.add(PowerUp.deTipo("BASE"));
    }

    @Override
    public int puntuar(int respuestaCorrecta,int respuestaIncorrecta, int cantidadDeCorrectasTotales){
      return respuestaCorrecta - respuestaIncorrecta;
    }

}
