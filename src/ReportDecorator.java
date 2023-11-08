// Abstract Decorator for Decorator Pattern
abstract class ReportDecorator implements FinancialReport {
    protected FinancialReport decoratedReport;

    public ReportDecorator(FinancialReport report) {
        this.decoratedReport = report;
    }

    @Override
    public String generateReport() {
        return decoratedReport.generateReport();
    }
}
