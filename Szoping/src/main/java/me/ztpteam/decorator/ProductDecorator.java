package me.ztpteam.decorator;

public abstract class ProductDecorator implements Product {
    protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public void displayInfo() {
        decoratedProduct.displayInfo();
    }
}
