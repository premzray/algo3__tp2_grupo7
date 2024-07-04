package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.generadorPregunta.GeneradorPreguntas;
import edu.fiuba.algo3.modelo.juego.Jugada.Jugada;
import edu.fiuba.algo3.modelo.juego.exceptions.NoHayJugadoresException;
import edu.fiuba.algo3.modelo.juego.jugador.Jugador;
import edu.fiuba.algo3.modelo.juego.jugador.exceptions.JugadorNoTienePowerUpABorrarException;
import edu.fiuba.algo3.modelo.juego.selectorPreguntas.ISelectorPreguntas;
import edu.fiuba.algo3.modelo.juego.turno.Turno;
import edu.fiuba.algo3.modelo.juego.turno.exceptions.FaltanRespuestasDeJugadoresException;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.*;

public class Juego{
    int cantidadTurnos;
    public ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    public Turno turno;
    List<Pregunta> preguntas = new ArrayList<Pregunta>();
    int limitePreguntas;
    int limitePuntos;
    public GeneradorPreguntas generadorPreguntas;
    public ISelectorPreguntas selectorPreguntas;

    private void configurarLimites(int limitePreguntas, int limitePuntos){
        this.limitePreguntas = limitePreguntas;
        this.limitePuntos = limitePuntos;
    } //PRIVADO configura los limites del juego

    private void inicializarJugadores(ArrayList<String> nombres) throws NoHayJugadoresException {
        if(nombres.size()<=1){
            throw new NoHayJugadoresException();
        } else{
            Jugador jugadorNuevo;
            for(String nombre: nombres){
                jugadorNuevo = Jugador.conNombre(nombre);
                jugadores.add(jugadorNuevo);
            }
        }
    } //PRIVADO inicializa los jugadores

    private void setGeneradorPreguntas(GeneradorPreguntas generadorPreguntas) {
        this.generadorPreguntas = generadorPreguntas;
    } //PRIVADO configura el generadordepreg


    private void ordenarPreguntas(){
        this.preguntas = selectorPreguntas.OrdenarPreguntas(this.preguntas);
    }

    private boolean pasarsePuntos(){
        for(Jugador jugador : jugadores){
            if(jugador.puntajeEsMayor(limitePuntos)){
                return true;
            }
        }
        return false;
    }//PRIVADO evalua si alguien se paso del limite de puntos

    public void setModo(String modo){
        if(Objects.equals(modo, "RAPIDO")){
            this.configurarLimites(10, 15);
        } else{
            this.configurarLimites(25, 40);
        }
    } //Settea el modo de juego segun String

    public void inicializarPreguntas(){
        this.preguntas = generadorPreguntas.generarPreguntas("src/main/java/edu/fiuba/algo3/modelo/generadorPregunta/preguntas.json");
        //this.preguntas = this.selectorPreguntas.OrdenarPreguntas(this.preguntas);
    } //inicializa las preguntas con el generador

    public boolean fin(){
        return (!preguntas.isEmpty() && cantidadTurnos <= this.limitePreguntas && !this.pasarsePuntos());
    } //evalua si el juego puede continuar otro turno

    public Pregunta preguntaActual(){
        return (preguntas.get(0));
    }//devuelve la pregunta actual

    public ArrayList<Jugador> ordenDeJugadores(){
        ArrayList<Jugador> jugadoresOrdenados = jugadores;
        jugadoresOrdenados.sort(new ComparatorJugador());
        return jugadoresOrdenados;
    } //devuelve los jugadores en orden de puntos de mayor a menor

    public boolean hayProximaJugada(){
        return turno.hayProximaJugada();
    } //evalua si hay proxima jugada dentro de un turno (si existe alguna jugada que no se haya hecho)

    public Jugada getSiguienteJugada() {
        return turno.getSiguienteJugada();
    } //obtiene la siguiente jugada que no se haya hecho

    public void setTurnoConvencional(ArrayList<String> nombres) throws NoHayJugadoresException {
        setGeneradorPreguntas(GeneradorPreguntas.crear());
        this.selectorPreguntas = ISelectorPreguntas.crear();
        this.inicializarJugadores(nombres);
        this.turno = Turno.conJugadores(jugadores);
        this.inicializarPreguntas();
        this.cantidadTurnos = 0;
    } //settea lo convencional y crea las jugadas

    public void prepararTurno(){
        Pregunta pregunta = preguntas.get(0);
        turno.actualizarTurno(pregunta);
    } //actualiza la pregunta y las jugadas

    public ArrayList<Jugada> jugadas() {
        return turno.jugadas();
    } //devuelve la lista de jugadas

    public void finDeTurno() throws FaltanRespuestasDeJugadoresException, JugadorNoTienePowerUpABorrarException {
        turno.jugarTurno();
        this.preguntas.remove(0);
        this.cantidadTurnos++;
    }
}
