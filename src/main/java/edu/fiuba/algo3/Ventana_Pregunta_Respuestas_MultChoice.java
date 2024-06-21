package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Ventana_Pregunta_Respuestas_MultChoice extends Application {
    private List<String> respuestas = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Label titulo_l = new Label("Cual de estos colores no es un color primario?");
        CheckBox opcion1 = new CheckBox("Azul");
        CheckBox opcion2 = new CheckBox("Rojo");
        CheckBox opcion3 = new CheckBox("Amarillo");
        CheckBox opcion4 = new CheckBox("Naranja");
        CheckBox opcion5 = new CheckBox("Marron");
        Button responder_b = new Button("Responder");

        opcion1.setOnAction(e -> manejarCheckedBox(opcion1));
        opcion2.setOnAction(e -> manejarCheckedBox(opcion2));
        opcion3.setOnAction(e -> manejarCheckedBox(opcion3));
        opcion4.setOnAction(e -> manejarCheckedBox(opcion4));
        opcion5.setOnAction(e -> manejarCheckedBox(opcion5));
        responder_b.setOnAction(e -> stage.close());

        VBox vbox = new VBox(20);
        VBox vboxC = new VBox(20);
        HBox HboxU = new HBox(20);
        HBox HboxD = new HBox(20);

        HboxU.getChildren().addAll(opcion1, opcion2);
        HboxD.getChildren().addAll(opcion3, opcion4, opcion5);
        vboxC.getChildren().addAll(HboxU, HboxD);

        // Alinear los VBoxes y HBoxes en el centro
        HboxU.setAlignment(Pos.CENTER);
        HboxD.setAlignment(Pos.CENTER);
        vboxC.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titulo_l,vboxC,responder_b);

        Scene escena = new Scene(vbox, 500, 300);
        vbox.setAlignment(Pos.CENTER);
        stage.setScene(escena);
        stage.setTitle("Respuesta Jugador");
        stage.show();
    }

    private void mostrarRespuestas(){
        respuestas.forEach(System.out::println);
    }

    private void manejarCheckedBox(CheckBox checkbox){
        if(checkbox.isSelected()){
            respuestas.add(checkbox.getText());
        }
        else{
            respuestas.remove(checkbox.getText());
        }
        mostrarRespuestas();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
