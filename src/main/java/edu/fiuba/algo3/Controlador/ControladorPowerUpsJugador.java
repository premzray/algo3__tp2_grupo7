package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaPowerUp;
import edu.fiuba.algo3.Vista.VistaPregunta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ObservableConcreto;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.PowerUp;


public abstract class ControladorPowerUpsJugador extends ObservableConcreto implements Observer {
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
    public void update(Object o) {
        VistaPowerUp vistaPowerUp = crearVentanaPowerUp();
        //vistaPowerUp.start;
        notifyObservers(this);
    }
}
