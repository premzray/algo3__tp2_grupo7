package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.BotonResponder;
import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Jugada;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ventana_Pregunta_Respuesta_OrderedChoice extends VistaPreguntaTp {
    @Override
    public void start(Stage stage, Jugada jugada, ControladorTurnos controladorTurnos) {
        // Crear controles de JavaFX
        Label preguntaLabel = new Label(jugada.getPregunta().getEnunciado());
        VBox opcionesBox = new VBox(10); // Contenedor para las opciones

        // Crear opciones de respuesta dinámicamente
        for (int i = 0; i < jugada.getPregunta().getRespuestasPosibles().size(); i++) {
            HBox opcionBox = new HBox(10);
            Label opcionLabel = new Label(jugada.getPregunta().getRespuestasPosibles().get(i));
            ChoiceBox<Integer> posicionChoiceBox = new ChoiceBox<>();

            // Llenar el ChoiceBox con opciones de 1 a n (donde n es el número de respuestas)
            List<Integer> posiciones = new ArrayList<>();
            for (int j = 1; j <= jugada.getPregunta().getRespuestasPosibles().size(); j++) {
                posiciones.add(j);
            }
            posicionChoiceBox.setItems(FXCollections.observableArrayList(posiciones));

            int finalI=i;
            posicionChoiceBox.setOnAction(event -> {
                manejarBoton(finalI, posicionChoiceBox.getValue() );
            });

            opcionBox.getChildren().addAll(opcionLabel, posicionChoiceBox);
            opcionesBox.getChildren().add(opcionBox);
        }

        // Botón para enviar respuestas
        Button enviarButton = new Button("RESPONDER");
        enviarButton.setOnAction(new BotonResponder(enviarButton, this, jugada, controladorTurnos));

        // Layout principal
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(preguntaLabel, opcionesBox, enviarButton);

        // Configurar la escena y mostrarla
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Respuesta Jugador");
        stage.show();
    }

    private void manejarBoton(int index, int posicion) {
        String respuesta = String.valueOf(index+1); // Convertir índice a cadena (empezando desde 1)

        if (respuestasJugador.size() < posicion){
            for (int i=respuestasJugador.size(); i<posicion-1; i++){
                respuestasJugador.add("0", i);
            }
            respuestasJugador.add(respuesta, posicion-1);
        } else{
            respuestasJugador.set(respuesta, posicion-1);
        }
    }
}