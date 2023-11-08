// Adapter for Adapter Pattern
class PaymentAdapter implements PaymentProcessor {
    private ThirdPartyPaymentSystem thirdPartyPaymentSystem;

    public PaymentAdapter(ThirdPartyPaymentSystem system) {
        this.thirdPartyPaymentSystem = system;
    }

    @Override
    public void processPayment(double amount) {
        int cents = (int) (amount * 100);
        thirdPartyPaymentSystem.makePayment(cents);
    }
}