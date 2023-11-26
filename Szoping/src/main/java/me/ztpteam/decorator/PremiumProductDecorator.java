package me.ztpteam.decorator;

public class PremiumProductDecorator extends ProductDecorator {
    public PremiumProductDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        addPremiumFeatures();
    }

    private void addPremiumFeatures() {
        System.out.println("Premium features added");
    }
}
