package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaPregunta;
import edu.fiuba.algo3.modelo.juego.Jugada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonResponder implements EventHandler<ActionEvent> {

    private Button miBoton;
    private VistaPregunta vista;
    private Jugada jugada;
    private ControladorTurnos controlador;

    public BotonResponder(Button miBoton, VistaPregunta vistaPregunta, Jugada jugada, ControladorTurnos controladorTurnos) {
        this.miBoton = miBoton;
        this.vista = vistaPregunta;
        this.jugada = jugada;
        this.controlador = controladorTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugada.registrarRespuesta(vista.respuestasJugador());
        controlador.elegirPowerUp(jugada);
    }
}
