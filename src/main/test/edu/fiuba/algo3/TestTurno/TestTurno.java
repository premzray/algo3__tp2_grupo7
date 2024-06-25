package edu.fiuba.algo3.TestTurno;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Turno;
import edu.fiuba.algo3.modelo.juego.TurnoTp;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestTurno {
    @Mock
    private Jugada jugada1;
    @Mock
    private Jugada jugada2;
    @Mock
    private Pregunta pregunta;
    private PowerUp powerUp1;
    private PowerUp powerUp2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01TurnoDondeNoSeJugoNingunPowerUpYAmbosSumanPuntos() {
        powerUp1 = PowerUp.deTipo("BASE");
        powerUp2 = PowerUp.deTipo("BASE");
        Turno turno = Turno.conJugadores(new ArrayList<Jugador>());
        turno.agregarJugada(jugada1);
        turno.agregarJugada(jugada2);
        ArrayList<Integer> puntosPrevios = new ArrayList<Integer>();
        ArrayList<Integer> puntosActualizados = new ArrayList<Integer>();
        ArrayList<Integer> puntosActualizados2 = new ArrayList<Integer>();
        puntosPrevios.add(3);
        puntosPrevios.add(1);
        puntosActualizados.add(3);
        puntosActualizados.add(1);
        puntosActualizados2.add(3);
        puntosActualizados2.add(1);

        when(jugada1.getPuntaje()).thenReturn(puntosPrevios.get(0));
        when(jugada2.getPuntaje()).thenReturn(puntosPrevios.get(1));
        when(jugada1.getPowerUp()).thenReturn(powerUp1);
        when(jugada2.getPowerUp()).thenReturn(powerUp2);

        turno.jugarTurno(pregunta);

        verify(jugada1).actualizarPuntos(puntosActualizados2.get(0));
        verify(jugada2).actualizarPuntos(puntosActualizados2.get(1));

    }

    @Test
    public void test02TurnoDondeSeJuegaUnPowerUpYUnoSumaPuntos() {
        powerUp1 = PowerUp.deTipo("EXCLUSIVIDAD");
        powerUp2 = PowerUp.deTipo("BASE");
        Turno turno = Turno.conJugadores(new ArrayList<Jugador>());
        turno.agregarJugada(jugada1);
        turno.agregarJugada(jugada2);
        ArrayList<Integer> puntosPrevios = new ArrayList<Integer>();
        ArrayList<Integer> puntosActualizados = new ArrayList<Integer>();
        ArrayList<Integer> puntosActualizados2 = new ArrayList<Integer>();
        puntosPrevios.add(1);
        puntosPrevios.add(0);
        puntosActualizados.add(2);
        puntosActualizados.add(0);
        puntosActualizados2.add(2);
        puntosActualizados2.add(0);

        when(jugada1.getPuntaje()).thenReturn(puntosPrevios.get(0));
        when(jugada2.getPuntaje()).thenReturn(puntosPrevios.get(1));
        when(jugada1.getPowerUp()).thenReturn(powerUp1);
        when(jugada2.getPowerUp()).thenReturn(powerUp2);

        turno.jugarTurno(pregunta);

        verify(jugada1).actualizarPuntos(puntosActualizados2.get(0));
        verify(jugada2).actualizarPuntos(puntosActualizados2.get(1));
    }

    @Test
    public void test03TurnoDondeSeJueganDosPowerUpsUnJugadorSumaYOtroResta() {
        Turno turno = Turno.conJugadores(new ArrayList<Jugador>());
        powerUp1 = PowerUp.deTipo("MULTIPLICADOR", 2);
        powerUp2 = PowerUp.deTipo("MULTIPLICADOR", 3);
        turno.agregarJugada(jugada1);
        turno.agregarJugada(jugada2);
        ArrayList<Integer> puntosPrevios = new ArrayList<Integer>();
        ArrayList<Integer> puntosActualizados = new ArrayList<Integer>();
        ArrayList<Integer> puntosActualizados2 = new ArrayList<Integer>();
        puntosPrevios.add(2);
        puntosPrevios.add(-1);
        puntosActualizados.add(4);
        puntosActualizados.add(-1);
        puntosActualizados2.add(4);
        puntosActualizados2.add(-3);

        when(jugada1.getPuntaje()).thenReturn(puntosPrevios.get(0));
        when(jugada2.getPuntaje()).thenReturn(puntosPrevios.get(1));
        when(jugada1.getPowerUp()).thenReturn(powerUp1);
        when(jugada2.getPowerUp()).thenReturn(powerUp2);

        turno.jugarTurno(pregunta);

        verify(jugada1).actualizarPuntos(puntosActualizados2.get(0));
        verify(jugada2).actualizarPuntos(puntosActualizados2.get(1));
    }

}
