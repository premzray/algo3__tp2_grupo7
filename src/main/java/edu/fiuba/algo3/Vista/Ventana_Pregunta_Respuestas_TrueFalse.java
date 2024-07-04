package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.BotonResponder;
import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ventana_Pregunta_Respuestas_TrueFalse extends VistaPreguntaTp {
    private Button opcionVerdadera;
    private Button opcionFalsa;

    public void start(Stage stage, Jugada jugada, ControladorTurnos controladorTurnos) {
        Label titulo_l = new Label(jugada.getPregunta().getEnunciado());

        // Cargar fuente desde archivo .ttf
        Font neonFont = Font.loadFont(getClass().getResourceAsStream("/fonts/lasenter/LasEnter_PersonalUseOnly.ttf"), 32);
        titulo_l.setMaxWidth(1000);
        titulo_l.setWrapText(true);
        // Título con efecto neón rosa
        titulo_l.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");
        if (neonFont != null) {
            titulo_l.setFont(neonFont);
        } else {
            titulo_l.setFont(new Font("Arial", 32)); // Fallback font
        }

        opcionVerdadera = new Button("VERDADERO");
        opcionFalsa = new Button("FALSO");
        Button responder_b = new Button("RESPONDER");

        opcionVerdadera.setOnAction(e -> manejarBoton(0, opcionVerdadera, opcionFalsa));
        opcionFalsa.setOnAction(e -> manejarBoton(1, opcionVerdadera, opcionFalsa));
        responder_b.setOnAction(e -> {
            if (respuestasJugador.size() == 0) {
                mostrarMensajeError("Debes seleccionar una opción");
            } else {
                BotonResponder botonResponder = new BotonResponder(responder_b, this, jugada, controladorTurnos);
                botonResponder.handle(e);
            }
        });

        // Estilo para los botones "Verdadero" y "Falso"
        String largeButtonStyle = "-fx-font-family: 'Open Sans', sans-serif;" +
                "-fx-font-size: 20px;" +
                "-fx-letter-spacing: 2px;" +
                "-fx-text-decoration: none;" +
                "-fx-text-transform: uppercase;" +
                "-fx-text-fill: black;-fx-font-weight: bold;" +
                "-fx-cursor: pointer;" +
                "-fx-border-width: 3px;" +
                "-fx-border-color: black;" +
                "-fx-padding: 0.25em 0.5em;" +
                "-fx-effect: dropshadow(gaussian, black, 1, 0, 1, 1);" +
                "-fx-position: relative;" +
                "-fx-user-select: none;" +
                "-webkit-user-select: none;" +
                "-fx-touch-action: manipulation;" +
                "-fx-opacity: 0.9;" + "-fx-background-color: #358f89;" +
                "-fx-pref-width: 200px;" +
                "-fx-pref-height: 100px;";

        String largeButtonSelectedStyle = largeButtonStyle + "-fx-background-color: #2a6e63;"; // Color diferente para indicar selección

        opcionVerdadera.setStyle(largeButtonStyle);
        opcionFalsa.setStyle(largeButtonStyle);

        // Estilo para el botón "Responder"
        String smallButtonStyle = "-fx-font-family: 'Open Sans', sans-serif;" +
                "-fx-font-size: 16px;" +
                "-fx-letter-spacing: 2px;" +
                "-fx-text-decoration: none;" +
                "-fx-text-transform: uppercase;" +
                "-fx-text-fill: black;-fx-font-weight: bold;" +
                "-fx-cursor: pointer;" +
                "-fx-border-width: 3px;" +
                "-fx-border-color: black;" +
                "-fx-padding: 0.25em 0.5em;" +
                "-fx-effect: dropshadow(gaussian, black, 1, 0, 1, 1);" +
                "-fx-position: relative;" +
                "-fx-user-select: none;" +
                "-webkit-user-select: none;" +
                "-fx-touch-action: manipulation;" +
                "-fx-opacity: 0.9;" + "-fx-background-color: #358f89;";

        responder_b.setStyle(smallButtonStyle);

        HBox hboxBotones = new HBox(20);
        hboxBotones.getChildren().addAll(opcionVerdadera, opcionFalsa);
        hboxBotones.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(titulo_l, hboxBotones, responder_b);

        // Fondo de color
        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.web("#42a8a1"), CornerRadii.EMPTY, Insets.EMPTY)));

        // Añadir formas aleatorias al fondo después de que la escena esté visible
        root.widthProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));
        root.heightProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));

        root.getChildren().add(vbox);

        Scene escena = new Scene(root, 1350, 700);
        stage.setMinWidth(1350);
        stage.setMinHeight(700);
        vbox.setAlignment(Pos.CENTER);
        stage.setScene(escena);
        stage.setTitle("Respuesta Jugador");
        stage.show();

        // Añadir formas aleatorias al fondo
        addRandomShapes(root, 30);

        // Asegurar que el VBox esté centrado al mostrarse la escena por primera vez
        stage.widthProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutX((root.getWidth() - vbox.getWidth()) / 2));
        stage.heightProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutY((root.getHeight() - vbox.getHeight()) / 2));
    }

    private void manejarBoton(int index, Button opcionVerdadera, Button opcionFalsa) {
        respuestasJugador.vaciar();
        respuestasJugador.add(String.valueOf(index + 1)); // Convertir índice a cadena (empezando desde 1)

        // Restablecer el estilo de ambos botones
        String largeButtonStyle = "-fx-font-family: 'Open Sans', sans-serif;" +
                "-fx-font-size: 20px;" +
                "-fx-letter-spacing: 2px;" +
                "-fx-text-decoration: none;" +
                "-fx-text-transform: uppercase;" +
                "-fx-text-fill: black;-fx-font-weight: bold;" +
                "-fx-cursor: pointer;" +
                "-fx-border-width: 3px;" +
                "-fx-border-color: black;" +
                "-fx-padding: 0.25em 0.5em;" +
                "-fx-effect: dropshadow(gaussian, black, 1, 0, 1, 1);" +
                "-fx-position: relative;" +
                "-fx-user-select: none;" +
                "-webkit-user-select: none;" +
                "-fx-touch-action: manipulation;" +
                "-fx-opacity: 0.9;" + "-fx-background-color: #358f89;" +
                "-fx-pref-width: 200px;" +
                "-fx-pref-height: 100px;";

        String largeButtonSelectedStyle = largeButtonStyle + "-fx-background-color: #2a6e63;"; // Color diferente para indicar selección

        opcionVerdadera.setStyle(largeButtonStyle);
        opcionFalsa.setStyle(largeButtonStyle);

        // Aplicar el estilo seleccionado al botón correspondiente
        if (index == 0) {
            opcionVerdadera.setStyle(largeButtonSelectedStyle);
        } else {
            opcionFalsa.setStyle(largeButtonSelectedStyle);
        }
    }

}
