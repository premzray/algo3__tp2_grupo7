package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.BotonModo;
import edu.fiuba.algo3.Controlador.InicializadorControlador;
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

public class VistaInicioDeJuego extends Shapes{

    public void start(Stage stage, InicializadorControlador controlador) {
        stage.setTitle("ALGOKAHOOT");

        // Tamaño mínimo de la escena
        double minSceneWidth = 1000;
        double minSceneHeight = 600;

        Button PartidaRapida = new Button("RAPIDA");
        Button PartidaIntensiva = new Button("INTENSIVA");
        PartidaIntensiva.setPrefSize(250, 100);
        PartidaRapida.setPrefSize(250, 100);
        Button cerrar_b = new Button("Cerrar Juego");

        Label titulo_l = new Label();
        Label subt = new Label();

        // Cargar fuente desde archivo .ttf
        Font neonFont = Font.loadFont(getClass().getResourceAsStream("/fonts/lasenter/LasEnter_PersonalUseOnly.ttf"), 64);

        // Título con efecto neón rosa
        titulo_l.setText("ALGOKAHOOT");
        titulo_l.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");
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
        // titulo_l.setEffect(ds);

        subt.setText("[  Selecciona un modo de juego  ]");
        subt.setStyle("-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 32px;" +
                "-fx-text-fill: black;");
        subt.setAlignment(Pos.CENTER);

        cerrar_b.setOnAction(e -> stage.close());

        BotonModo botonModoIntensivo = new BotonModo(PartidaIntensiva, controlador);
        BotonModo botonModoRapido = new BotonModo(PartidaRapida, controlador);

        PartidaIntensiva.setOnAction(botonModoIntensivo);
        PartidaRapida.setOnAction(botonModoRapido);

        // Estilo para los botones según .button-54 con el nuevo color de relleno
        String buttonStyle = "-fx-font-family: 'Open Sans', sans-serif;" +
                "-fx-font-size: 20px;" +
                "-fx-letter-spacing: 2px;" +
                "-fx-text-decoration: none;" +
                "-fx-text-transform: uppercase;" +
                "-fx-text-fill: black;-fx-font-weight: bold;"+
                "-fx-cursor: pointer;" +
                "-fx-border-width: 3px;" +
                "-fx-border-color: black;" +
                "-fx-padding: 0.25em 0.5em;" +
                "-fx-effect: dropshadow(gaussian, black, 1, 0, 1, 1);" +
                "-fx-position: relative;" +
                "-fx-user-select: none;" +
                "-webkit-user-select: none;" +
                "-fx-touch-action: manipulation;" +
                "-fx-opacity: 0.9;"+"-fx-background-color: #358f89;";

        PartidaRapida.setStyle(buttonStyle);
        PartidaIntensiva.setStyle(buttonStyle);
        cerrar_b.setStyle(buttonStyle);

        // Añadir manejadores de eventos para hover y active
        PartidaRapida.setOnMousePressed(e -> PartidaRapida.setStyle(buttonStyle + "-fx-effect: dropshadow(gaussian, black, 0, 0, 0, 0); -fx-translate-x: 5px; -fx-translate-y: 5px;"));
        PartidaRapida.setOnMouseReleased(e -> PartidaRapida.setStyle(buttonStyle));
        PartidaRapida.setOnMouseEntered(e -> PartidaRapida.setOpacity(1.0));
        PartidaRapida.setOnMouseExited(e -> PartidaRapida.setOpacity(0.7));

        PartidaIntensiva.setOnMousePressed(e -> PartidaIntensiva.setStyle(buttonStyle + "-fx-effect: dropshadow(gaussian, black, 0, 0, 0, 0); -fx-translate-x: 5px; -fx-translate-y: 5px;"));
        PartidaIntensiva.setOnMouseReleased(e -> PartidaIntensiva.setStyle(buttonStyle));
        PartidaIntensiva.setOnMouseEntered(e -> PartidaIntensiva.setOpacity(1.0));
        PartidaIntensiva.setOnMouseExited(e -> PartidaIntensiva.setOpacity(0.7));

        cerrar_b.setOnMousePressed(e -> cerrar_b.setStyle(buttonStyle + "-fx-effect: dropshadow(gaussian, black, 0, 0, 0, 0); -fx-translate-x: 5px; -fx-translate-y: 5px;"));
        cerrar_b.setOnMouseReleased(e -> cerrar_b.setStyle(buttonStyle));
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

        // Centrar VBox en el medio de la escena cuando se muestra por primera vez y mientras se cambia el tamaño
        vbox.layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            vbox.setLayoutX((root.getWidth() - newBounds.getWidth()) / 2);
            vbox.setLayoutY((root.getHeight() - newBounds.getHeight()) / 2);
        });

        Scene scene = new Scene(root, minSceneWidth, minSceneHeight);

        // Establecer tamaño mínimo del Stage
        stage.setMinWidth(minSceneWidth);
        stage.setMinHeight(minSceneHeight);

        stage.setScene(scene);
        stage.show();

        // Añadir formas aleatorias al fondo
        addRandomShapes(root, 30);

        // Asegurar que el VBox esté centrado al mostrarse la escena por primera vez
        stage.widthProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutX((root.getWidth() - vbox.getWidth()) / 2));
        stage.heightProperty().addListener((obs, oldVal, newVal) -> vbox.setLayoutY((root.getHeight() - vbox.getHeight()) / 2));
    }
}
