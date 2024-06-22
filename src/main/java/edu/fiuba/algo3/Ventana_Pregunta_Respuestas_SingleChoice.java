package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Ventana_Pregunta_Respuestas_SingleChoice extends Application {
    private String respuestaSeleccionada = null; // Variable para almacenar la respuesta seleccionada

    @Override
    public void start(Stage stage) {
        Label titulo_l = new Label("¿Cuál de estos colores no es un color primario?");

        List<String> opciones = List.of("Azul", "Rojo", "Amarillo", "Naranja", "Marrón");
        List<RadioButton> radioButtons = new ArrayList<>();
        ToggleGroup group = new ToggleGroup(); // ToggleGroup para asegurar que solo un RadioButton puede estar seleccionado a la vez

        // Crear RadioButtons para cada respuesta
        for (String opcion : opciones) {
            RadioButton radioButton = new RadioButton(opcion);
            radioButton.setToggleGroup(group);
            radioButton.setOnAction(e -> manejarRadioButton(radioButton));
            radioButtons.add(radioButton);
        }

        Button responder_b = new Button("Responder");
        responder_b.setOnAction(e -> stage.close());

        VBox vbox = new VBox(20);
        VBox vboxC = new VBox(20);
        HBox HboxU = new HBox(20);
        HBox HboxD = new HBox(20);

        // Distribuir los RadioButtons en dos HBoxes
        for (int i = 0; i < radioButtons.size(); i++) {
            if (i < 2) {
                HboxU.getChildren().add(radioButtons.get(i));
            } else {
                HboxD.getChildren().add(radioButtons.get(i));
            }
        }

        vboxC.getChildren().addAll(HboxU, HboxD);

        // Alinear los VBoxes y HBoxes en el centro
        HboxU.setAlignment(Pos.CENTER);
        HboxD.setAlignment(Pos.CENTER);
        vboxC.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titulo_l, vboxC, responder_b);

        Scene escena = new Scene(vbox, 500, 300);
        vbox.setAlignment(Pos.CENTER);
        stage.setScene(escena);
        stage.setTitle("Respuesta Jugador");
        stage.show();
    }

    private void manejarRadioButton(RadioButton radioButton) {
        respuestaSeleccionada = radioButton.getText(); // Actualizar la respuesta seleccionada
        mostrarRespuesta();
    }

    private void mostrarRespuesta() {
        System.out.println(respuestaSeleccionada);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
