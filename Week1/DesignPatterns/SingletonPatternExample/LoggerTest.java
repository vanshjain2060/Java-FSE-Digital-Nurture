public class LoggerTest {
    public static void main(String[] args) {
        System.out.println();

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        System.out.println();

        if (l1 == l2) {
            System.out.println("l1 and l2 have the common instance hence Logger class implements the Singleton pattern.");
        } else {
            System.out.println("l1 ans l2 have different instances hence Logger class does not implements the Singleton pattern.");
        }
    }
}
