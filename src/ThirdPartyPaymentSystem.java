// Adaptee for Adapter Pattern
class ThirdPartyPaymentSystem {
    public void makePayment(int cents) {
        System.out.println("Making a payment of " + cents + " cents using the third-party system.");
    }
}