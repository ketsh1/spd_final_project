// Context for Strategy Pattern
class InvestmentManager {
    private InvestmentStrategy strategy;

    public InvestmentManager(InvestmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeStrategy(InvestmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}