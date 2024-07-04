package edu.fiuba.algo3.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// Clase para manejar múltiples eventos
public class EventHandlerCompuesto implements EventHandler<ActionEvent> {
    private final EventHandler<ActionEvent> firstHandler;
    private final EventHandler<ActionEvent> secondHandler;

    public EventHandlerCompuesto(EventHandler<ActionEvent> firstHandler, EventHandler<ActionEvent> secondHandler) {
        this.firstHandler = firstHandler;
        this.secondHandler = secondHandler;
    }

    @Override
    public void handle(ActionEvent event) {
        firstHandler.handle(event);
        secondHandler.handle(event);
    }
}