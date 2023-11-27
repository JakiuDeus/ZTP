package me.ztpteam.factory_method;

public class ExpressShipment implements Shipment {
    @Override
    public void deliver() {
        System.out.println("Express shipment delivered");
    }
}
