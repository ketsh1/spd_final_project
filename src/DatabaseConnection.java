// Singleton for Singleton Pattern
class DatabaseConnection {
    private static DatabaseConnection instance = new DatabaseConnection();

    private DatabaseConnection() {
        // private constructor to prevent instantiation
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to the database...");
    }
}
