// Concrete Strategies for Strategy Pattern
class ConservativeStrategy implements InvestmentStrategy {
    @Override
    public void execute() {
        System.out.println("Executing conservative strategy.");
    }
}