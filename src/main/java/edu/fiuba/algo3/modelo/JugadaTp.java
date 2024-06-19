package edu.fiuba.algo3.modelo;

public class JugadaTp implements Jugada{
    private final Jugador jugador;
    private PowerUp powerUp;
    private int puntaje;
    private Pregunta pregunta;

    public JugadaTp(Jugador jugador){
        this.jugador = jugador;
        this.powerUp = new Base();
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
    public void registrarJugada(Respuestas respuestaJugador, PowerUp powerUpJugador){
        if(this.powerUpValido(powerUpJugador)) {
            this.powerUp = powerUpJugador;
            this.puntaje = this.pregunta.puntuarRespuesta(respuestaJugador);
        } else{
            //excepcion
        }
    } //metodo usado por el observador para settear lo elegido por el jugador

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
        //notificar que un jugador debe responder una pregunta (esto settea el powerUp usado y la respuesta del jugador
        // usando registrarJugada)
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
