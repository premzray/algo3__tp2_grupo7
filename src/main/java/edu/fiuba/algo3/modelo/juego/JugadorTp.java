package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.Utilidades.ObservableConcreto;

import java.util.ArrayList;

public class JugadorTp extends ObservableConcreto implements Jugador {
    private final String nombre;
    private int puntaje;
    private final ArrayList<PowerUp> powerUps;

    public JugadorTp(String nombre, ArrayList <PowerUp> powerUps, int puntaje){
        this.nombre=nombre;
        this.puntaje = puntaje;
        this.powerUps = powerUps;
    } //constructor que sirve para darle X powerUp al jugador y X puntaje (se implementa para testeo y para poder cambiar reglas del juego si es necesario)

    public JugadorTp(String nombre){
        this.nombre=nombre;
        this.puntaje = 0;
        this.powerUps = PowerUp.inicializarPowerUpsDefault();
    }

    @Override
    public boolean puntajeEsMayor(int otroPuntaje){
        return (this.puntaje >= otroPuntaje);
    }

    @Override
    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    } //LO USA LA VISUAL

    @Override
    public int getPuntaje(){
        return this.puntaje;
    } //LO USA JUEGO

    @Override
    public String getName(){
        return this.nombre;
    }

    @Override
    public void usastePowerUp(PowerUp powerUpUsado){
        boolean Borro = true;
        int i=0;

        while(Borro){
            if(powerUps.get(i).equals(powerUpUsado)){
                powerUps.remove(powerUps.get(i));
                Borro = false;
            }
            i++;
        }
    } //elimina un powerUp por usarlo

    @Override
    public boolean tenesPowerUp(PowerUp powerUpAValidar){
        if (powerUpAValidar.esBase()){
            return true;
        }
        for(PowerUp powerUp: this.powerUps){
            if(powerUpAValidar.equals(powerUp)){
                return true;
            }
        }
        return false;
    } //evalua si tiene el powerUp que se va a usar

    @Override
    public void mostrarPowerUps(){
        notifyObservers(this);
    }

    @Override
    public void actualizarPuntaje(int puntajeNuevo){
        this.puntaje += puntajeNuevo;
    }
}
