package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPowerUp {

    public void start(Stage stage) {
        // Crear botones
        Button btnX2 = new Button("X2");
        Button btnX3 = new Button("X3");
        Button btnAnulador = new Button("ANULADOR");
        Button btnMultiplicidad = new Button("EXCLUSIVIDAD");
        Button btnBase = new Button("No usar PowerUp");
        Label titulo = new Label("Selecciona un PowerUp");
        titulo.setAlignment(Pos.CENTER);
        // Crear GridPane para organizar los botones
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Espacio horizontal entre los elementos
        gridPane.setVgap(10); // Espacio vertical entre los elementos
        gridPane.setPadding(new Insets(10)); // Espacio alrededor del GridPane

        // Colocar botones en el GridPane
        gridPane.add(btnX2, 0, 0); // Primera fila, primera columna
        gridPane.add(btnX3, 1, 0); // Primera fila, segunda columna
        gridPane.add(btnAnulador, 0, 1); // Segunda fila, primera columna
        gridPane.add(btnMultiplicidad, 1, 1); // Segunda fila, segunda columna
        gridPane.add(btnBase, 0, 2, 2, 1); // Tercera fila, ocupa dos columnas
        btnBase.setMaxWidth(Double.MAX_VALUE);
        btnX2.setMaxWidth(Double.MAX_VALUE);
        btnX3.setMaxWidth(Double.MAX_VALUE);
        btnX2.setPrefSize(150,100);
        btnX3.setPrefSize(150,100);
        btnAnulador.setPrefSize(150,100);
        btnMultiplicidad.setPrefSize(150,100);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(100));
        vbox.setSpacing(10);
        vbox.getChildren().addAll(titulo,gridPane);
        // Crear la escena con el GridPane
        Scene scene = new Scene(vbox, 300, 200);
        stage.setTitle("Vista Power-Up");
        stage.setScene(scene);
        stage.show();
    }
}
