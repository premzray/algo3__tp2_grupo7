package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {
    Turno turno;
    ArrayList<Jugador> jugadores;
    ArrayList<Pregunta> preguntas;
    int limitePreguntas;
    int limitePuntos;

    public Juego(int cantidadJugadores, int limitePreguntas, int limitePuntos, ArrayList<String> nombres){
        this.limitePreguntas = limitePreguntas;
        this.limitePuntos = limitePuntos;

        this.jugadores = new ArrayList<Jugador>();
        if(cantidadJugadores<=1){
            //excepcion
        }
        for(int i=0; i<= cantidadJugadores-1; i++){
            this.jugadores.add(new Jugador(nombres.get(i)));
        } //se encarga de crear los jugadores

        this.turno = new Turno(this.jugadores); //crea el turno que se va actualizando en cada ronda

        this.preguntas = new ArrayList<Pregunta>();
        //Generador de preguntas
    }

    private boolean fin(int cantPreguntas){
        return (!preguntas.isEmpty() || cantPreguntas <= this.limitePreguntas || this.pasarsePuntos());
    } //evalua si el juego puede continuar otro turno

    private boolean pasarsePuntos(){
        for(Jugador jugador: jugadores){
            if(jugador.getPuntaje() >= limitePuntos){
                return true;
            }
        }
        return false;
    }//evalua si alguien se paso del limite de puntos

    private Pregunta preguntaRandom(){
        return preguntas.get((int)(Math.random()*(preguntas.size())));
    } //de la lista de preguntas, elige una random

    public void iniciar(){
        int cantPreguntas = 0;
        Pregunta pregunta = this.preguntaRandom();

        while(!fin(cantPreguntas)){
            turno.jugarTurno(pregunta);

            preguntas.remove(pregunta);
            pregunta = this.preguntaRandom();
            cantPreguntas++;
        }
        //notificar fin de juego a observadores (mostrar pantalla de fin de juego)
    }

    /*/public ArrayList<Jugador> ordenDeJugadores(){
        //insertar un algoritmo que ordene los jugadores de mayor a menor puntos y devuelva esa lista
    }/*/
}
