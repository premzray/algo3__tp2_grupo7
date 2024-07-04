package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.juego.jugador.Jugador;
import edu.fiuba.algo3.modelo.juego.jugador.exceptions.JugadorNoTienePowerUpABorrarException;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public interface Jugada  {
    public static Jugada deJugador(Jugador jugador){
        return new JugadaTp(jugador);
    }

    public void actualizarJugada(Pregunta pregunta);

    public void actualizarPuntos(int puntosNuevos);

    public void otorgarPuntos();

    public int getPuntaje();

    public PowerUp getPowerUp();

    public void seUsoPowerUp() throws JugadorNoTienePowerUpABorrarException;

    public void registrarRespuesta(Respuestas respuestaJugador);

    public void registrarPowerUp(PowerUp powerUp);

    public void seJugo();

    public boolean yaSeJugo();

    public Pregunta getPregunta();

    public Jugador getJugador();
}
