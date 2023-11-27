package me.ztpteam;


import me.ztpteam.command.Command;
import me.ztpteam.command.CommandInvoker;
import me.ztpteam.command.ShipmentCommand;
import me.ztpteam.decorator.BasicProduct;
import me.ztpteam.decorator.PremiumProductDecorator;
import me.ztpteam.decorator.Product;
import me.ztpteam.factory_method.ShipmentFactory;
import me.ztpteam.factory_method.StandardShipment;
import me.ztpteam.factory_method.StandardShipmentFactory;
import me.ztpteam.gui_stuff.Main;
import me.ztpteam.strategy.ShippingCostStrategy;
import me.ztpteam.strategy.StandardShippingCostStrategy;
import me.ztpteam.template_method.ConcreteOnlineShopping;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ShipmentFactory shipmentFactory = new StandardShipmentFactory();
        ShippingCostStrategy shippingCostStrategy = new StandardShippingCostStrategy();
        CommandInvoker commandInvoker = new CommandInvoker();
        Command shipmentCommand = new ShipmentCommand(new StandardShipment());
        Product decoratedProduct = new PremiumProductDecorator(new BasicProduct());
        ConcreteOnlineShopping shopping = new ConcreteOnlineShopping(shipmentFactory, shippingCostStrategy, commandInvoker, shipmentCommand, decoratedProduct);
        new Main();
        shopping.shop();
    }
}
