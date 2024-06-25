package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.Utilidades.ObservableConcreto;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public class TurnoTp extends ObservableConcreto implements Turno{
    ArrayList<Jugada> jugadas = new ArrayList<Jugada>();;

    public TurnoTp(ArrayList<Jugador> jugadores){
        this.inicializarJugadas(jugadores);
    }

    @Override
    public void agregarJugada(Jugada jugada){
        this.jugadas.add(jugada);
    }

    private void inicializarJugadas(ArrayList<Jugador> jugadores){
        for(Jugador jugador : jugadores){
            this.agregarJugada(Jugada.deJugador(jugador));
        }
    }

    private ArrayList<Integer> listaPuntos(){
        ArrayList<Integer> puntos = new ArrayList<Integer>();

        for(Jugada jugada : jugadas){
            puntos.add(jugada.getPuntaje());
        }

        return puntos;
    } //devuelve la lista de los puntos del turno

    private ArrayList<PowerUp> listaPowerUps(){
        ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();

        for(Jugada jugada : jugadas){
            powerUps.add(jugada.getPowerUp());
        }

        return powerUps;
    } //devuelve la lista de powerUps usados en el turno

    private void actualizarJugadas(Pregunta pregunta){
        for (Jugada jugada : jugadas) {
            jugada.actualizarJugada(pregunta);
        }
    }// se encarga de otorgar powerUp y puntos base segun respuesta de jugador

    private ArrayList<Integer> efectuarPowerUps(){
        int i=0;
        ArrayList<Integer> puntosActualizados = this.listaPuntos();
        ArrayList<PowerUp> powerUps = listaPowerUps();

        for (PowerUp powerUp: powerUps){
            puntosActualizados = powerUp.usar(puntosActualizados, i);
            i++;
        }
        return puntosActualizados;
    }// efectua los power ups y devuelve una lista de los puntos actualizados

    private void efectuarJugadas(){
        ArrayList<Integer> puntos = efectuarPowerUps();
        int i = 0;
        for (Jugada jugada : jugadas){
            jugada.actualizarPuntos(puntos.get(i));
            jugada.seUsoPowerUp();
            jugada.otorgarPuntos();
            i++;
        }
    }//elimina el powerUp de sus jugadores para que no puedan volver a usarlos y se encarga de otorgar los puntos finales a cada jugador

    @Override
    public void jugarTurno(Pregunta pregunta) {

        this.actualizarJugadas(pregunta);
        this.efectuarJugadas();

        notifyObservers(this);
    }
}
