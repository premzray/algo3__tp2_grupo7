package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaFinDeTurno;
import edu.fiuba.algo3.modelo.Turno;

import java.util.Observable;
import java.util.Observer;

public class ControladorFinDeTurno implements Observer {
    private Turno turno;

    public void ControladorFinDeTurno(Turno turno){
        this.turno = turno;
    }

    public VistaFinDeTurno crearVentanaFinDeTurno(){
        return new VistaFinDeTurno();
    }

    @Override
    public void update(Observable o, Object arg) {
        VistaFinDeTurno vistaFinDeTurno = crearVentanaFinDeTurno();
        //vistaFinDeTurno.start();
    }
}
