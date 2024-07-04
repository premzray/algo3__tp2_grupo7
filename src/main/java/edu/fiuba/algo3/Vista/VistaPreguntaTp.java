package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class VistaPreguntaTp extends Shapes implements VistaPregunta {

    public Respuestas respuestasJugador = new Respuestas();

    @Override
    public Respuestas respuestasJugador() {
        return this.respuestasJugador;
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
