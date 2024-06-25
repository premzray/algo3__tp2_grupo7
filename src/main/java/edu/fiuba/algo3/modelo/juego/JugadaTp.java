package edu.fiuba.algo3.modelo.juego;


import edu.fiuba.algo3.Utilidades.ObservableConcreto;
import edu.fiuba.algo3.modelo.pregunta.Respuestas;
import edu.fiuba.algo3.modelo.powerup.PowerUp;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public class JugadaTp extends ObservableConcreto implements Jugada{
    private final Jugador jugador;
    private PowerUp powerUp;
    private int puntaje;
    private Pregunta pregunta;

    public JugadaTp(Jugador jugador){
        this.jugador = jugador;
        this.powerUp = PowerUp.deTipo("BASE");
        this.puntaje = 0;
    }

    private void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    private boolean powerUpValido(PowerUp powerUpAValidar){
        return pregunta.powerUpValido(powerUpAValidar) && jugador.tenesPowerUp(powerUpAValidar);
    } //valida que el jugador tenga el powerUp y que la pregunta lo admita

    @Override
    public void seUsoPowerUp(){
        this.jugador.usastePowerUp(this.powerUp);
    } //le comunica al jugador que ya uso ese powerUp para que lo elimine

    @Override
    public void registrarRespuesta(Respuestas respuestaJugador){
        this.puntaje = this.pregunta.puntuarRespuesta(respuestaJugador);
    } //metodo usado por el observador para settear lo elegido por el jugador

    @Override
    public void registrarPowerUp(PowerUp powerUpJugador){
        if(this.powerUpValido(powerUpJugador)) {
            this.powerUp = powerUpJugador;
        } else {
            //excepcion
        }
    }

    @Override
    public PowerUp getPowerUp(){
        return this.powerUp;
    }

    @Override
    public int getPuntaje(){
        return this.puntaje;
    }

    @Override
    public void actualizarJugada(Pregunta pregunta){
        setPregunta(pregunta);
        pregunta.mostrarPregunta();
        jugador.mostrarPowerUps();
        notifyObservers(this);
    }

    @Override
    public void actualizarPuntos(int puntosNuevos){
        this.puntaje = puntosNuevos;
    }

    @Override
    public void otorgarPuntos(){
        jugador.actualizarPuntaje(puntaje);
    }

}
