package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public abstract class VistaPreguntaTp implements VistaPregunta{

    Respuestas respuestasJugador;

    @Override
    public Respuestas respuestasJugador(){
        return this.respuestasJugador;
    }

    public void addRandomShapes(Pane pane, int numberOfShapes) {
        Random random = new Random();
        Color shapeColor = Color.web("#1a8a82");

        for (int i = 0; i < numberOfShapes; i++) {
            Circle circle = new Circle(random.nextInt(40) + 10);
            circle.setFill(shapeColor);
            pane.getChildren().add(0, circle); // Añadir los círculos al fondo
        }

        // Reubicar las formas una vez añadidas
        relocateShapes(pane);
    }

    public void relocateShapes(Pane pane) {
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
}
