package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.BotonResponder;
import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Ventana_Pregunta_Respuestas_MultChoice extends VistaPreguntaTp {

    public void start(Stage stage, Jugada jugada, ControladorTurnos controladorTurnos) {
        Label titulo_l = new Label(jugada.getPregunta().getEnunciado());

        // Cargar fuente desde archivo .ttf
        Font neonFont = Font.loadFont(getClass().getResourceAsStream("src/main/fonts/lasenter/LasEnter_PersonalUseOnly.ttf"), 32);

        // Título con efecto neón rosa
        titulo_l.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");
        if (neonFont != null) {
            titulo_l.setFont(neonFont);
        } else {
            titulo_l.setFont(new Font("Arial", 32)); // Fallback font
        }

        Respuestas opciones = jugada.getPregunta().getRespuestasPosibles();
        List<Button> botones = new ArrayList<>();

        // Crear botones para cada respuesta
        for (int i = 0; i < opciones.size(); i++) {
            String opcion = opciones.get(i);
            Button boton = new Button(opcion);
            int finalI = i;
            boton.setOnAction(e -> manejarBoton(finalI, boton));
            botones.add(boton);
        }

        Button responder_b = new Button("RESPONDER");
        responder_b.setOnAction(e -> {
            if (respuestasJugador.size() == 0) {
                mostrarMensajeError("Debes seleccionar al menos una opción");
            } else {
                BotonResponder botonResponder = new BotonResponder(responder_b, this, jugada, controladorTurnos);
                botonResponder.handle(e);
            }
        });

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

        titulo_l.setMaxWidth(1000);
        titulo_l.setWrapText(true);

        vbox.getChildren().addAll(titulo_l, vboxC, responder_b);

        // Estilo para los botones
        String buttonStyle = "-fx-font-family: 'Open Sans', sans-serif;" +
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

        String buttonSelectedStyle = buttonStyle + "-fx-background-color: #2a6e63;"; // Color diferente para indicar selección

        for (Button boton : botones) {
            boton.setStyle(buttonStyle);
            boton.setOnMousePressed(e -> boton.setStyle(buttonStyle + "-fx-effect: dropshadow(gaussian, black, 0, 0, 0, 0); -fx-translate-x: 5px; -fx-translate-y: 5px;"));
            boton.setOnMouseReleased(e -> {
                if (respuestasJugador.contiene(String.valueOf(botones.indexOf(boton) + 1))) {
                    boton.setStyle(buttonSelectedStyle);
                } else {
                    boton.setStyle(buttonStyle);
                }
            });
            boton.setOnMouseEntered(e -> boton.setOpacity(1.0));
            boton.setOnMouseExited(e -> boton.setOpacity(0.7));
        }

        responder_b.setStyle(buttonStyle);
        responder_b.setOnMousePressed(e -> responder_b.setStyle(buttonStyle + "-fx-effect: dropshadow(gaussian, black, 0, 0, 0, 0); -fx-translate-x: 5px; -fx-translate-y: 5px;"));
        responder_b.setOnMouseReleased(e -> responder_b.setStyle(buttonStyle));
        responder_b.setOnMouseEntered(e -> responder_b.setOpacity(1.0));
        responder_b.setOnMouseExited(e -> responder_b.setOpacity(0.7));

        // Fondo de color
        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.web("#42a8a1"), CornerRadii.EMPTY, Insets.EMPTY)));

        // Añadir formas aleatorias al fondo después de que la escena esté visible
        root.widthProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));
        root.heightProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));

        root.getChildren().add(vbox);

        Scene escena = new Scene(root, 1350, 700);
        vbox.setAlignment(Pos.CENTER);
        stage.setScene(escena);
        stage.setMinWidth(1350);
        stage.setMinHeight(700);
        stage.setTitle("Respuesta " + jugada.getJugador().getName());
        stage.show();

        // Añadir formas aleatorias al fondo
        addRandomShapes(root, 30);

        // Asegurar que el VBox esté centrado al mostrarse la escena por primera vez
        vbox.layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            vbox.setLayoutX((root.getWidth() - newBounds.getWidth()) / 2);
            vbox.setLayoutY((root.getHeight() - newBounds.getHeight()) / 2);
        });

        // Centrar VBox cuando se cambie el tamaño del Stage
        root.widthProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutX((newVal.doubleValue() - vbox.getWidth()) / 2));
        root.heightProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutY((newVal.doubleValue() - vbox.getHeight()) / 2));
    }

    private void manejarBoton(int index, Button boton) {
        String respuesta = String.valueOf(index + 1); // Convertir índice a cadena (empezando desde 1)

        if (respuestasJugador.contiene(respuesta)) {
            respuestasJugador.delete(respuesta);
            boton.setStyle("-fx-font-family: 'Open Sans', sans-serif;" +
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
                    "-fx-opacity: 0.9;" + "-fx-background-color: #358f89;");
        } else {
            respuestasJugador.add(respuesta);
            boton.setStyle("-fx-font-family: 'Open Sans', sans-serif;" +
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
                    "-fx-opacity: 0.9;" + "-fx-background-color: #2a6e63;"); // Estilo de botón seleccionado
        }
    }
}
