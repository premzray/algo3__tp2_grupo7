package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import edu.fiuba.algo3.modelo.pregunta.*;
import javafx.stage.Stage;

public interface VistaPregunta {

    public static VistaPregunta deTipo(Pregunta pregunta){
        switch (pregunta.tipo()){
            case "VERDADERO FALSO":
                return new Ventana_Pregunta_Respuestas_TrueFalse();
            case "GROUP CHOICE":
                return new Ventana_Pregunta_Respuestas_Group();
            case "MULTIPLE CHOICE":
                return new Ventana_Pregunta_Respuestas_MultChoice();
            case "ORDERED CHOICE":
                return new Ventana_Pregunta_Respuesta_OrderedChoice();
            default:
                return new Ventana_Pregunta_Respuestas_MultChoice();
            //excepcion
        }
    }

    public void start(Stage stage, Jugada jugada, ControladorTurnos controladorTurnos);

    public Respuestas respuestasJugador();

    public void mostrarMensajeError(String mensaje);
}
