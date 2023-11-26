package me.ztpteam.strategy;

public class ExpressShippingCostStrategy implements ShippingCostStrategy {
    @Override
    public double calculateCost(double weight) {
        return 5.0 * weight;
    }
}
