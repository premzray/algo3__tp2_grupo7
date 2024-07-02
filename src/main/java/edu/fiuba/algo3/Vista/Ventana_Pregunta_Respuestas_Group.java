package edu.fiuba.algo3.Vista;
import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Ventana_Pregunta_Respuestas_Group extends VistaPreguntaTp{
    //ejemplos, enlazar luego con el modelo
    private static final String QUESTION = "¿Cuál es tu color favorito?";
    private static final String[] ANSWERS = {"Rojo", "Azul", "Verde", "Amarillo", "Negro","Matias Candia"};

    @Override
    public void start(Stage primaryStage, Jugada jugada, ControladorTurnos controladorTurnos) {
        primaryStage.setTitle("Selección de Grupo");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label questionLabel = new Label(QUESTION);
        gridPane.add(questionLabel, 0, 0, 2, 1);

        ToggleGroup[] groups = new ToggleGroup[ANSWERS.length]; //ajusto los botones para cada una de las respuestas
        for (int i = 0; i < ANSWERS.length; i++) {
            Label answerLabel = new Label(ANSWERS[i]);
            gridPane.add(answerLabel, 0, i + 1);

            RadioButton groupAButton = new RadioButton("GRUPO A");
            RadioButton groupBButton = new RadioButton("GRUPO B");
            groups[i] = new ToggleGroup();
            groupAButton.setToggleGroup(groups[i]);
            groupBButton.setToggleGroup(groups[i]);

            gridPane.add(groupAButton, 1, i + 1);
            gridPane.add(groupBButton, 2, i + 1);
        }

        Button submitButton = new Button("Enviar");
        submitButton.setOnAction(e -> mostrarGrupos(groups));
        gridPane.add(submitButton, 0, ANSWERS.length + 1, 3, 1);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarGrupos(ToggleGroup[] groups) {
        for (int i = 0; i < groups.length; i++) {
            ToggleGroup group = groups[i];
            RadioButton selectedButton = (RadioButton) group.getSelectedToggle();
            if (selectedButton != null) {
                String selectedGroup = selectedButton.getText();
                System.out.println("Respuesta: " + ANSWERS[i] + " -> " + selectedGroup);
            } else {
                System.out.println("Respuesta: " + ANSWERS[i] + " no tiene grupo seleccionado.");
                //se toma directamente como incorrecto
            }
        }
    }

}
