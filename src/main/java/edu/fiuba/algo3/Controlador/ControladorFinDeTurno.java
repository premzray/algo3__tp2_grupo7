package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VistaFinDeTurno;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.juego.Turno;


public class ControladorFinDeTurno implements Observer {
    private Turno turno;

    public void ControladorFinDeTurno(Turno turno){
        this.turno = turno;
    }

    public VistaFinDeTurno crearVentanaFinDeTurno(){
        return new VistaFinDeTurno();
    }

    @Override
    public void update(Object o) {
        VistaFinDeTurno vistaFinDeTurno = crearVentanaFinDeTurno();
        //vistaFinDeTurno.start();
    }
}
