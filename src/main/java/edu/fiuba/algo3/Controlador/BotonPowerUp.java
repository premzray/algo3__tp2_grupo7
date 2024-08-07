package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaPowerUp;
import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import edu.fiuba.algo3.modelo.juego.Jugada.exceptions.PowerUpInvalido;
import edu.fiuba.algo3.modelo.juego.jugador.exceptions.JugadorNoTienePowerUpABorrarException;
import edu.fiuba.algo3.modelo.juego.turno.exceptions.FaltanRespuestasDeJugadoresException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonPowerUp implements EventHandler<ActionEvent> {

    private Button miBoton;
    private VistaPowerUp vista;
    private Jugada jugada;
    private ControladorTurnos controlador;

    public BotonPowerUp(Button miBoton, VistaPowerUp vistaPregunta, Jugada jugada, ControladorTurnos controladorTurnos) {
        this.miBoton = miBoton;
        this.vista = vistaPregunta;
        this.jugada = jugada;
        this.controlador = controladorTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            jugada.registrarPowerUp(vista.getPowerUp());
            controlador.avanzarJugada(jugada);
        } catch (FaltanRespuestasDeJugadoresException e) {
            controlador.responder(jugada);
        } catch (JugadorNoTienePowerUpABorrarException e) {
            controlador.elegirPowerUp(jugada);
        } catch (PowerUpInvalido e) {
            controlador.elegirPowerUp(jugada);
        }

    }
}
