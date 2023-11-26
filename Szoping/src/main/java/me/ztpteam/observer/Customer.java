package me.ztpteam.observer;

public class Customer implements ShipmentObserver {

    private String name;
    public Customer(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + ": " + message);
    }
}
