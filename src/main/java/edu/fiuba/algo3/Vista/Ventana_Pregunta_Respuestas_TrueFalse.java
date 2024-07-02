package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
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

public class Ventana_Pregunta_Respuestas_TrueFalse extends VistaPreguntaTp {
    private List<String> respuestas = new ArrayList<>();
    private Respuestas respuestasJugador;
    private CheckBox opcionCorrecta;
    private CheckBox opcionIncorrecta;

    @Override
    public void start(Stage stage, Jugada jugada, ControladorTurnos controladorTurnos) {
        Label titulo_l = new Label("San Martin creó la bandera argentina");
        opcionCorrecta = new CheckBox("Verdadero");
        opcionIncorrecta = new CheckBox("Falso");
        Button responder_b = new Button("Responder");

        opcionCorrecta.setOnAction(e -> manejarCheckedBox(opcionCorrecta, opcionIncorrecta));
        opcionIncorrecta.setOnAction(e -> manejarCheckedBox(opcionIncorrecta, opcionCorrecta));
        responder_b.setOnAction(e -> stage.close());

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(titulo_l, opcionCorrecta, opcionIncorrecta, responder_b);

        Scene escena = new Scene(vbox, 300, 150);
        vbox.setAlignment(Pos.CENTER);
        stage.setScene(escena);
        stage.setTitle("Respuestas");
        stage.show();
    }

    private void mostrarRespuestas() {
        respuestas.forEach(System.out::println);
    }

    private void manejarCheckedBox(CheckBox selected, CheckBox other) {
        if (selected.isSelected()) {
            respuestas.clear();
            respuestas.add(selected.getText());
            other.setSelected(false);
        } else {
            respuestas.remove(selected.getText());
        }
        mostrarRespuestas();
    }
}
