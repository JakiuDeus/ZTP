package me.ztpteam.adapter;

public class PaymentAdapter implements PaymentGateway {
    private CreditCardProcessor creditCardProcessor;

    public PaymentAdapter(CreditCardProcessor creditCardProcessor) {
        this.creditCardProcessor = creditCardProcessor;
    }
    @Override
    public void processPayment(double amount) {
        creditCardProcessor.chargeCreditCard(amount);
    }
}
