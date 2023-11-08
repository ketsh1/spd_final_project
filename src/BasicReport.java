// Concrete Component for Decorator Pattern
class BasicReport implements FinancialReport {
    @Override
    public String generateReport() {
        return "Basic Financial Data";
    }
}