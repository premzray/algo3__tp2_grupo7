package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaSettingJugadores;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.Observer;
import javafx.stage.Stage;

public class ControladorVistaIngresoJugadores implements Observer {
    private Juego juego;

    public ControladorVistaIngresoJugadores(Juego juego){
        this.juego = juego;
        juego.addObserver(this);
    }

    public VistaSettingJugadores crearVentanaIngresoJugadores(){
        return new VistaSettingJugadores();
    }

    @Override
    public void update(Object o) {
        VistaSettingJugadores vistaSettingJugadores = crearVentanaIngresoJugadores();
        ControladorIngresoJugadores controladorIngresoJugadores = new ControladorIngresoJugadores(juego, vistaSettingJugadores);
        vistaSettingJugadores.start(new Stage());
    }
}
