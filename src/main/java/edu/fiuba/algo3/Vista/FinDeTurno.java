package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.juego.Jugador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FinDeTurno {

    private Jugador jugador;
    private boolean respuestaCorrecta;

    public FinDeTurno() {
        // Constructor
    }

    public FinDeTurno(Jugador jugador, boolean respuestaCorrecta) {
        this.jugador = jugador;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void start(Stage primaryStage) {
        // Inicializo el jugador para probar la vista
        if (jugador == null) {
            jugador = Jugador.conNombre("nombre1");
            respuestaCorrecta = true;
        }

        primaryStage.setTitle("Fin del Turno");

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#42a8a1"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label resultadoLabel = new Label(respuestaCorrecta ? "Respuesta Correcta" : "Respuesta Incorrecta");
        resultadoLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;");

        Button siguienteButton = new Button("Siguiente Turno");
        String buttonStyle = "-fx-font-family: 'Open Sans', sans-serif;" +
                "-fx-font-size: 20px;" +
                "-fx-letter-spacing: 2px;" +
                "-fx-text-decoration: none;" +
                "-fx-text-transform: uppercase;" +
                "-fx-text-fill: black;-fx-font-weight: bold;"+
                "-fx-cursor: pointer;" +
                "-fx-border-width: 3px;" +
                "-fx-border-color: black;" +
                "-fx-padding: 0.25em 0.5em;" +
                "-fx-effect: dropshadow(gaussian, black, 1, 0, 1, 1);" +
                "-fx-position: relative;" +
                "-fx-user-select: none;" +
                "-webkit-user-select: none;" +
                "-fx-touch-action: manipulation;" +
                "-fx-opacity: 0.9;"+"-fx-background-color: #358f89;";
        siguienteButton.setStyle(buttonStyle);
        siguienteButton.setOnAction(event -> {
            // Cambio de stage a la siguiente pregunta del siguiente jugador
            System.out.println("Avanzando al siguiente turno...");
            primaryStage.close();
        });

        vbox.getChildren().addAll(resultadoLabel, siguienteButton);

        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
