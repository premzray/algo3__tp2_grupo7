package edu.fiuba.algo3.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonModo implements EventHandler<ActionEvent> {

    private InicializadorControlador inicializadorControlador;
    private Button miBoton;

    public BotonModo(Button miBoton, InicializadorControlador inicializadorControlador) {
        this.miBoton = miBoton;
        this.inicializadorControlador = inicializadorControlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        inicializadorControlador.setModo(miBoton.getText());
        inicializadorControlador.jugadores();
    }
}