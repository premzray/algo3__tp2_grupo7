package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.Utilidades.ObservableConcreto;
import edu.fiuba.algo3.modelo.generadorPregunta.GeneradorPreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.*;

public class Juego extends ObservableConcreto {
    Turno turno;
    ArrayList<Jugador> jugadores = new ArrayList<Jugador>();;
    List<Pregunta> preguntas = new ArrayList<Pregunta>();
    int limitePreguntas;
    int limitePuntos;
    GeneradorPreguntas generadorPreguntas = GeneradorPreguntas.crear();

    public void setTurno(Turno turno){
        this.turno = turno;
    }

    public void setGeneradorPreguntas(GeneradorPreguntas generadorPreguntas) {
        this.generadorPreguntas = generadorPreguntas;
    }

    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }

    private void configurarLimites(int limitePreguntas, int limitePuntos){
        this.limitePreguntas = limitePreguntas;
        this.limitePuntos = limitePuntos;
    }

    private void inicializarJugadores(ArrayList<String> nombres){
        if(nombres.size()<=1){
            //excepcion
        }
        for(int i=0; i< nombres.size(); i++){
            this.agregarJugador(Jugador.conNombre(nombres.get(i)));
        }
    } //inicializa los jugadores

    public void configurarLimitesIntensivos(){
        this.configurarLimites(25, 40);
    }

    public void configurarLimitesRapidos(){
        this.configurarLimites(10, 20);
    }

    public void inicializarPreguntas(){
        this.preguntas = generadorPreguntas.generarPreguntas("src/main/java/edu/fiuba/algo3/modelo/preguntas.json");
    }

    public void setTurnoConvencional(ArrayList<String> nombres){
        this.inicializarJugadores(nombres);
        setTurno(Turno.conJugadores(jugadores));
    }

    private boolean fin(int cantPreguntas){
        return (!preguntas.isEmpty() && cantPreguntas <= this.limitePreguntas && !this.pasarsePuntos());
    } //evalua si el juego puede continuar otro turno

    private boolean pasarsePuntos(){
        for(Jugador jugador : jugadores){
            if(jugador.puntajeEsMayor(limitePuntos)){
                return true;
            }
        }
        return false;
    }//evalua si alguien se paso del limite de puntos

    public void settearJuego(){
        notifyObservers(this);
    }

    public void settearJugadores(){
        notifyObservers(this);
    }

    public void iniciar(){
        int cantPreguntas = 0;
        Pregunta pregunta;

        while(fin(cantPreguntas)){
            pregunta = this.preguntas.get(0);
            turno.jugarTurno(pregunta);
            cantPreguntas++;

            preguntas.remove(pregunta);
        }
        notifyObservers(this);
    }

    public ArrayList<Jugador> ordenDeJugadores(){
        ArrayList<Jugador> jugadoresOrdenados = jugadores;
        jugadoresOrdenados.sort(new ComparatorJugador());
        return jugadoresOrdenados;
    }
}
