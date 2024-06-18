package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class TipoPuntaje {
    public ArrayList<PowerUp> powerUpsValidos;

    public TipoPuntaje(){
        this.powerUpsValidos = new ArrayList<PowerUp>();
    }

    public abstract int puntuar(int respuestasCorrecta, int respuestasIncorrecta, int cantidadDeCorrectasTotales);

    public boolean powerUpValido(PowerUp powerUp){
        for(PowerUp powerUpValido: this.powerUpsValidos){
            if(powerUpValido.getClass() == powerUp.getClass()){
                return true;
            }
        }
        return false;
    } //evalua si el powerUp es valido en este tipo de puntaje
}
