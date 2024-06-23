package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaPregunta;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas;

import java.util.Observable;
import java.util.Observer;

public abstract class ControladorPregunta extends Observable implements Observer {
    Pregunta pregunta;
    Respuestas respuesta;

    public void ControladorJugada(Pregunta pregunta){
        this.pregunta = pregunta;
    }

    public Respuestas getRespuesta() {
        return respuesta;
    }

    abstract public VistaPregunta crearVentanaPregunta();

    @Override
    public void update(Observable o, Object arg){
        VistaPregunta vistaPregunta = crearVentanaPregunta();
        //vistaPregunta.start;
        notifyObservers();

    }
}
