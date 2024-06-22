package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaFinDeJuego;
import edu.fiuba.algo3.Vista.VistaFinDeTurno;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.Turno;

import java.util.Observable;
import java.util.Observer;

public class ControladorFinDeJuego implements Observer {

    private Juego juego;

    public void ControladorFinDeTurno(Juego juego){
        this.juego = juego;
    }

    public VistaFinDeJuego crearVentanaFinDeJuego(){
        return new VistaFinDeJuego();
    }

    @Override
    public void update(Observable o, Object arg) {
        VistaFinDeJuego vistaFinDeJuego = crearVentanaFinDeJuego();
        //vistaFinDeJuego.start();
    }
}
