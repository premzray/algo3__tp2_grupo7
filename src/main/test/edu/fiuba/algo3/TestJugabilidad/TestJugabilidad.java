package edu.fiuba.algo3.TestJugabilidad;

import edu.fiuba.algo3.modelo.generadorPregunta.GeneradorPreguntas;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
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
    @Mock private Jugada jugadaJ1;
    @Mock private Jugada jugadaJ2;
    @Mock private Jugada jugadaJ3;
    private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

   @Before
    public void setUp() {
       MockitoAnnotations.initMocks(this);
       preguntas.add(pregunta1);
       preguntas.add(pregunta2);
       preguntas.add(pregunta3);
       preguntas.add(pregunta4);
       jugadores.add(jugador1Mock);
       jugadores.add(jugador2Mock);

   }

    @Test
    public void test01JuegoRapidoDuraTresTurnosYGanaJugador1(){
        Juego juego = new Juego();
        ArrayList<Jugador> ordenDeVictoria = new ArrayList<Jugador>();
        ordenDeVictoria.add(jugador1Mock);
        ordenDeVictoria.add(jugador2Mock);

        juego.configurarLimitesRapidos();
        juego.setTurno(turnoMock);
        juego.setGeneradorPreguntas(generadorPreguntasMock);
        juego.agregarJugador(jugador1Mock);
        juego.agregarJugador(jugador2Mock);
        when(generadorPreguntasMock.generarPreguntas("src/main/java/edu/fiuba/algo3/modelo/preguntas.json")).thenReturn(preguntas);
        juego.inicializarPreguntas();

        when(jugador1Mock.getPuntaje()).thenReturn(20);
        when(jugador2Mock.getPuntaje()).thenReturn(14);
        when(jugador1Mock.puntajeEsMayor(20)).thenReturn(false, false, false, true);
        when(jugador2Mock.puntajeEsMayor(20)).thenReturn(false);
        juego.iniciar();

        assertEquals(juego.ordenDeJugadores(),ordenDeVictoria );
    }

    @Test
    public void test02OrdenDeJugadoresFuncionaParaMasDedosJugadores(){
        Juego juego = new Juego();
        jugadores.add(jugador3Mock);
        jugadores.add(jugador4Mock);
        ArrayList<Jugador> ordenDeVictoria = new ArrayList<Jugador>();
        ordenDeVictoria.add(jugador3Mock);
        ordenDeVictoria.add(jugador4Mock);
        ordenDeVictoria.add(jugador2Mock);
        ordenDeVictoria.add(jugador1Mock);

        juego.configurarLimitesRapidos();
        juego.setTurno(turnoMock);
        juego.setGeneradorPreguntas(generadorPreguntasMock);
        juego.agregarJugador(jugador1Mock);
        juego.agregarJugador(jugador2Mock);
        juego.agregarJugador(jugador3Mock);
        juego.agregarJugador(jugador4Mock);
        when(generadorPreguntasMock.generarPreguntas("src/main/java/edu/fiuba/algo3/modelo/preguntas.json")).thenReturn(preguntas);
        juego.inicializarPreguntas();

        when(jugador1Mock.getPuntaje()).thenReturn(4);
        when(jugador2Mock.getPuntaje()).thenReturn(6);
        when(jugador3Mock.getPuntaje()).thenReturn(16);
        when(jugador4Mock.getPuntaje()).thenReturn(11);
        juego.iniciar();

        assertEquals(juego.ordenDeJugadores(),ordenDeVictoria );
    }

}
