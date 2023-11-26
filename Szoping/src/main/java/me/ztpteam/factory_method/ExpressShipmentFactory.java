package me.ztpteam.factory_method;

public class ExpressShipmentFactory implements ShipmentFactory {
    @Override
    public Shipment createShipment() {
        return new ExpressShipment();
    }
}
