package Week1.DesignPatterns.FactoryPatternExample.Documents;

public class ExcelDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening Excel Docs");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Docs");
    }
}
