package edu.fiuba.algo3.TestJugabilidad;

import edu.fiuba.algo3.modelo.generadorPregunta.GeneradorPreguntas;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.juego.jugador.Jugador;
import edu.fiuba.algo3.modelo.juego.turno.Turno;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class TestJugabilidad {

    @Mock private Turno turnoMock;
    @Mock private Jugador jugador1Mock;
    @Mock private Jugador jugador2Mock;
    @Mock private Jugador jugador3Mock;
    @Mock private Jugador jugador4Mock;
    @Mock private GeneradorPreguntas generadorPreguntasMock;
    @Mock private Pregunta pregunta1;
    @Mock private Pregunta pregunta2;
    @Mock private Pregunta pregunta3;
    @Mock private Pregunta pregunta4;
    @Mock private Pregunta pregunta5;
    @Mock private Pregunta pregunta6;
    @Mock private Pregunta pregunta7;
    @Mock private Jugada jugadaJ1;
    @Mock private Jugada jugadaJ2;
    @Mock private Jugada jugadaJ3;
    @Mock private Jugada jugadaJ4;
    @Mock private Respuestas respuesta1;
    @Mock private Respuestas respuesta2;
    private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

   @Before
    public void setUp() {
       MockitoAnnotations.initMocks(this);
       preguntas.add(pregunta1);
       preguntas.add(pregunta2);
       preguntas.add(pregunta3);
       preguntas.add(pregunta4);
       preguntas.add(pregunta5);
       preguntas.add(pregunta7);
       preguntas.add(pregunta6);
       jugadores.add(jugador1Mock);
       jugadores.add(jugador2Mock);

   }

    @Test
    public void test01JuegoRapidoDuraTresTurnosYGanaJugador1(){
        Juego juego = new Juego();
        ArrayList<Jugador> ordenDeVictoria = new ArrayList<Jugador>();
        ordenDeVictoria.add(jugador1Mock);
        ordenDeVictoria.add(jugador2Mock);

        juego.setModo("RAPIDO");
        juego.turno = (turnoMock);
        juego.generadorPreguntas = (generadorPreguntasMock);
        juego.jugadores.add(jugador1Mock);
        juego.jugadores.add(jugador2Mock);
        when(generadorPreguntasMock.generarPreguntas("src/main/java/edu/fiuba/algo3/modelo/preguntas.json")).thenReturn(preguntas);
        juego.inicializarPreguntas();

        when(jugador1Mock.getPuntaje()).thenReturn(20);
        when(jugador2Mock.getPuntaje()).thenReturn(14);
        when(jugador1Mock.puntajeEsMayor(20)).thenReturn(false, false, false, true);
        when(jugador2Mock.puntajeEsMayor(20)).thenReturn(false);

        juego.prepararTurno();
        juego.finDeTurno();

        assertEquals(juego.ordenDeJugadores(),ordenDeVictoria );
    }

    @Test
    public void test02JuegoRapidoDura7TurnosYGanaJugador3(){
        Juego juego = new Juego();
        jugadores.add(jugador3Mock);
        jugadores.add(jugador4Mock);
        ArrayList<Jugador> ordenDeVictoria = new ArrayList<Jugador>();
        ordenDeVictoria.add(jugador3Mock);
        ordenDeVictoria.add(jugador4Mock);
        ordenDeVictoria.add(jugador2Mock);
        ordenDeVictoria.add(jugador1Mock);

        juego.setModo("RAPIDO");
        juego.turno = (turnoMock);
        juego.generadorPreguntas = (generadorPreguntasMock);
        juego.jugadores.add(jugador1Mock);
        juego.jugadores.add(jugador2Mock);
        juego.jugadores.add(jugador3Mock);
        juego.jugadores.add(jugador4Mock);
        when(generadorPreguntasMock.generarPreguntas("src/main/java/edu/fiuba/algo3/modelo/preguntas.json")).thenReturn(preguntas);
        juego.inicializarPreguntas();

        when(jugador1Mock.getPuntaje()).thenReturn(4);
        when(jugador2Mock.getPuntaje()).thenReturn(6);
        when(jugador3Mock.getPuntaje()).thenReturn(16);
        when(jugador4Mock.getPuntaje()).thenReturn(11);

        juego.prepararTurno();
        juego.finDeTurno();

        assertEquals(juego.ordenDeJugadores(),ordenDeVictoria );
    }
}
