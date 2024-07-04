package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.BotonIniciarJugadores;
import edu.fiuba.algo3.Controlador.InicializadorControlador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaSettingJugadores {

    private ArrayList<String> jugadores = new ArrayList<>();
    private ListView<String> listViewJugadores = new ListView<>();

    public ArrayList<String> getJugadores() {
        return jugadores;
    }

    public void start(Stage stage, InicializadorControlador controlador) {
        VBox root = new VBox(20); // Separación entre elementos verticales
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER); // Centrar horizontal

        Label label = new Label("[  Ingresar Nombre  ]");
        label.setStyle("-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #EDD3C4;");
        TextField textField = new TextField();
        textField.setStyle("-fx-background-color: #EDD3C4; -fx-text-fill: black;");
        listViewJugadores.setStyle("-fx-background-color: #EDD3C4; -fx-text-fill: black;");
        listViewJugadores.setMaxSize(500, 300);
        Button btnIngresar = new Button("Ingresar");
        Button btnComenzar = new Button("Comenzar");

        // Estilo para los botones con esquinas redondeadas y opacidad inicial reducida
        String buttonStyle = "-fx-background-color: rgba(20, 117, 110, 0.7); -fx-text-fill: #EDD3C4; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 24px; -fx-background-radius: 20;";
        btnIngresar.setStyle(buttonStyle);
        btnComenzar.setStyle(buttonStyle);
        btnIngresar.setOpacity(0.7);
        btnComenzar.setOpacity(0.7);

        // Agregar manejadores de eventos para cambiar la opacidad
        btnIngresar.setOnMouseEntered(e -> btnIngresar.setOpacity(1.0));
        btnIngresar.setOnMouseExited(e -> btnIngresar.setOpacity(0.7));

        btnComenzar.setOnMouseEntered(e -> btnComenzar.setOpacity(1.0));
        btnComenzar.setOnMouseExited(e -> btnComenzar.setOpacity(0.7));

        btnIngresar.setOnAction(event -> {
            String nombreJugador = textField.getText().trim();
            if (!nombreJugador.isEmpty()) {
                jugadores.add(nombreJugador);
                listViewJugadores.getItems().add(nombreJugador);
                textField.clear();
            }
            // else señal de que no ha sido ingresado el jugador.
        });

        BotonIniciarJugadores botonIniciarJugadores = new BotonIniciarJugadores(btnComenzar, controlador, this);
        btnComenzar.setOnAction(botonIniciarJugadores);

        root.getChildren().addAll(label, textField, btnIngresar, listViewJugadores, btnComenzar);
        DropShadow ds = new DropShadow();
        ds.setOffsetY(0);
        ds.setOffsetX(0);
        ds.setSpread(0.55);
        ds.setColor(Color.rgb(0, 0, 0, 0.3));
        ds.setRadius(500);

        // Crear un contenedor con un fondo más claro que el fondo principal
        VBox container = new VBox();
        container.setPadding(new Insets(20));
        container.setMaxSize(700, 800);
        container.setBackground(new Background(new BackgroundFill(Color.web("#40b3ab"), new CornerRadii(10), Insets.EMPTY)));
        container.setBorder(new Border(new BorderStroke(Color.web("#42a8a1"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
        container.setAlignment(Pos.CENTER);

        container.getChildren().add(root);
        container.setEffect(ds);
        Pane mainRoot = new Pane();
        mainRoot.setBackground(new Background(new BackgroundFill(Color.web("#42a8a1"), CornerRadii.EMPTY, Insets.EMPTY)));
        mainRoot.getChildren().add(container);

        // Centrar VBox en el medio de la escena cuando se muestra por primera vez y mientras se cambia el tamaño
        container.layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            container.setLayoutX((mainRoot.getWidth() - newBounds.getWidth()) / 2);
            container.setLayoutY((mainRoot.getHeight() - newBounds.getHeight()) / 2);
        });

        Scene scene = new Scene(mainRoot, 600, 600);

        // Establecer tamaño mínimo del Stage
        stage.setMinWidth(400);
        stage.setMinHeight(400);
        stage.setTitle("Configuración de Jugadores");
        stage.setScene(scene);
        stage.show();

        // Asegurar que el contenedor esté centrado al mostrarse la escena por primera vez
        stage.widthProperty().addListener((obs, oldVal, newVal) -> container.setLayoutX((mainRoot.getWidth() - container.getWidth()) / 2));
        stage.heightProperty().addListener((obs, oldVal, newVal) -> container.setLayoutY((mainRoot.getHeight() - container.getHeight()) / 2));
    }
}
