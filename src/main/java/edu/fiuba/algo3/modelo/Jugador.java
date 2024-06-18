package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private int puntaje;
    private final ArrayList<PowerUp> powerUps;

    public Jugador(String nombre, PowerUp powerUp, int puntaje){
        this.nombre=nombre;
        this.puntaje = puntaje;
        this.powerUps = new ArrayList<PowerUp>();

        this.powerUps.add(powerUp);
    } //constructor que sirve para darle X powerUp al jugador y X puntaje (se implementa para testeo y para poder cambiar reglas del juego si es necesario)

    public Jugador(String nombre){
        this.nombre=nombre;
        this.puntaje = 0;
        this.powerUps = new ArrayList<PowerUp>();

        this.powerUps.add(new Multiplicador(2));
        this.powerUps.add(new Multiplicador(3));
        this.powerUps.add(new Exclusividad());
        this.powerUps.add(new Exclusividad());
        this.powerUps.add(new Anulador());
    }

    public PowerUp getPowerUp(PowerUp powerUpRequerido){
        for(PowerUp powerUp: powerUps){
            if(powerUp.equals(powerUpRequerido)){
                return powerUp;
            }
        }
        //excepcion
        return powerUpRequerido; //cambiar por excepcion
    }

    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    }

    public int getPuntaje(){
        return this.puntaje;
    }

    public void usastePowerUp(PowerUp powerUpUsado){
        this.powerUps.remove(powerUpUsado);
    } //elimina un powerUp por usarlo

    public boolean tenesPowerUp(PowerUp powerUpAValidar){
        PowerUp base = new Base();
        if (powerUpAValidar.equals(base)){
            return true;
        }

        for(PowerUp powerUp: this.powerUps){
            if(powerUpAValidar.equals(powerUp)){
                return true;
            }
        }
        return false;
    } //evalua si tiene el powerUp que se va a usar

    public void actualizarPuntaje(int puntajeNuevo){
        this.puntaje += puntajeNuevo;
    }
}
