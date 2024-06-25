package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaSettingJugadores;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;

public class ControladorIngresoJugadores implements Observer {
    private Juego juego;
    private VistaSettingJugadores vistaSettingJugadores;

    public ControladorIngresoJugadores(Juego juego, VistaSettingJugadores vistaSettingJugadores){
        this.juego = juego;
        this.vistaSettingJugadores = vistaSettingJugadores;
        vistaSettingJugadores.addObserver(this);
    }

    @Override
    public void update(Object o) {
        juego.inicializarJuego(vistaSettingJugadores.getJugadores());
        juego.iniciar();
    }
}
