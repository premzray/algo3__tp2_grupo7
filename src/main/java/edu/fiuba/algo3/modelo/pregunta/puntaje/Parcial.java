package edu.fiuba.algo3.modelo.pregunta.puntaje;


import edu.fiuba.algo3.modelo.powerup.PowerUp;

public class Parcial extends TipoPuntajeConRestriccion {

    public Parcial(){
        this.powerUpsValidos.add(PowerUp.deTipo("EXCLUSIVIDAD"));
        this.powerUpsValidos.add(PowerUp.deTipo("ANULADOR"));
        this.powerUpsValidos.add(PowerUp.deTipo("BASE"));
    }

    @Override
    public int puntuar(int respuestaCorrecta,int respuestaIncorrecta, int cantidadDeCorrectasTotales){
        if(respuestaIncorrecta  == 0) {
            return respuestaCorrecta;
        }
        return 0;
    }
}
