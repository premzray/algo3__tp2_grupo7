package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.ObservableConcreto;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class VistaInicioDeJuego extends ObservableConcreto {

    public void start(Stage stage){
        stage.setTitle("ALGOKAHOOT");

        Button PartidaRapida = new Button("Partida Rapida");
        Button PartidaIntensiva = new Button("Partida Intensiva");
        PartidaIntensiva.setPrefSize(200,100);
        PartidaRapida.setPrefSize(200,100);
        Button cerrar_b = new Button("Cerrar Juego");

        Label titulo_l = new Label();
        Label subt = new Label();

        titulo_l.setText("ALGOKAHOOK");
        titulo_l.setStyle("-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 36px;" +
                "-fx-text-fill: #FF69B4;");

        subt.setText("Selecciona un modo de juego:");
        titulo_l.setPrefSize(300, 100);
        titulo_l.setAlignment(Pos.CENTER);

        cerrar_b.setOnAction(e -> stage.close());

        PartidaIntensiva.setOnAction(e -> {
            notifyObservers("INTENSIVA");
            stage.close();
        });

        PartidaRapida.setOnAction(e -> {
            notifyObservers("RAPIDA");
            stage.close();
        });

        HBox hbox= new HBox();
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        hbox.getChildren().addAll(PartidaRapida,PartidaIntensiva);
        vbox.getChildren().addAll(titulo_l,subt,hbox,cerrar_b);
        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 1000, 500);
        stage.setScene(scene);

        stage.show();
    }
}
