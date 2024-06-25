package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ObservableConcreto;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public class TurnoTp extends ObservableConcreto implements Turno{
    ArrayList<Jugada> jugadas;

    public TurnoTp(ArrayList<Jugador> jugadores){
        this.inicializarJugadas(jugadores);
    }

    private void inicializarJugadas(ArrayList<Jugador> jugadores){
        this.jugadas = new ArrayList<Jugada>();

        for(Jugador jugador : jugadores){
            this.jugadas.add(Jugada.deJugador(jugador));
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

        for (PowerUp powerUp: this.listaPowerUps()){
            powerUp.usar(puntosActualizados, i);
            i++;
        }
        return puntosActualizados;
    }// efectua los power ups y devuelve una lista de los puntos actualizados

    private void efectuarJugadas(){
        int i = 0;
        for (Jugada jugada : jugadas){
            jugada.actualizarPuntos(this.efectuarPowerUps().get(i));
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
