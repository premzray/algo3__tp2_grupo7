package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugada;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ventana_Pregunta_Respuestas_Group extends VistaPreguntaTp{
    private Juego modelo;
    private List<Integer> respuestasA = new ArrayList<>();
    private List<Integer> respuestasB = new ArrayList<>();
    private static final String QUESTION = "¿Cuál es tu color favorito?";
    private static final String[] ANSWERS = {"Rojo", "Azul", "Verde", "Amarillo", "Negro", "Matias Candia"};

    public void Ventana_Pregunta_Respuestas_Group(Juego modelo) {
        this.modelo = modelo;
    }

    public void start(Stage stage, Jugada jugada, ControladorTurnos controladorTurnos) {
        Label titulo_l = new Label(QUESTION);
//esto no esta funcionndo
        // Cargar fuente desde archivo .ttf
        Font neonFont = Font.loadFont(getClass().getResourceAsStream("/fonts/lasenter/LasEnter_PersonalUseOnly.ttf"), 32);

        // Título con efecto neón rosa
        titulo_l.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");
        if (neonFont != null) {
            titulo_l.setFont(neonFont);
        } else {
            titulo_l.setFont(new Font("Arial", 32)); // Fallback font
        }

        List<HBox> hboxes = new ArrayList<>();
        ToggleGroup[] groups = new ToggleGroup[ANSWERS.length];
//creo botones A y B para cada opcion de respuesta y la label
        for (int i = 0; i < ANSWERS.length; i++) {
            Label answerLabel = new Label(ANSWERS[i]);
            answerLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            RadioButton groupAButton = new RadioButton("GRUPO A");
            RadioButton groupBButton = new RadioButton("GRUPO B");

            groups[i] = new ToggleGroup();
            groupAButton.setToggleGroup(groups[i]);
            groupBButton.setToggleGroup(groups[i]);

            HBox hbox = new HBox(20, answerLabel, groupAButton, groupBButton);
            hbox.setAlignment(Pos.CENTER);
            hboxes.add(hbox);
        }

        Button responder_b = new Button("Responder");
        responder_b.setOnAction(e -> {
            mostrarGrupos(groups);
            stage.close();
        });

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(titulo_l);
        vbox.getChildren().addAll(hboxes);
        vbox.getChildren().add(responder_b);

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
//esto tampoco esta funcionando, la onda es subir la opacidad cuando el mouse pasa por arriba
        for (HBox hbox : hboxes) {
            for (int j = 1; j < hbox.getChildren().size(); j++) {
                RadioButton button = (RadioButton) hbox.getChildren().get(j);
                button.setStyle(buttonStyle);
                button.setOnMousePressed(e -> button.setStyle(buttonStyle + "-fx-effect: dropshadow(gaussian, black, 0, 0, 0, 0); -fx-translate-x: 5px; -fx-translate-y: 5px;"));
                button.setOnMouseReleased(e -> button.setStyle(buttonStyle));
                button.setOnMouseEntered(e -> button.setOpacity(1.0));
                button.setOnMouseExited(e -> button.setOpacity(0.7));
            }
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
        stage.setTitle("Respuesta Jugador");
        stage.show();

        // Añadir formas aleatorias al fondo
        addRandomShapes(root, 30);

        // Asegurar que el VBox esté centrado al mostrarse la escena por primera vez
        stage.widthProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutX((root.getWidth() - vbox.getWidth()) / 2));
        stage.heightProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutY((root.getHeight() - vbox.getHeight()) / 2));
    }

    private void mostrarGrupos(ToggleGroup[] groups) {
        for (int i = 0; i < groups.length; i++) {
            ToggleGroup group = groups[i];
            RadioButton selectedButton = (RadioButton) group.getSelectedToggle();
            if (selectedButton != null) {
                String selectedGroup = selectedButton.getText();
                //ACA AGREGO LA RESPUESTA SEGUN PERTENEZCA AL GRUPO A O B
                if (selectedGroup.equals("GRUPO A")) {
                    respuestasA.add(i + 1);
                } else if (selectedGroup.equals("GRUPO B")) {
                    respuestasB.add(i + 1);
                }
            }
        }

        System.out.println("GRUPO A: " + respuestasA);
        System.out.println("GRUPO B: " + respuestasB);
    }
}
