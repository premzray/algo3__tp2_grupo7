package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Ventana_Pregunta_Respuestas_TrueFalse extends Application {
    private List<String> respuestas = new ArrayList<>();
    @Override
    public void start(Stage stage) {
        Label titulo_l = new Label("San Martin creo la bandera argentina");
        CheckBox opcionCorrecta = new CheckBox("Verdadero");
        CheckBox opcionIncorrecta = new CheckBox("Falso");
        Button responder_b = new Button("Responder");

        opcionCorrecta.setOnAction(e -> manejarCheckedBox(opcionCorrecta));
        opcionIncorrecta.setOnAction(e -> manejarCheckedBox(opcionIncorrecta));
        responder_b.setOnAction(e -> stage.close());

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(titulo_l,opcionCorrecta, opcionIncorrecta, responder_b);

        Scene escena = new Scene(vbox, 300, 150);
        vbox.setAlignment(Pos.CENTER);
        stage.setScene(escena);
        stage.setTitle("Respuestas");
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
        //System.out.println("Respuestas selecionadas: ");
        mostrarRespuestas();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
