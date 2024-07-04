package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaInicioDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonModo implements EventHandler<ActionEvent> {

    private InicializadorControlador inicializadorControlador;
    private Button miBoton;
    private VistaInicioDeJuego visual;

    public BotonModo(Button miBoton, InicializadorControlador inicializadorControlador, VistaInicioDeJuego visual) {
        this.miBoton = miBoton;
        this.inicializadorControlador = inicializadorControlador;
        this.visual = visual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        inicializadorControlador.setModo(visual.getModo());
        inicializadorControlador.jugadores();
    }
}