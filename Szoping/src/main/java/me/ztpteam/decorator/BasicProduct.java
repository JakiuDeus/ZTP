package me.ztpteam.decorator;

public class BasicProduct implements Product {
    @Override
    public void displayInfo() {
        System.out.println("Basic product");
    }
}
