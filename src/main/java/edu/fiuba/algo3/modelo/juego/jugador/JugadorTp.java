package edu.fiuba.algo3.modelo.juego.jugador;

import edu.fiuba.algo3.modelo.juego.jugador.exceptions.JugadorNoTienePowerUpABorrarException;
import edu.fiuba.algo3.modelo.powerup.PowerUp;

import java.util.ArrayList;

public class JugadorTp implements Jugador {
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
    public void usastePowerUp(PowerUp powerUpUsado) throws JugadorNoTienePowerUpABorrarException {
        boolean borro = false;
        int i = 0;
        if(!powerUpUsado.esBase()) {
            while (!borro){
                if (i>powerUps.size()) throw new JugadorNoTienePowerUpABorrarException();

                if (powerUps.get(i).equals(powerUpUsado)){
                    powerUps.remove(powerUps.get(i));
                    borro = true;
                }
                i++;
            }
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
    public void actualizarPuntaje(int puntajeNuevo){
        this.puntaje += puntajeNuevo;
    }
}
