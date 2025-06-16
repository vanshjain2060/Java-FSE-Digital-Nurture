public class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Instance of the Logger created");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
