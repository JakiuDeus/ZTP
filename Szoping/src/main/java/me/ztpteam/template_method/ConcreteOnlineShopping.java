package me.ztpteam.template_method;

import me.ztpteam.adapter.PayPal;
import me.ztpteam.adapter.PaymentGateway;
import me.ztpteam.command.Command;
import me.ztpteam.command.CommandInvoker;
import me.ztpteam.decorator.Product;
import me.ztpteam.factory_method.Shipment;
import me.ztpteam.factory_method.ShipmentFactory;
import me.ztpteam.strategy.ShippingCostStrategy;

import java.util.List;

public class ConcreteOnlineShopping extends OnlineShopping {
    private ShipmentFactory shipmentFactory;
    private ShippingCostStrategy shippingCostStrategy;
    private CommandInvoker commandInvoker;
    private Command shipmentCommand;
    private Product decoratedProduct;

    public ConcreteOnlineShopping(ShipmentFactory shipmentFactory, ShippingCostStrategy shippingCostStrategy, CommandInvoker commandInvoker, Command shipmentCommand, Product decoratedProduct) {
        this.shipmentFactory = shipmentFactory;
        this.shippingCostStrategy = shippingCostStrategy;
        this.commandInvoker = commandInvoker;
        this.shipmentCommand = shipmentCommand;
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    protected void browseProducts() {
        System.out.println("Browsing products");
    }

    @Override
    protected void selectProduct() {
        System.out.println("Selecting a product");
    }

    @Override
    protected void makePayment() {
        PaymentGateway paymentGateway = new PayPal();
        paymentGateway.processPayment(shippingCostStrategy.calculateCost(2.5));
    }

    @Override
    protected void shipProduct() {
        Shipment shipment = shipmentFactory.createShipment();
        commandInvoker.setCommand(shipmentCommand);
        commandInvoker.executeCommand();
        decoratedProduct.displayInfo();
    }
}
