package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Juego extends ObservableConcreto {
    Turno turno;
    ArrayList<Jugador> jugadores;
    List<Pregunta> preguntas;
    int limitePreguntas;
    int limitePuntos;

    public void inicializarJuego(ArrayList<String> nombres){
        this.inicializarJugadores(nombres);

        this.turno = Turno.conJugadores(jugadores); //justificar que crea el TurnoTp y no un turno pasado por parametro pq en este caso es lo unico que nos importa

        this.inicializarPreguntas();
    }

    private void configurarLimites(int limitePreguntas, int limitePuntos){
        this.limitePreguntas = limitePreguntas;
        this.limitePuntos = limitePuntos;
    }

    public void configurarLimitesIntensivos(){
        this.configurarLimites(25, 40);
    }

    public void configurarLimitesRapidos(){
        this.configurarLimites(10, 20);
    }

    private void inicializarPreguntas(){
        this.preguntas = GeneradorPreguntas.generarPreguntas("src/main/java/edu/fiuba/algo3/modelo/preguntas.json");
    }

    private void inicializarJugadores(ArrayList<String> nombres){
        this.jugadores = new ArrayList<Jugador>();
        if(nombres.size()<=1){
            //excepcion
        }
        for(int i=0; i< nombres.size(); i++){
            this.jugadores.add(Jugador.conNombre(nombres.get(i)));
        }
    } //inicializa los jugadores

    private boolean fin(int cantPreguntas){
        return (!preguntas.isEmpty() || cantPreguntas <= this.limitePreguntas || this.pasarsePuntos());
    } //evalua si el juego puede continuar otro turno

    private boolean pasarsePuntos(){
        for(Jugador jugador : jugadores){
            if(jugador.puntajeEsMayor(limitePuntos)){
                return true;
            }
        }
        return false;
    }//evalua si alguien se paso del limite de puntos

    private Pregunta preguntaRandom(){
        return preguntas.get((int)(Math.random()*(preguntas.size())));
    } //de la lista de preguntas, elige una random

    public void settearJuego(){
        notifyObservers(this);
    }

    public void settearJugadores(){
        notifyObservers(this);
    }

    public void iniciar(){
        int cantPreguntas = 0;
        Pregunta pregunta = this.preguntaRandom();

        while(!fin(cantPreguntas)){
            turno.jugarTurno(pregunta);

            preguntas.remove(pregunta);
            pregunta = this.preguntaRandom();
            cantPreguntas++;
        }
        notifyObservers(this);
    }

    /*/public ArrayList<Jugador> ordenDeJugadores(){
        //insertar un algoritmo que ordene los jugadores de mayor a menor puntos y devuelva esa lista
    }/*/
}
