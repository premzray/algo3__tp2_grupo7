package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VistaSettingJugadores extends Application {

    private List<String> jugadores = new ArrayList<>();
    private ListView<String> listViewJugadores = new ListView<>();

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);

        Label label = new Label("Ingrese el nombre del jugador:");
        TextField textField = new TextField();
        Button btnIngresar = new Button("Ingresar");
        Button btnComenzar = new Button("Comenzar");
        btnComenzar.setAlignment(Pos.CENTER);
        // funcionalidad de ingresar, no entendi como enlazar con controller
        btnIngresar.setOnAction(event -> {
            String nombreJugador = textField.getText().trim();
            if (!nombreJugador.isEmpty()) {
                jugadores.add(nombreJugador);
                listViewJugadores.getItems().add(nombreJugador);
                textField.clear();
            }
            //else señal de que no ha sido ingresado el jugador.
        });

        // lo mismo para comenzar
        btnComenzar.setOnAction(event -> {
            if (!jugadores.isEmpty()) {
                comenzarJuego(jugadores);
            }
        });

        root.getChildren().addAll(label, textField, btnIngresar, listViewJugadores, btnComenzar);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Configuración de Jugadores");
        stage.setScene(scene);
        stage.show();
    }

    private void comenzarJuego(List<String> jugadores) {
        System.out.println("Jugadores ingresados: " + jugadores);
        // CAMBIO A ESCENA PREGUNTA
    }

}

