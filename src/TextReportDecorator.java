// Concrete Decorator for Decorator Pattern
class TaxReportDecorator extends ReportDecorator {
    public TaxReportDecorator(FinancialReport report) {
        super(report);
    }

    @Override
    public String generateReport() {
        return super.generateReport() + " + Tax Data";
    }
}