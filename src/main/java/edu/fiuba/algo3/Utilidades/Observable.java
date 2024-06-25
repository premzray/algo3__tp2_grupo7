package edu.fiuba.algo3.Utilidades;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Object event);
}
