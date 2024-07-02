package edu.fiuba.algo3.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonFinDeRonda implements EventHandler<ActionEvent> {

    private Button miBoton;
    private ControladorTurnos controlador;

    public BotonFinDeRonda(Button miBoton, ControladorTurnos controladorTurnos) {
        this.miBoton = miBoton;
        this.controlador = controladorTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controlador.finalizarTurno();
        controlador.jugarTurno();
    }
}