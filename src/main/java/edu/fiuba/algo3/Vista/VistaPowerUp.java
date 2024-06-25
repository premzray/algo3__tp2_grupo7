package edu.fiuba.algo3.Vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPowerUp extends Application {

    @Override
    public void start(Stage stage) {

        Button btnX2 = new Button("X2");
        Button btnX3 = new Button("X3");
        Button btnAnulador = new Button("ANULADOR");
        Button btnMultiplicidad = new Button("EXCLUSIVIDAD");
        Button btnBase = new Button("No usar PowerUp");


        Label titulo = new Label("Selecciona un PowerUp");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        titulo.setAlignment(Pos.CENTER);
        titulo.setMaxWidth(Double.MAX_VALUE);


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));


        gridPane.add(btnX2, 0, 0); // Primera fila, primera columna
        gridPane.add(btnX3, 1, 0); // Primera fila, segunda columna
        gridPane.add(btnAnulador, 0, 1); // Segunda fila, primera columna
        gridPane.add(btnMultiplicidad, 1, 1); // Segunda fila, segunda columna
        gridPane.add(btnBase, 0, 2, 2, 1); // Tercera fila, ocupa dos columnas


        btnX2.setPrefSize(150, 100);
        btnX3.setPrefSize(150, 100);
        btnAnulador.setPrefSize(150, 100);
        btnMultiplicidad.setPrefSize(150, 100);
        btnBase.setPrefSize(310, 100);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titulo, gridPane);

        Scene scene = new Scene(vbox, 400, 400);
        stage.setTitle("Vista Power-Up");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
