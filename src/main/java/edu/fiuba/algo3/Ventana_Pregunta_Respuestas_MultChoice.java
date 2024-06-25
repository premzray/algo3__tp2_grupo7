package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Ventana_Pregunta_Respuestas_MultChoice extends Application {
    private List<String> respuestas = new ArrayList<>(); //LISTA DE RESPUESTAS CON LA QUE VAMOS A TRABAJAR
    private Juego modelo;
    public void Ventana_Pregunta_Respuesta_MultChoice(Juego modelo){this.modelo=modelo;}
    public void start(Stage stage) {
        Label titulo_l = new Label("¿Cuál de estos colores no es un color primario?"); //CAMBIAR TEXTO CONSTANTE POR PREGUNTA


        List<String> opciones = List.of("Azul", "Rojo", "Amarillo", "Naranja", "Marrón"); //LISTA DE RESPUESTAS AUX PARA PROBAR
        List<Button> botones = new ArrayList<>();

        // Crear botones para cada respuesta
        for (String opcion : opciones) {
            Button boton = new Button(opcion);
            boton.setOnAction(e -> manejarBoton(opcion));
            botones.add(boton);
        }

        Button responder_b = new Button("Responder");
        responder_b.setOnAction(e -> stage.close());

        VBox vbox = new VBox(20);
        VBox vboxC = new VBox(20);
        HBox HboxU = new HBox(20);
        HBox HboxD = new HBox(20);

        // ACOMODO LOS BOTONES EN HBOX
        for (int i = 0; i < botones.size(); i++) {
            if (i < 2) {
                HboxU.getChildren().add(botones.get(i));
            } else {
                HboxD.getChildren().add(botones.get(i));
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

    private void manejarBoton(String opcion) {
        if (respuestas.contains(opcion)) {
            respuestas.remove(opcion);
        } else {
            respuestas.add(opcion);
        }
        mostrarRespuestas();
    }

    private void mostrarRespuestas() {
        respuestas.forEach(System.out::println);
    }
    public static void main(String[] args) {
        launch(args);
    }
}


