// Concrete Factories for Abstract Factory Pattern
class SavingsAccountFactory implements AccountFactory {
    @Override
    public Account createAccount() {
        return new SavingsAccount();
    }
}