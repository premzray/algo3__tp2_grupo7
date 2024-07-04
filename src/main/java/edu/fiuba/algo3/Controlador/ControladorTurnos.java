package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.FinDeRonda;
import edu.fiuba.algo3.Vista.VistaFinDeJuego;
import edu.fiuba.algo3.Vista.VistaPowerUp;
import edu.fiuba.algo3.Vista.VistaPregunta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import edu.fiuba.algo3.modelo.juego.jugador.exceptions.JugadorNoTienePowerUpABorrarException;
import edu.fiuba.algo3.modelo.juego.turno.exceptions.FaltanRespuestasDeJugadoresException;
import javafx.stage.Stage;

public class ControladorTurnos {

    Juego juego;
    Stage stage;

    public ControladorTurnos(Juego juego, Stage stage){
        this.juego = juego;
        this.stage = stage;
    }

    public void jugarTurno(){
        if(!juego.fin()){
            VistaFinDeJuego vistaFinDeJuego = new VistaFinDeJuego();
            vistaFinDeJuego.start(stage, juego.ordenDeJugadores());
        } else{
            juego.prepararTurno();
            responder(juego.getSiguienteJugada());
        }
    }

    public void responder(Jugada jugada){
        VistaPregunta vistaPregunta = VistaPregunta.deTipo(juego.preguntaActual());
        vistaPregunta.start(stage, jugada, this);
    }

    public void elegirPowerUp(Jugada jugada){
        VistaPowerUp vistaPowerUp = new VistaPowerUp();
        vistaPowerUp.start(stage, jugada, this);
    }

    public void avanzarJugada(Jugada jugada) throws FaltanRespuestasDeJugadoresException, JugadorNoTienePowerUpABorrarException {
        jugada.seJugo();
        if(juego.hayProximaJugada()) {
            Jugada jugadaNueva = juego.getSiguienteJugada();
            responder(jugadaNueva);
        } else{
            juego.finDeTurno(jugada.getPregunta());
            FinDeRonda finDeRonda = new FinDeRonda();
            finDeRonda.start(stage, this, juego.jugadas());
        }
    }
}
