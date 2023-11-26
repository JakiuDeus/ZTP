package me.ztpteam.observer;

import java.util.ArrayList;
import java.util.List;

public class ShipmentTracker {
    private List<ShipmentObserver> observers = new ArrayList<>();

    public void addObserver(ShipmentObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ShipmentObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (ShipmentObserver observer : observers) {
            observer.update(message);
        }
    }
}
