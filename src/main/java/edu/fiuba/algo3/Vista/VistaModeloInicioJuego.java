package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class VistaModeloInicioJuego extends Application {

    @Override
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
        subt.setText("Selecciona un modo de juego:");
        titulo_l.setPrefSize(100, 100);
        titulo_l.setAlignment(Pos.CENTER);

        cerrar_b.setOnAction(e -> stage.close());
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
