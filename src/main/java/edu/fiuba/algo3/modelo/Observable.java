package edu.fiuba.algo3.modelo;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Object event);
}
