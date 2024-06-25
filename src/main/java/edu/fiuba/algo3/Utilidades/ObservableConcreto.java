package edu.fiuba.algo3.Utilidades;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableConcreto implements Observable {
    private List<Observer> observers;

    public ObservableConcreto() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Object event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

}
