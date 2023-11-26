package me.ztpteam.template_method;

public class ConcreteOnlineShopping extends OnlineShopping {
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
        System.out.println("Making online payment");
    }

    @Override
    protected void shipProduct() {
        System.out.println("Shipping the product to the customer");
    }
}
