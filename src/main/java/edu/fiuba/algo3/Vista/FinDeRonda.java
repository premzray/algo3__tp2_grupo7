package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FinDeRonda {

    private List<Jugador> players;

    public FinDeRonda() {
        //constructor
    }

    public FinDeRonda(List<Jugador> players) {
        this.players = players;
    }

    public void start(Stage primaryStage, ControladorTurnos controladorTurnos, ArrayList<Jugada> jugadas) {
        //inicializo los jugadores para probar la vista
        if (players == null) {
            players = List.of(
                    Jugador.conNombre("nombre1"),
                    Jugador.conNombre("nombre2"),
                    Jugador.conNombre("nombre3")
            );
        }

        primaryStage.setTitle("Resultados de la Ronda");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Titulos
        gridPane.add(new Label("Jugador"), 0, 0);
        gridPane.add(new Label("Puntos"), 1, 0);
        gridPane.add(new Label("Power-Ups"), 2, 0);

        int row = 1;
        for (Jugador player : players) {
            Label nameLabel = new Label(player.getName());
            Label pointsLabel = new Label(String.valueOf(player.getPuntaje()));
            //aca convierto los powerups de cada jugador en un string
            StringBuilder powerUpsStringBuilder = new StringBuilder();
            for (PowerUp powerUp : player.getPowerUps()) {
                if (powerUpsStringBuilder.length() > 0) {
                    powerUpsStringBuilder.append(", ");
                }
                powerUpsStringBuilder.append(powerUp.getNombre());
            }
            Label powerUpsLabel = new Label(powerUpsStringBuilder.toString());

            gridPane.add(nameLabel, 0, row);
            gridPane.add(pointsLabel, 1, row);
            gridPane.add(powerUpsLabel, 2, row);
            row++;
        }

        Scene scene = new Scene(gridPane, 700, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
