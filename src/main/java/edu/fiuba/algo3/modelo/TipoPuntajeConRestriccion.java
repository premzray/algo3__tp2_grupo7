package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class TipoPuntajeConRestriccion implements TipoPuntaje {
    public final ArrayList<PowerUp> powerUpsValidos = new ArrayList<PowerUp>();

    @Override
    public boolean powerUpValido(PowerUp powerUp){
        for(PowerUp powerUpValido: this.powerUpsValidos){
            if(powerUpValido.equals(powerUp)){
                return true;
            }
        }
        return false;
    }//evalua si el powerUp es valido en este tipo de puntaje

}
