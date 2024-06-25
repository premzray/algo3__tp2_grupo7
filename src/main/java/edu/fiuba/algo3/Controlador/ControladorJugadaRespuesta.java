package edu.fiuba.algo3.Controlador;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.Observer;


public class ControladorJugadaRespuesta implements Observer {
        private ControladorPregunta controladorPregunta;
        private Jugada jugada;

        public ControladorJugadaRespuesta(Jugada jugada){
            this.jugada = jugada;
        }

        @Override
        public void update(Object o) {
            jugada.registrarRespuesta(controladorPregunta.getRespuesta());
        }
    }

