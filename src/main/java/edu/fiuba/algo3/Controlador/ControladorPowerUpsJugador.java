package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.VistaPowerUp; //ESTOY TENIENDO PROBLEMAS PARA LOS PAQUETES, ACA TOQUÉ, ERA edu.fiuba.algo3.Vista.VistaPowerUp
import edu.fiuba.algo3.Vista.VistaPregunta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.PowerUp;

import java.util.Observable;
import java.util.Observer;

public abstract class ControladorPowerUpsJugador extends Observable implements Observer {
    private PowerUp powerUp;
    private Jugador jugador;

    public ControladorPowerUpsJugador(Jugador jugador){
        this.jugador = jugador;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    abstract public VistaPregunta crearVentanaPregunta();

    abstract public VistaPowerUp crearVentanaPowerUp();

    @Override
    public void update(Observable o, Object arg) {
        VistaPowerUp vistaPowerUp = crearVentanaPowerUp();
        //vistaPowerUp.start;
        notifyAll();
    }
}
