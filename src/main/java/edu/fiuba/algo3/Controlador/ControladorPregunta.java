package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaPregunta;
import edu.fiuba.algo3.modelo.*;


public abstract class ControladorPregunta extends ObservableConcreto implements Observer {
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
    public void update(Object o){
        VistaPregunta vistaPregunta = crearVentanaPregunta();
        //vistaPregunta.start;
        notifyObservers(this);

    }
}
