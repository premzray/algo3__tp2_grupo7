package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.JugadorTp;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.powerup.PowerUpTp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.List;
import java.util.stream.Collectors;

public class FinDeRonda extends Application {

    private List<Jugador> players;

    public FinDeRonda(List<Jugador> players) {
        this.players = players;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Resultados de la Ronda");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // titulos
        gridPane.add(new Label("Jugador"), 0, 0);
        gridPane.add(new Label("Puntos"), 1, 0);
        gridPane.add(new Label("Power-Ups"), 2, 0);

        int row = 1;
        for (Jugador player : players) {
            Label nameLabel = new Label(player.getName());
            Label pointsLabel = new Label(String.valueOf(player.getPuntaje()));
            //aca estoy convirtiendo la lista de powerups de cada jugador en un string
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

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//probando
    public static void main(String[] args) {
        List<Jugador> players = List.of(
                Jugador.conNombre("nombre1"),Jugador.conNombre("nombre2"),Jugador.conNombre("nombre3")
        );
        FinDeRonda view = new FinDeRonda(players);
        view.start(new Stage());
    }
}
