package edu.fiuba.algo3.Vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;

public class VistaFinDeJuego extends Application {

    private List<String> players;

    public VistaFinDeJuego() {
        // Constructor
    }

    public VistaFinDeJuego(List<String> players) {
        this.players = players;
    }

    @Override
    public void start(Stage stage) {
        // Inicializo los jugadores para probar la vista
        if (players == null) {
            players = List.of(
                    "Jugador 11111111",
                    "Jugador 2",
                    "Jugador 3"
            );
        }

        stage.setTitle("Fin del Juego");

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10); // Espacio vertical reducido entre los recuadros
        vbox.setAlignment(Pos.CENTER);

        Label titulo = new Label("[  Podio de Ganadores  ]");
        titulo.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;-fx-padding: 90px;");
        vbox.getChildren().add(titulo);

        Random random = new Random();

        for (String player : players) {
            Label playerLabel = new Label(player);
            playerLabel.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: black;");
            playerLabel.setPadding(new Insets(20));
            playerLabel.setBackground(new Background(new BackgroundFill(Color.web("#1a8a82"), new CornerRadii(10), Insets.EMPTY)));
            playerLabel.setRotate(random.nextInt(20) - 10); // Rotación aleatoria entre -10 y 10 grados
            playerLabel.setStyle("-fx-border-color: black; -fx-border-width: 4px; -fx-padding: 20px; -fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;");

            vbox.getChildren().add(playerLabel);
        }

        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.web("#42a8a1"), CornerRadii.EMPTY, Insets.EMPTY)));

        root.widthProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));
        root.heightProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));

        root.getChildren().add(vbox);

        vbox.layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            vbox.setLayoutX((root.getWidth() - newBounds.getWidth()) / 2);
            vbox.setLayoutY((root.getHeight() - newBounds.getHeight()) / 2);
        });

        Scene scene = new Scene(root, 800, 1000);
        stage.setScene(scene);
        stage.show();

        addRandomShapes(root, 30);

        stage.widthProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutX((root.getWidth() - vbox.getWidth()) / 2));
        stage.heightProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutY((root.getHeight() - vbox.getHeight()) / 2));
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
        Application.launch(VistaFinDeJuego.class, args);
    }
}
