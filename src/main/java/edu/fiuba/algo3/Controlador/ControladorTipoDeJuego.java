package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaInicioDeJuego;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.Observer;

import java.util.Objects;

public class ControladorTipoDeJuego implements Observer {
    private Juego juego;
    private VistaInicioDeJuego vistaInicioDeJuego;

    public ControladorTipoDeJuego(Juego juego, VistaInicioDeJuego vistaInicioDeJuego){
        this.juego = juego;
        this.vistaInicioDeJuego = vistaInicioDeJuego;
        vistaInicioDeJuego.addObserver(this);
    }

    @Override
    public void update(Object o) {
        if(Objects.equals((String) o, "RAPIDA")){
            juego.configurarLimitesRapidos();
        } else{
            juego.configurarLimitesIntensivos();
        }

        ControladorVistaIngresoJugadores controladorIngresoJugadores = new ControladorVistaIngresoJugadores(juego);
        juego.settearJugadores();
        juego.removeObserver(controladorIngresoJugadores);
    }
}
