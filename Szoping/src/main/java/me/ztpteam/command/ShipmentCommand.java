package me.ztpteam.command;

import me.ztpteam.factory_method.Shipment;

public class ShipmentCommand implements Command {
    private Shipment shipment;

    public ShipmentCommand(Shipment shipment) {
        this.shipment = shipment;
    }
    @Override
    public void execute() {
        shipment.deliver();
    }
}
