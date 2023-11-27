package me.ztpteam.factory_method;

public class StandardShipment implements Shipment {
    @Override
    public void deliver() {
        System.out.println("Standard shipment delivered");
    }
}
