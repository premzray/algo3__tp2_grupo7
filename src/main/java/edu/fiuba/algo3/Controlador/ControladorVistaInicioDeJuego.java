package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Utilidades.Observer;
import edu.fiuba.algo3.Vista.VistaInicioDeJuego;
import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.stage.Stage;

public class ControladorVistaInicioDeJuego implements Observer {
    private Juego juego;

    public ControladorVistaInicioDeJuego(Juego juego){
        this.juego = juego;
        juego.addObserver(this);
    }

    public VistaInicioDeJuego crearVentanaInicioDeJuego(){
        return new VistaInicioDeJuego();
    }

    @Override
    public void update(Object o) {
        VistaInicioDeJuego vistaInicioDeJuego = crearVentanaInicioDeJuego();
        ControladorTipoDeJuego controladorTipoDeJuego = new ControladorTipoDeJuego(juego, vistaInicioDeJuego);
        Stage stage = new Stage();
        vistaInicioDeJuego.start(stage);

    }
}