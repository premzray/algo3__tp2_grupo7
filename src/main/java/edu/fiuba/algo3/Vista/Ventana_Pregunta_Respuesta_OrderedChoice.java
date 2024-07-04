package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.BotonResponder;
import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ventana_Pregunta_Respuesta_OrderedChoice extends VistaPreguntaTp {

    private List<ChoiceBox<Integer>> choiceBoxes;

    @Override
    public void start(Stage stage, Jugada jugada, ControladorTurnos controladorTurnos) {
        // Inicializar lista de ChoiceBoxes
        choiceBoxes = new ArrayList<>();

        // Configurar el título del Stage
        stage.setTitle("ALGOKAHOOT");

        Label preguntaLabel = new Label(jugada.getPregunta().getEnunciado());
        preguntaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        preguntaLabel.setWrapText(true); // Permitir el ajuste de texto
        preguntaLabel.setMaxWidth(800);  // Establecer un ancho máximo

        VBox opcionesBox = new VBox(10); // Contenedor para las opciones
        opcionesBox.setAlignment(Pos.CENTER);

        // Crear opciones de respuesta dinámicamente
        for (int i = 0; i < jugada.getPregunta().getRespuestasPosibles().size(); i++) {
            HBox opcionBox = new HBox(10);
            Label opcionLabel = new Label(jugada.getPregunta().getRespuestasPosibles().get(i));
            opcionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
            ChoiceBox<Integer> posicionChoiceBox = new ChoiceBox<>();

            // Llenar el ChoiceBox con opciones de 1 a n (donde n es el número de respuestas)
            List<Integer> posiciones = new ArrayList<>();
            for (int j = 1; j <= jugada.getPregunta().getRespuestasPosibles().size(); j++) {
                posiciones.add(j);
            }
            posicionChoiceBox.setItems(FXCollections.observableArrayList(posiciones));
            choiceBoxes.add(posicionChoiceBox);

            int finalI = i;
            posicionChoiceBox.setOnAction(event -> {
                manejarBoton(finalI, posicionChoiceBox.getValue());
            });

            opcionBox.getChildren().addAll(opcionLabel, posicionChoiceBox);
            opcionBox.setAlignment(Pos.CENTER);
            opcionesBox.getChildren().add(opcionBox);
        }

        // Botón para enviar respuestas
        Button enviarButton = new Button("RESPONDER");
        enviarButton.setOnAction(new BotonResponder(enviarButton, this, jugada, controladorTurnos));
        stage.setTitle("Respuesta " + jugada.getJugador().getName());

        // Estilo para los botones según el estilo de VistaInicioDeJuego
        String buttonStyle = "-fx-font-family: 'Open Sans', sans-serif;" +
                "-fx-font-size: 24px;" +
                "-fx-letter-spacing: 2px;" +
                "-fx-text-transform: uppercase;" +
                "-fx-text-fill: black;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: pointer;" +
                "-fx-border-width: 3px;" +
                "-fx-border-color: black;" +
                "-fx-padding: 0.25em 0.5em;" +
                "-fx-effect: dropshadow(gaussian, black, 1, 0, 1, 1);" +
                "-fx-position: relative;" +
                "-fx-user-select: none;" +
                "-webkit-user-select: none;" +
                "-fx-touch-action: manipulation;" +
                "-fx-opacity: 0.9;" +
                "-fx-background-color: #358f89;";

        String buttonSelectedStyle = buttonStyle + "-fx-background-color: #2a6e63;"; // Color diferente para indicar selección

        enviarButton.setStyle(buttonStyle);
        enviarButton.setOnAction(event -> {
            if (validarRespuestas()) {
                enviarButton.setStyle(buttonSelectedStyle);
                new BotonResponder(enviarButton, this, jugada, controladorTurnos).handle(event);
            } else {
                mostrarMensajeError("Respuesta inválida, inténtalo de nuevo");
            }
        });

        enviarButton.setOnMousePressed(e -> enviarButton.setStyle(buttonSelectedStyle));
        enviarButton.setOnMouseReleased(e -> enviarButton.setStyle(buttonSelectedStyle));
        enviarButton.setOnMouseEntered(e -> enviarButton.setOpacity(1.0));
        enviarButton.setOnMouseExited(e -> enviarButton.setOpacity(0.7));

        // Layout principal
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(preguntaLabel, opcionesBox, enviarButton);

        // Fondo de color
        Pane backgroundPane = new Pane();
        backgroundPane.setBackground(new Background(new BackgroundFill(Color.web("#42a8a1"), CornerRadii.EMPTY, Insets.EMPTY)));

        // Añadir VBox encima del fondo
        backgroundPane.getChildren().add(root);

        // Centrar VBox en el medio de la escena cuando se muestra por primera vez y mientras se cambia el tamaño
        root.layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            root.setLayoutX((backgroundPane.getWidth() - newBounds.getWidth()) / 2);
            root.setLayoutY((backgroundPane.getHeight() - newBounds.getHeight()) / 2);
        });

        Scene scene = new Scene(backgroundPane, 1350, 700);

        // Ajustar tamaño de la fuente del Label al cambiar el tamaño de la ventana
        backgroundPane.widthProperty().addListener((obs, oldVal, newVal) -> ajustarTamanoFuente(preguntaLabel, newVal.doubleValue()));
        backgroundPane.heightProperty().addListener((obs, oldVal, newVal) -> ajustarTamanoFuente(preguntaLabel, newVal.doubleValue()));

        // Establecer tamaño mínimo del Stage
        stage.setMinWidth(1350);
        stage.setMinHeight(700);

        stage.setScene(scene);
        stage.show();
    }

    private void ajustarTamanoFuente(Label label, double newSize) {
        // Ajusta el tamaño de la fuente según el tamaño de la ventana
        double fontSize = newSize / 40; // Ajustar este valor según sea necesario
        label.setFont(Font.font("Arial", FontWeight.BOLD, fontSize));
    }

    private void manejarBoton(int index, int posicion) {
        String respuesta = String.valueOf(index + 1); // Convertir índice a cadena (empezando desde 1)

        if (respuestasJugador.size() < posicion) {
            for (int i = respuestasJugador.size(); i < posicion - 1; i++) {
                respuestasJugador.add("0", i);
            }
            respuestasJugador.add(respuesta, posicion - 1);
        } else {
            respuestasJugador.set(respuesta, posicion - 1);
        }
    }

    private boolean validarRespuestas() {
        Set<Integer> seen = new HashSet<>();
        for (ChoiceBox<Integer> choiceBox : choiceBoxes) {
            Integer value = choiceBox.getValue();
            if (value == null || !seen.add(value)) {
                return false; //si la respuesta falta o se repite tira false
            }
        }
        return true;
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        super.mostrarMensajeError(mensaje);
    }
}
