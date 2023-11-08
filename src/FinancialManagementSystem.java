import java.util.Scanner;

public class FinancialManagementSystem {

    private InvestmentManager investmentManager;
    private FinancialReport report;
    private AccountFactory accountFactory;
    private PaymentProcessor paymentProcessor;

    // Constructor
    public FinancialManagementSystem() {
        // Initialize with default values
        this.investmentManager = new InvestmentManager(new ConservativeStrategy());
        this.report = new BasicReport();
        this.accountFactory = null; // No default, user will choose
        this.paymentProcessor = new PaymentAdapter(new ThirdPartyPaymentSystem());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Financial Management System. Choose an option:");
            System.out.println("1: Change Investment Strategy");
            System.out.println("2: Add Features to Report");
            System.out.println("3: Create an Account");
            System.out.println("4: Process a Payment");
            System.out.println("0: Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Change Investment Strategy
                    this.changeInvestmentStrategy(scanner);
                    break;
                case 2:
                    // Add Features to Report
                    this.addFeaturesToReport(scanner);
                    break;
                case 3:
                    // Create Account
                    this.createAccount(scanner);
                    break;
                case 4:
                    // Process Payment
                    this.processPayment(scanner);
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private void changeInvestmentStrategy(Scanner scanner) {
        System.out.println("\nSelect investment strategy:");
        System.out.println("1: Conservative");
        System.out.println("2: Aggressive");
        System.out.print("Your choice: ");

        int strategyChoice = scanner.nextInt();
        switch (strategyChoice) {
            case 1:
                this.investmentManager.changeStrategy(new ConservativeStrategy());
                break;
            case 2:
                this.investmentManager.changeStrategy(new AggressiveStrategy());
                break;
            default:
                System.out.println("Invalid choice. Using default conservative strategy.");
                this.investmentManager.changeStrategy(new ConservativeStrategy());
                break;
        }

        this.investmentManager.executeStrategy();
    }

    private void addFeaturesToReport(Scanner scanner) {
        boolean addingFeatures = true;

        while (addingFeatures) {
            System.out.println("\nChoose a feature to add to the report:");
            System.out.println("1: Tax Data");
            System.out.println("2: Graphical Data");
            System.out.println("0: Done adding features");
            System.out.print("Your choice: ");

            int featureChoice = scanner.nextInt();
            switch (featureChoice) {
                case 1:
                    this.report = new TaxReportDecorator(this.report);
                    break;
                case 2:
                    //this.report = new GraphicalReportDecorator(this.report);
                    break;
                case 0:
                    addingFeatures = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        System.out.println("Final Report: " + this.report.generateReport());
    }

    private void createAccount(Scanner scanner) {
        System.out.println("\nChoose account type:");
        System.out.println("1: Savings Account");
        System.out.println("2: Checking Account");
        System.out.print("Your choice: ");

        int accountType = scanner.nextInt();
        switch (accountType) {
            case 1:
                this.accountFactory = new SavingsAccountFactory();
                break;
            case 2:
                this.accountFactory = new CheckingAccountFactory();
                break;
            default:
                System.out.println("Invalid choice. No account created.");
                return;
        }

        Account account = this.accountFactory.createAccount();
        account.accountType();
    }

    private void processPayment(Scanner scanner) {
        System.out.print("\nEnter the payment amount: $");
        double amount = scanner.nextDouble();
        this.paymentProcessor.processPayment(amount);
    }

    public static void main(String[] args) {
        FinancialManagementSystem system = new FinancialManagementSystem();
        system.run();
    }
}
