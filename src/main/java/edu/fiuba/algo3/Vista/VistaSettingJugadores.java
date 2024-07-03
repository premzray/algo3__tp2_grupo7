package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.BotonIniciarJugadores;
import edu.fiuba.algo3.Controlador.InicializadorControlador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaSettingJugadores {

    private ArrayList<String> jugadores = new ArrayList<>();
    private ListView<String> listViewJugadores = new ListView<>();

    public ArrayList<String> getJugadores() {
        return jugadores;
    }

    public void start(Stage stage, InicializadorControlador controlador) {
        VBox root = new VBox(10);

        Label label = new Label("Ingrese el nombre del jugador:");
        TextField textField = new TextField();
        Button btnIngresar = new Button("Ingresar");
        Button btnComenzar = new Button("Comenzar");
        btnComenzar.setAlignment(Pos.CENTER);
        btnIngresar.setOnAction(event -> {
            String nombreJugador = textField.getText().trim();
            if (!nombreJugador.isEmpty()) {
                jugadores.add(nombreJugador);
                listViewJugadores.getItems().add(nombreJugador);
                textField.clear();
            }
            //else señal de que no ha sido ingresado el jugador.
        });

        BotonIniciarJugadores botonIniciarJugadores = new BotonIniciarJugadores(btnComenzar, controlador, this);
        btnComenzar.setOnAction(botonIniciarJugadores);

        root.getChildren().addAll(label, textField, btnIngresar, listViewJugadores, btnComenzar);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Configuración de Jugadores");
        stage.setScene(scene);
        stage.show();
    }
}

