package edu.fiuba.algo3.Utilidades;

import edu.fiuba.algo3.Controlador.*;
import edu.fiuba.algo3.modelo.juego.Juego;

public class InicializadorJuego {
    Juego juego;

    public InicializadorJuego(){
        this.juego = new Juego();
    }

    public void iniciar(){
        ControladorVistaInicioDeJuego controladorInicioDeJuego = new ControladorVistaInicioDeJuego(juego);
        juego.settearJuego();
        juego.removeObserver(controladorInicioDeJuego);
    }
}
