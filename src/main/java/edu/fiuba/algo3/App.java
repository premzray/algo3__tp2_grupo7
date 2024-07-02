package edu.fiuba.algo3;

import edu.fiuba.algo3.Controlador.InicializadorControlador;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        InicializadorControlador controlador = new InicializadorControlador();
        controlador.inicio();
    }

    public static void main(String[] args) {
        launch();
    }

}