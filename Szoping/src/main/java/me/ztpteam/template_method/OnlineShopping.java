package me.ztpteam.template_method;

public abstract class OnlineShopping {
    public final void shop() {
        browseProducts();
        selectProduct();
        makePayment();
        shipProduct();
    }

    protected abstract void browseProducts();
    protected abstract void selectProduct();
    protected abstract void makePayment();
    protected abstract void shipProduct();
}
