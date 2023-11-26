package me.ztpteam.strategy;

public class StandardShippingCostStrategy implements ShippingCostStrategy {
    @Override
    public double calculateCost(double weight) {
        return 2.0 * weight;
    }
}
