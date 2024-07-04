package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaSettingJugadores;
import edu.fiuba.algo3.modelo.juego.exceptions.NoHayJugadoresException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonIniciarJugadores implements EventHandler<ActionEvent> {

    private InicializadorControlador inicializadorControlador;
    private Button miBoton;
    private VistaSettingJugadores vista;

    public BotonIniciarJugadores(Button miBoton, InicializadorControlador inicializadorControlador, VistaSettingJugadores vistaSettingJugadores) {
        this.miBoton = miBoton;
        this.inicializadorControlador = inicializadorControlador;
        this.vista = vistaSettingJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            inicializadorControlador.setJugadores(vista.getJugadores());
            inicializadorControlador.jugar();
        } catch (NoHayJugadoresException e) {
            inicializadorControlador.jugadores();
        }
    }
}
