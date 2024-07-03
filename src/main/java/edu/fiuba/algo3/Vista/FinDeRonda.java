package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FinDeRonda extends Application {

    private List<Jugador> players; //RECIBO LISTA DE JUGADORES

    public FinDeRonda() {
        //constructor
    }

    public FinDeRonda(List<Jugador> players) {
        this.players = players;
    }

    @Override
    public void start(Stage primaryStage) {
        //inicializo los jugadores para probar la vista
        if (players == null) {
            players = List.of(
                    Jugador.conNombre("nombre1"),
                    Jugador.conNombre("nombre2"),
                    Jugador.conNombre("nombre3")
            );
        }

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

        for (Jugador player : players) {
            HBox playerBox = new HBox();
            playerBox.setPadding(new Insets(10));
            playerBox.setSpacing(20);
            playerBox.setAlignment(Pos.CENTER);
            playerBox.setBackground(new Background(new BackgroundFill(Color.web("#1a8a82"), new CornerRadii(5), Insets.EMPTY)));
            playerBox.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");

            Label nameLabel = new Label(player.getName());
            nameLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
            Label pointsLabel = new Label(String.valueOf(player.getPuntaje()));
            pointsLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");

            // ACA construimos el string de PowerUps
            Map<String, Integer> powerUpCount = new HashMap<>();
            for (PowerUp powerUp : player.getPowerUps()) {
                powerUpCount.put(powerUp.getNombre(), powerUpCount.getOrDefault(powerUp.getNombre(), 0) + 1);
            }

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
                    createStyledLabel("Jugador", player.getName()),
                    createStyledLabel("Puntos", String.valueOf(player.getPuntaje())),
                    createStyledLabel("Power-Ups", powerUpsStringBuilder.toString())
            );

            playerBox.getChildren().add(labelsBox);
            vbox.getChildren().add(playerBox);
        }
        //NO ESTA CODEADO EL SET ON ACTION, PASA A LA PROXIMA INSTANCIA DE RONDA
        Button nextRoundButton = new Button("Pasar a la siguiente ronda");
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

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
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

    private void addRandomShapes(Pane pane, int numberOfShapes) {
        Random random = new Random();
        Color shapeColor = Color.web("#1a8a82");

        for (int i = 0; i < numberOfShapes; i++) {
            Circle circle = new Circle(random.nextInt(40) + 10);
            circle.setFill(shapeColor);
            pane.getChildren().add(0, circle);
        }

        relocateShapes(pane);
    }

    private void relocateShapes(Pane pane) {
        Random random = new Random();
        double width = pane.getWidth();
        double height = pane.getHeight();

        pane.getChildren().stream()
                .filter(node -> node instanceof Circle)
                .forEach(node -> {
                    Circle circle = (Circle) node;
                    circle.setLayoutX(random.nextDouble() * width);
                    circle.setLayoutY(random.nextDouble() * height);
                });
    }

    public static void main(String[] args) {
        Application.launch(FinDeRonda.class, args);
    }
}
