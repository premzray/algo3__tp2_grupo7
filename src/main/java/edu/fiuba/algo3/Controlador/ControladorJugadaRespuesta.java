package edu.fiuba.algo3.Controlador;
import edu.fiuba.algo3.modelo.Jugada;

import java.util.Observable;
import java.util.Observer;

    public class ControladorJugadaRespuesta implements Observer {
        private ControladorPregunta controladorPregunta;
        private Jugada jugada;

        public ControladorJugadaRespuesta(Jugada jugada){
            this.jugada = jugada;
        }

        @Override
        public void update(Observable o, Object arg) {
            jugada.registrarRespuesta(controladorPregunta.getRespuesta());
        }
    }

