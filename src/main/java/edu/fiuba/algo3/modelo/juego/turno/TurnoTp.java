package edu.fiuba.algo3.modelo.juego.turno;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.juego.jugador.Jugador;
import edu.fiuba.algo3.modelo.juego.jugador.exceptions.JugadorNoTienePowerUpABorrarException;
import edu.fiuba.algo3.modelo.juego.turno.exceptions.FaltanRespuestasDeJugadoresException;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public class TurnoTp implements Turno{
    public ArrayList<Jugada> jugadas = new ArrayList<Jugada>();

    public TurnoTp(ArrayList<Jugador> jugadores){
        this.inicializarJugadas(jugadores);
    }

    private void inicializarJugadas(ArrayList<Jugador> jugadores){
        for(Jugador jugador : jugadores){
            jugadas.add(Jugada.deJugador(jugador));
        }
    } //inicializa las jugadas

    @Override
    public Jugada getSiguienteJugada(){
        for (Jugada jugada : jugadas()) {
            if (!jugada.yaSeJugo()) {
                return jugada;
            }
        }
        return jugadas.get(0);//excepcion
    } //devuelve la proxima jugada que se pueda jugar

    @Override
    public boolean hayProximaJugada(){
        for (Jugada jugada : jugadas) {
            if (!jugada.yaSeJugo()) {
                return true;
            }
        }
        return false;
    } //devuelve si hay proxima jugada que se pueda jugar

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

    private void efectuarJugadas() throws JugadorNoTienePowerUpABorrarException {
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
    public void jugarTurno() throws FaltanRespuestasDeJugadoresException, JugadorNoTienePowerUpABorrarException {
        if(hayProximaJugada()){
            throw new FaltanRespuestasDeJugadoresException();
        }
        this.efectuarJugadas();
    } //efectua las jugadas de los jugadores

    @Override
    public void actualizarTurno(Pregunta pregunta){
        for (Jugada jugada : jugadas) {
            jugada.actualizarJugada(pregunta);
        }
    } //actualiza las jugadas para un nuevo turno

    @Override
    public ArrayList<Jugada> jugadas(){
        return this.jugadas;
    } //devuelve las jugadas
}
