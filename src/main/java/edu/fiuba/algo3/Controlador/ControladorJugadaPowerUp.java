package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.Observer;


public class ControladorJugadaPowerUp implements Observer {
    private ControladorPregunta controladorPregunta;
    private Jugada jugada;

    public ControladorJugadaPowerUp(Jugada jugada){
        this.jugada = jugada;
    }

    @Override
    public void update(Object o) {
        jugada.registrarRespuesta(controladorPregunta.getRespuesta());
    }
}
