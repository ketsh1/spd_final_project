// Concrete Products for Abstract Factory Pattern
class SavingsAccount implements Account {
    @Override
    public void accountType() {
        System.out.println("This is a Savings Account.");
    }
}