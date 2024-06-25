package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.*;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.Observer;

public class ControladorFinDeJuego implements Observer {

    private Juego juego;

    public void ControladorFinDeTurno(Juego juego){
        this.juego = juego;
    }

    public VistaFinDeJuego crearVentanaFinDeJuego(){
        return new VistaFinDeJuego();
    }

    @Override
    public void update(Object o) {
        VistaFinDeJuego vistaFinDeJuego = crearVentanaFinDeJuego();
        //vistaFinDeJuego.start();
    }
}
