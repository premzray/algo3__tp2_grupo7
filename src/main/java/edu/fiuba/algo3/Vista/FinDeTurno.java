package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.juego.Jugador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
        //aca puedo tambien mostrar los puntos ganados o perdidos por respuesta
        Label resultadoLabel = new Label(respuestaCorrecta ? "Respuesta Correcta" : "Respuesta Incorrecta");
        resultadoLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button siguienteButton = new Button("Siguiente Turno");
        siguienteButton.setStyle("-fx-font-size: 18px;");
        siguienteButton.setOnAction(event -> {
            // cambio de stage a la siguiente pregunta del siguiente jugador
            System.out.println("Avanzando al siguiente turno...");
            primaryStage.close();
        });

        vbox.getChildren().addAll(resultadoLabel, siguienteButton);

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
