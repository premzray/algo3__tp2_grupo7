package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Utilidades.ObservableConcreto;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.Random;

public class VistaInicioDeJuego extends ObservableConcreto {

    public void start(Stage stage) {
        stage.setTitle("ALGOKAHOOT");

        // Tamaño mínimo de la escena
        double minSceneWidth = 1000;
        double minSceneHeight = 600;

        Button PartidaRapida = new Button("Partida Rapida");
        Button PartidaIntensiva = new Button("Partida Intensiva");
        PartidaIntensiva.setPrefSize(250, 100);
        PartidaRapida.setPrefSize(250, 100);
        Button cerrar_b = new Button("Cerrar Juego");

        Label titulo_l = new Label();
        Label subt = new Label();

        // Cargar fuente desde archivo .ttf
        Font neonFont = Font.loadFont(getClass().getResourceAsStream("/fonts/lasenter/LasEnter_PersonalUseOnly.ttf"), 64);

        // Título con efecto neón rosa
        titulo_l.setText("ALGOKAHOOT");
        titulo_l.setStyle("-fx-text-fill: #FF69B4;");
        if (neonFont != null) {
            titulo_l.setFont(neonFont);
        } else {
            titulo_l.setFont(new Font("Arial", 64)); // Fallback font
        }
        DropShadow ds = new DropShadow();
        ds.setOffsetY(0);
        ds.setOffsetX(0);
        ds.setSpread(0.65);
        ds.setColor(Color.rgb(255, 105, 180, 1));
        ds.setRadius(100);
        titulo_l.setEffect(ds);

        subt.setText("[  Selecciona un modo de juego  ]");
        subt.setStyle("-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 32px;" +
                "-fx-text-fill: #EDD3C4;");
        subt.setAlignment(Pos.CENTER);

        cerrar_b.setOnAction(e -> stage.close());

        PartidaIntensiva.setOnAction(e -> {
            notifyObservers("INTENSIVA");
            stage.close();
        });

        PartidaRapida.setOnAction(e -> {
            notifyObservers("RAPIDA");
            stage.close();
        });

        // Estilo para los botones con esquinas redondeadas
        String buttonStyle = "-fx-background-color: rgba(20, 117, 110, 0.7); -fx-text-fill: #EDD3C4; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 24px; -fx-background-radius: 20;";

        PartidaRapida.setStyle(buttonStyle);
        PartidaIntensiva.setStyle(buttonStyle);
        cerrar_b.setStyle(buttonStyle);

        // Agregar manejadores de eventos para cambiar la opacidad
        PartidaRapida.setOnMouseEntered(e -> PartidaRapida.setOpacity(1.0));
        PartidaRapida.setOnMouseExited(e -> PartidaRapida.setOpacity(0.7));

        PartidaIntensiva.setOnMouseEntered(e -> PartidaIntensiva.setOpacity(1.0));
        PartidaIntensiva.setOnMouseExited(e -> PartidaIntensiva.setOpacity(0.7));

        cerrar_b.setOnMouseEntered(e -> cerrar_b.setOpacity(1.0));
        cerrar_b.setOnMouseExited(e -> cerrar_b.setOpacity(0.7));

        HBox hbox = new HBox(20); // Separación entre botones
        VBox vbox = new VBox(30); // Separación entre elementos verticales
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER); // Centrar horizontal
        hbox.setAlignment(Pos.CENTER); // Centrar

        hbox.getChildren().addAll(PartidaRapida, PartidaIntensiva);
        vbox.getChildren().addAll(titulo_l, subt, hbox, cerrar_b);

        // Fondo de color
        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.web("#42a8a1"), CornerRadii.EMPTY, Insets.EMPTY)));

        // Añadir formas aleatorias al fondo después de que la escena esté visible
        root.widthProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));
        root.heightProperty().addListener((obs, oldVal, newVal) -> relocateShapes(root));

        // Añadir VBox encima de las formas
        root.getChildren().add(vbox);

        // Centrar VBox en el medio de la escena
        root.widthProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutX((newVal.doubleValue() - vbox.getWidth()) / 2));
        root.heightProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutY((newVal.doubleValue() - vbox.getHeight()) / 2));

        Scene scene = new Scene(root, minSceneWidth, minSceneHeight);

        // Establecer tamaño mínimo del Stage
        stage.setMinWidth(minSceneWidth);
        stage.setMinHeight(minSceneHeight);

        stage.setScene(scene);
        stage.show();

        // Añadir formas aleatorias al fondo
        addRandomShapes(root, 30);
    }

    private void addRandomShapes(Pane pane, int numberOfShapes) {
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
}
