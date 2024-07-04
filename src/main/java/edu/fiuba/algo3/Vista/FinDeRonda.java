package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.BotonFinDeRonda;
import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FinDeRonda extends Shapes{

    public void start(Stage primaryStage, ControladorTurnos controladorTurnos, ArrayList<Jugada> jugadas) {
        primaryStage.setTitle("Resultados de la Ronda");

        Label titulo = new Label("[  Resultados de la Ronda  ]");
        titulo.setStyle("-fx-text-fill: black; -fx-font-size: 28px; -fx-font-weight: bold;");
        titulo.setAlignment(Pos.CENTER);
        titulo.setMaxWidth(Double.MAX_VALUE);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(titulo);

        for (Jugada jugada : jugadas) {
            HBox playerBox = new HBox();
            playerBox.setPadding(new Insets(10));
            playerBox.setSpacing(20);
            playerBox.setAlignment(Pos.CENTER);
            playerBox.setBackground(new Background(new BackgroundFill(Color.web("#1a8a82"), new CornerRadii(5), Insets.EMPTY)));
            playerBox.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");

            Label nameLabel = new Label(jugada.getJugador().getName());
            nameLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
            Label pointsLabel = new Label(String.valueOf(jugada.getPuntaje()));
            pointsLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");

            // ACA construimos el string de PowerUps
            Map<String, Integer> powerUpCount = new HashMap<>();
            PowerUp powerUp = jugada.getPowerUp();
            powerUpCount.put(powerUp.getNombre(), powerUpCount.getOrDefault(powerUp.getNombre(), 0) + 1);


            StringBuilder powerUpsStringBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> entry : powerUpCount.entrySet()) {
                if (powerUpsStringBuilder.length() > 0) {
                    powerUpsStringBuilder.append(", ");
                }
                powerUpsStringBuilder.append(entry.getValue()).append("x").append(entry.getKey());
            }
            Label powerUpsLabel = new Label(powerUpsStringBuilder.toString());
            powerUpsLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");

            VBox labelsBox = new VBox();
            labelsBox.setSpacing(10);
            labelsBox.setAlignment(Pos.CENTER_LEFT);

            labelsBox.getChildren().addAll(
                    createStyledLabel("Jugador", jugada.getJugador().getName()),
                    createStyledLabel("Puntos", String.valueOf(jugada.getPuntaje())),
                    createStyledLabel("Power-Up", powerUpsStringBuilder.toString())
            );

            playerBox.getChildren().add(labelsBox);
            vbox.getChildren().add(playerBox);
        }

        Button nextRoundButton = new Button("SIGUIENTE RONDA");
        BotonFinDeRonda botonFinDeRonda = new BotonFinDeRonda(nextRoundButton, controladorTurnos);

        nextRoundButton.setOnAction(botonFinDeRonda);

        nextRoundButton.setStyle("-fx-font-family: 'Open Sans', sans-serif;" +
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
                "-fx-opacity: 0.9;" + "-fx-background-color: #358f89;");

        vbox.getChildren().add(nextRoundButton);

        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.web("#42a8a1"), CornerRadii.EMPTY, Insets.EMPTY)));

        root.widthProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));
        root.heightProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));

        root.getChildren().add(vbox);

        vbox.layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            vbox.setLayoutX((root.getWidth() - newBounds.getWidth()) / 2);
            vbox.setLayoutY((root.getHeight() - newBounds.getHeight()) / 2);
        });

        Scene scene = new Scene(root, 1350, 700);
        primaryStage.setMinWidth(1350);
        primaryStage.setMinHeight(700);
        primaryStage.setScene(scene);
        primaryStage.show();

        addRandomShapes(root, 30);

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutX((root.getWidth() - vbox.getWidth()) / 2));
        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutY((root.getHeight() - vbox.getHeight()) / 2));
    }

    private Label createStyledLabel(String title, String value) {
        Label label = new Label(title + ": " + value);
        label.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: black;");
        return label;
    }
}
