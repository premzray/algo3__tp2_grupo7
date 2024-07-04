package edu.fiuba.algo3.modelo.pregunta.puntaje;

import edu.fiuba.algo3.modelo.powerup.PowerUp;

public class Clasico extends TipoPuntajeConRestriccion {

    public Clasico(){
        this.powerUpsValidos.add(PowerUp.deTipo("EXCLUSIVIDAD"));
        this.powerUpsValidos.add(PowerUp.deTipo("ANULADOR"));
        this.powerUpsValidos.add(PowerUp.deTipo("BASE"));
    }

    @Override
    public int puntuar(int respuestaCorrecta, int respuestaIncorrecta, int cantidadDeCorrectasTotales){
        if(respuestaIncorrecta == 0 && cantidadDeCorrectasTotales == respuestaCorrecta){
            return 1;
        }
        return 0;
    }

}

