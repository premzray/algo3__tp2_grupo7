package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class ALGOKAHOOT extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("ALGOKAHOOT");

        Button jugar_b = new Button();
        jugar_b.setText("Jugar");
        jugar_b.setPrefSize(250,300);
        Button cerrar_b = new Button("Cerrar Juego");

        Label titulo_l = new Label();
        titulo_l.setText("Algokahoot: el mejor juego de preguntas para disfrutar con amigos!!");
        titulo_l.setPrefSize(500, 450);

        cerrar_b.setOnAction(e -> stage.close());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(titulo_l,jugar_b);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 1000, 500);
        stage.setScene(scene);

        stage.show();
    }
}
