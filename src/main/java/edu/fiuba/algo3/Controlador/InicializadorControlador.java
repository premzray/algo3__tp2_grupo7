package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaInicioDeJuego;
import edu.fiuba.algo3.Vista.VistaSettingJugadores;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.exceptions.NoHayJugadoresException;
import javafx.stage.Stage;

import java.util.ArrayList;

public class InicializadorControlador {
    public Juego juego;
    public VistaInicioDeJuego vistaInicioDeJuego;
    public VistaSettingJugadores vistaSettingJugadores;
    public Stage stage;

    public InicializadorControlador() {
        this.juego = new Juego();
        this.vistaInicioDeJuego = new VistaInicioDeJuego();
        this.vistaSettingJugadores = new VistaSettingJugadores();
        this.stage = new Stage();
    }

    public void inicio(){
        vistaInicioDeJuego.start(stage, this);
    }

    public void setModo(String modo){
        juego.setModo(modo);
    }

    public void jugadores(){
        vistaSettingJugadores.start(stage, this);
    }

    public void setJugadores(ArrayList<String> nombres) throws NoHayJugadoresException {
        juego.setTurnoConvencional(nombres);
    }

    public void jugar(){
        ControladorTurnos controladorTurnos = new ControladorTurnos(juego, stage);
        controladorTurnos.jugarTurno();
    }

}
