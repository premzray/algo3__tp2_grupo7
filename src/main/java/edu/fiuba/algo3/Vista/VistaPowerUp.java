package edu.fiuba.algo3.Vista;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VistaPowerUp extends Application {

    @Override
    public void start(Stage stage) {
        List<String> powerUpDisponibles = Arrays.asList("X2", "X3", "ANULADOR", "EXCLUSIVIDAD", "No usar PowerUp");

        Label titulo = new Label("[  Selecciona un PowerUp  ]");
        titulo.setStyle("-fx-text-fill: black;-fx-font-size: 24px; -fx-font-weight: bold;");
        titulo.setAlignment(Pos.CENTER);
        titulo.setMaxWidth(Double.MAX_VALUE);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        String buttonStyle = "-fx-font-family: 'Open Sans', sans-serif;" +
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
                "-fx-opacity: 0.9;" + "-fx-background-color: #358f89;";

        int row = 0;
        int col = 0;
        for (int i = 0; i < powerUpDisponibles.size(); i++) {
            Button button = new Button(powerUpDisponibles.get(i));
            button.setStyle(buttonStyle);
            button.setPrefWidth(250);
            button.setPrefHeight(100);
            button.setWrapText(true);

            if (i == (powerUpDisponibles.size() - 1) && powerUpDisponibles.size() % 2 != 0) {
                gridPane.add(button, 0, row, 2, 1);
                button.setMaxWidth(Double.MAX_VALUE);
            } else {
                gridPane.add(button, col, row);
                col++;
                if (col > 1) {
                    col = 0;
                    row++;
                }
            }
        }

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titulo, gridPane);

        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.web("#42a8a1"), CornerRadii.EMPTY, Insets.EMPTY)));

        root.widthProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));
        root.heightProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));

        root.getChildren().add(vbox);

        vbox.layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            vbox.setLayoutX((root.getWidth() - newBounds.getWidth()) / 2);
            vbox.setLayoutY((root.getHeight() - newBounds.getHeight()) / 2);
        });

        Scene scene = new Scene(root, 600, 600);
        stage.setMinWidth(600);
        stage.setMinHeight(600);
        stage.setTitle("Vista Power-Up");
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
        launch(args);
    }
}
